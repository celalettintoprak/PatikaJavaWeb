package Java102.AdventureGame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Place {
    public static int count = 41;
    public final String WEAPON = Weapon.class.getName();
    public final String ARMOR = Armor.class.getName();
    public final String WARRIOR = Warrior.class.getName();
    private final int id;
    private final String name;

    public Place(String name) {
        this.id = count++;
        this.name = name;
        System.out.println(this.name + " adlı mekandasınız.");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

abstract class SafeZone extends Place {
    public SafeZone( String name) {
        super(name);
    }
}

class SafeHouse extends SafeZone {
    public SafeHouse() {
        super( "Güvenli Ev");
    }

    public void heal(Player player) {
        if (player.getTotalHealth() <= 0) {
            System.out.println("Ölülerin sağlığı yenilenemez !");
        } else {
            player.setTotalHealth(player.getWarrior().getHealth());
            System.out.println("Sağlığınız yenilendi. Sağlık: " + player.getTotalHealth());
        }
    }

    public boolean submitAward(Player player) {
        final int foodR = 20, woodR = 20, waterR = 20;

        int food = player.getInventory().getFood();
        int wood = player.getInventory().getWood();
        int water = player.getInventory().getWater();

        if (food < foodR || wood < woodR || water < waterR) {
            System.out.println("Oyunu tamamlamak için gereken malzemeleri tamamlamalısınız.");
            return false;
        } else {
            System.out.println("Oyunu kazandınız. Tebrikler.");
            return true;
        }
    }
}

class Market extends SafeZone {
    private List<Item> weapons, armors;
    private List<Warrior> warriors;

    public Market() {
        super("Market");
        this.forgeItems();
        this.createChars();
    }

    public void listMarket() {
        System.out.println("-------------------- CHAR LIST --------------------");
        for (Warrior i : warriors) {
            System.out.println("Id: " + i.getId() +
                    "  |  Name: " + i.getName() +
                    "  |  Damage: " + i.getDamage() +
                    "  |  Health: " + i.getHealth() +
                    "  |  Price: " + i.getPrice());
        }
        System.out.println("-------------------- ITEM LIST --------------------");
        for (Item i : weapons) {
            System.out.println("Id: " + i.getId() +
                    "  |  Name: " + i.getName() +
                    "  |  Damage: " + ((Weapon) i).getDamage() +
                    "  |  Price: " + ((Weapon) i).getPrice());
        }
        System.out.println("---------------------------------------------------");
        for (Item i : armors) {
            System.out.println("Id: " + i.getId() +
                    "  |  Name: " + i.getName() +
                    "  |  Defense: " + ((Armor) i).getDefense() +
                    "  |  Price: " + ((Armor) i).getPrice());
        }
    }

    public void buyItem (Player player, Object object) {
        String objectClass = object.getClass().getAnnotatedSuperclass().toString();
        int objectPrice = 0;

        if (objectClass.equals(this.WEAPON) || objectClass.equals(this.ARMOR)) {
            objectPrice = ((MarketItem) object).getPrice();
        } else if (objectClass.equals(this.WARRIOR)) {
            objectPrice = ((Warrior) object).getPrice();
        }

        if (player.getTotalMoney() < objectPrice) {
            System.out.println("Yeterli paranız yok.");
        } else {
            if (objectClass.equals(this.WEAPON)) {
                player.getInventory().setWeapon((Weapon) object);
                player.setTotalDamage(((Weapon) object).getDamage() + player.getWarrior().getDamage());
                player.subtractMoney(((MarketItem) object).getPrice());
                System.out.println(((Item) object).getName() + " satın aldınız. " +
                        "Kalan paranız: " + player.getTotalMoney());
            } else if (objectClass.equals(this.ARMOR)) {
                player.getInventory().setArmor((Armor) object);
                player.setTotalDefense(((Armor) object).getDefense());
                player.subtractMoney(((MarketItem) object).getPrice());
                System.out.println(((Item) object).getName() + " satın aldınız. " +
                        "Kalan paranız: " + player.getTotalMoney());
            } else if (objectClass.equals(this.WARRIOR)) {
                player.setWarrior((Warrior) object);
                player.subtractMoney(((Warrior) object).getPrice());
                System.out.println(((Warrior) object).getName() + " karakterini satın aldınız. " +
                        "Kalan paranız: " + player.getTotalMoney());
            }
        }
        player.playerFullStats();
    }

    public Object findItem(int id) {
        Object selectedItem = null;
        for (Item item : this.getWeapons()) {
            if (item.getId() == id) {
                selectedItem = item;
            }
        }
        for (Item item : this.getArmors()) {
            if (item.getId() == id) {
                selectedItem = item;
            }
        }
        for (Warrior warrior : this.getWarriors()) {
            if (warrior.getId() == id) {
                selectedItem = warrior;
            }
        }
        return selectedItem;
    }

    private void forgeItems() {
        Weapon gun = new Gun();
        Weapon sword = new Sword();
        Weapon rifle = new Rifle();
        this.weapons = Arrays.asList(gun, sword, rifle);

        Armor armorLight = new ArmorLight();
        Armor armorMiddle = new ArmorMiddle();
        Armor armorHeavy = new ArmorHeavy();
        this.armors = Arrays.asList(armorLight, armorMiddle, armorHeavy);
    }

    private void createChars() {
        Warrior samurai = new Samurai();
        Warrior archer = new Archer();
        Warrior knight = new Knight();
        this.warriors = Arrays.asList(samurai, archer, knight);
    }

    public List<Item> getWeapons() {
        return weapons;
    }

    private void setWeapons(List<Item> weapons) {
        this.weapons = weapons;
    }

    public List<Item> getArmors() {
        return armors;
    }

    private void setArmors(List<Item> armors) {
        this.armors = armors;
    }

    public List<Warrior> getWarriors() {
        return warriors;
    }

    public void setWarriors(List<Warrior> warriors) {
        this.warriors = warriors;
    }
}

abstract class WarZone extends Place {
    private final Monster monster;
    private final Monster[] monsters;
    private Award award;
    private Weapon weapon;
    private Armor armor;

    private final int monsterAmount;
    private int money, awardAmount, monsterHealth;

    public WarZone(String name, Monster monster, Award award, int monsterNumber) {
        super(name);
        this.monster = monster;
        this.award = award;
        this.weapon = null;
        this.armor = null;
        this.money = 0;
        this.monsterAmount = randomNum3(monsterNumber);
        this.awardAmount = randomNum3(monsterNumber) * 5;
        this.monsterHealth = monster.getHealth();
        this.monsters = new Monster[monsterAmount];
        addMonsters();
    }

    public void addMonsters() {
        for (int i = 0; i < this.monsters.length; i++) {
            monsters[i] = monster;
        }
    }

    public void warZoneFullStats() {
        String oWeapon, oArmor, oAward;
        if (this.weapon == null) {
            oWeapon = "-";
        } else {
            oWeapon = this.weapon.getName();
        }
        if (this.armor == null) {
            oArmor = "-";
        } else {
            oArmor = this.armor.getName();
        }
        if (this.award == null) {
            oAward = "-";
        } else {
            oAward = "(" + this.award.getName() + " " + this.getAwardAmount() + ")";
        }
        System.out.println("=========================================================" + "\n" +
                "(Name: " + monster.getName() + " / " +
                getMonsterAmount() + " adet)" + "\t" +
                "Health: " + getMonsterHealth() + "\t" +
                "Damage: " + monster.getDamage() + "\t" +
                "Money: " + money + "\t" +
                "Weapon: " + oWeapon + "\t" +
                "Armor: " + oArmor + "\t" +
                "Award: " + oAward + "\n" +
                "=========================================================");
    }

    public void warZoneStats() {
        System.out.println("=========================================================" + "\n" +
                "(Name: " + monster.getName() + ")\t" +
                "Health: " + getMonsterHealth() + "\t" +
                "Damage: " + monster.getDamage() + "\n" +
                "=========================================================");
    }

    private int randomNum3(int value) {
        return new Random().nextInt(value) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getMonsterAmount() {
        return monsterAmount;
    }

    public int getAwardAmount() {
        return awardAmount;
    }

    public void setAwardAmount(int awardAmount) {
        this.awardAmount = awardAmount;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

class Cave extends WarZone {
    public Cave() {
        super("Mağara", new Zombie(), new Food(), 3);
    }
}

class Forest extends WarZone {
    public Forest() {
        super("Orman", new Vampire(), new Wood(), 3);
    }
}

class River extends WarZone {
    public River() {
        super("Nehir", new Bear(), new Water(), 3);
    }
}

class Mine extends WarZone {
    AddItemAndMoney addItemAndMoney = new AddItemAndMoney();
    public Mine() {
        super("Maden", new Snake(), new Water(), 5);
        this.setMoney(addItemAndMoney.addMoney());
        this.setWeapon(addItemAndMoney.addWeapon());
        this.setArmor(addItemAndMoney.addArmor());
        this.setAward(null);
        this.setAwardAmount(0);
    }
}

class AddItemAndMoney {
    int weaponProbability = 15, wGunProbability  = 50, wSwordProbability = 30, wRifleProbability = 20;
    int armorProbability = 15, aLightProbability  = 50, aMiddleProbability = 30, aHeavyProbability = 20;
    int moneyProbability = 25, m1Probability  = 50, m5Probability = 30, m10Probability = 20;

    public int addMoney() {
        int money = 0;
        int valueM = new Random().nextInt(101);
        if(valueM <= moneyProbability) {
            int valueMoney = new Random().nextInt(101);
            if(valueMoney <= m1Probability) {
                money = 1;
            } else if (valueMoney <= m5Probability) {
                money = 5;
            } else if (valueMoney <= m10Probability) {
                money = 10;
            }
        }
        return money;
    }

    public Weapon addWeapon() {
        Weapon weapon = null;
        int valueW = new Random().nextInt(101);
        if(valueW <= weaponProbability) {
            int valueWeapon = new Random().nextInt(101);
            if(valueWeapon <= wGunProbability) {
                weapon = new Gun();
            } else if (valueWeapon <= wSwordProbability) {
                weapon = new Sword();
            } else if (valueWeapon <= wRifleProbability) {
                weapon = new Rifle();
            }
        }
        return weapon;
    }

    public Armor addArmor() {
        Armor armor = null;
        int valueA = new Random().nextInt(101);
        if(valueA <= armorProbability) {
            int valueArmor = new Random().nextInt(101);
            if(valueArmor <= aLightProbability) {
                armor = new ArmorLight();
            } else if (valueArmor <= aMiddleProbability) {
                armor = new ArmorMiddle();
            } else if (valueArmor <= aHeavyProbability) {
                armor = new ArmorHeavy();
            }
        }
        return armor;
    }
}