package Java102.AdventureGame;

import java.util.Scanner;

public class GameFunctions {
    Player player = new Player(new Peasant());
    SafeHouse safeHouse = new SafeHouse();
    Market market = new Market();
    private final Scanner scanner = new Scanner(System.in);
    private boolean exit = false;
    private void listPlaces() {
        System.out.println("--------------------- SEÇİM YAPINIZ ---------------------" + "\n" +
                "1 - Safe House / Güvenli Ev: Sağlık yenileme, Oyunu tamamlama" + "\n" +
                "2 - Market / Karakter değiştirme, silah ve zırh satın alma" + "\n" +
                "3 - Mağara / Canavar: Zombi | Ödül: Yemek" + " (savaş bölgesi)" + "\n" +
                "4 - Orman / Canavar: Vampir | Ödül: Odun" + " (savaş bölgesi)" + "\n" +
                "5 - Nehir / Canavar: Ayı | Ödül: Su" + " (savaş bölgesi)" + "\n" +
                "6 - Maden / Canavar: Yılan | Ödül: Silah/Zırh ya da Para olabilir" + " (savaş bölgesi)" + "\n" +
                "---------------------------------------------------------" + "\n" +
                "7 - Durum / Oyuncu istatistiklerini görüntüleme" + "\n" +
                "0 - Çıkış / Oyunu sonlandır" + "\n" +
                "=========================================================");
    }

    public boolean selectPlace(boolean value) {
        this.listPlaces();
        System.out.print("Seçiminiz: ");
        int selected = scanner.nextInt();
        switch (selected) {
            case 1:
                safeHouse.heal(player);
                if (safeHouse.submitAward(player)) {
                    value = true;
                    this.setExit(true);
                }
                break;
            case 2:
                market.listMarket();
                System.out.print("ID seçiniz: ");
                int input = scanner.nextInt();
                Object selectedItem = market.findItem(input);
                if (selectedItem == null) {
                    System.out.println("Geçersiz değer.");
                } else {
                    market.buyItem(player, selectedItem);
                }
                break;
            case 3:
                WarZone cave = new Cave();
                battle(player, cave);
                break;
            case 4:
                WarZone forest = new Forest();
                battle(player, forest);
                break;
            case 5:
                WarZone river = new River();
                battle(player, river);
                break;
            case 6:
                WarZone mine = new Mine();
                battle(player, mine);
                break;
            case 7:
                player.playerFullStats();
                player.listInventory();
                break;
            case 0:
                System.out.println("Oyundan çıktınız, tekrar görüşmek üzere.");
                this.setExit(true);
                break;
        }
        return value;
    }

    public void battle(Player player, WarZone warZone) {
        player.playerStats();
        warZone.warZoneFullStats();
        char input;
        do {
            System.out.print("Savaş: S  -  Ayrıl: X  |  Seçiminiz: ");
            input = scanner.next().toUpperCase().charAt(0);
            if (input != 'S' && input != 'X') {
                System.out.println("Geçersiz karakter.");
            }
        } while (input != 'S' && input != 'X');
        switch (input) {
            case 'S':
                player.attack(warZone);
                break;
            case 'X':
                System.out.println("Savaşmadan ayrıldınız.");
                break;
        }
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
