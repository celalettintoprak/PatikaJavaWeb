package Java102.FiksturOlusturucu;

/*
  Fikstür Oluşturucu
  Java ile girilen takımlar için rastgele maç fikstürü oluşturan bir sınıf yazılacak.

  Kurallar:
  * Çift Devreli Lig usülü uygulanacak.
  * Her takım diğer takımlarla kendi evinde ve deplasmanda olmak üzere iki maç yapacak.
  * Listenin sol tarafı ev sahibini sağ tarafı deplasman takımını gösterecek.
  * Eğer tek sayıda takım listesi girilirse, çift sayıya tamamlanacak şekilde "Bay" adında
    bir takım daha eklenecek. Bay ile eşleşen takımlar o hafta maç yapmayacak anlamındadır.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet<Team> teams = new TreeSet<>(new TeamComparator());

        teams.add(new Team("Galatasaray"));
        teams.add(new Team("Bursaspor"));
        teams.add(new Team("Fenerbahçe"));
        teams.add(new Team("Beşiktaş"));
        teams.add(new Team("Başakşehir"));
        teams.add(new Team("Trabzonspor"));
        teams.add(new Team("Boluspor"));

        if (teams.size() % 2 == 1) {
            teams.add(new Team("Bay"));
        }

        List<String> fikstur = new ArrayList<>();
        List<Team> template = new ArrayList<>(teams.stream().toList());

        for (Team team : teams) {
            template.add(template.remove(0));
            for (Team team2 : template) {
                if (!team.equals(team2)) {
                    String firstElement = team.getName() + " vs " + team2.getName();
                    String lastElement = team2.getName() + " vs " + team.getName();
                    if (!fikstur.contains(firstElement)) {
                        fikstur.add(0, firstElement);
                        fikstur.add(lastElement);
                    }
                }
            }
        }

        List<String> firstList = new ArrayList<>(fikstur.subList(0, fikstur.size() / 2));
        List<String> lastList = new ArrayList<>(fikstur.subList(fikstur.size() / 2, fikstur.size()));

        listFikstur(teams, firstList, lastList);
    }

    public static void listFikstur(TreeSet<Team> teams, List<String> first, List<String> last) {
        Collections.shuffle(first);
        Collections.shuffle(last);
        int count, reset, round = 1;
        Team bay = new Team("Bay");
        if (teams.contains(bay)) {
            count = 4;
            reset = 4;
        } else {
            count = 3;
            reset = 3;
        }

        System.out.println("Takımlar");
        for (Team team : teams) {
            if (!team.getName().equals("Bay")) {
                System.out.println("- " + team.getName());
            }
        }

        for (String team : first) {
            if (count == reset) {
                System.out.println("\n" + "Round " + round);
                count = 0;
                round++;
            }
            System.out.println(team);
            count++;
        }

        for (String team : last) {
            if (count == reset) {
                System.out.println("\n" + "Round " + round);
                count = 0;
                round++;
            }
            System.out.println(team);
            count++;
        }
    }
}

class TeamComparator implements Comparator<Team> {
    @Override
    public int compare(Team t1, Team t2) {
        return (t1.getName().compareTo(t2.getName()));
    }
}

class Team {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
