package Java102.AdventureGame;

public abstract class Item {
    public static int count = 21;
    private final int id;
    private final String name;

    public Item(String name) {
        this.id = count++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

abstract class Award extends Item {

    public Award(String name) {
        super(name);
    }
}

class Food extends Award {
    public Food() {
        super("Yemek");
    }
}

class Wood extends Award {
    public Wood() {
        super("Odun");
    }
}

class Water extends Award {
    public Water() {
        super("Su");
    }
}

abstract class MarketItem extends Item {
    private final int price;

    public MarketItem(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
abstract class Weapon extends MarketItem {
    private final int damage;
    public Weapon(String name, int price, int damage) {
        super(name, price);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}

class Gun extends Weapon {
    public Gun() {
        super("Tabanca", 2, 25);
    }
}

class Sword extends Weapon {
    public Sword() {
        super("Kılıç", 3, 35);
    }
}

class Rifle extends Weapon {
    public Rifle() {
        super("Tüfek", 7, 45);
    }
}

abstract class Armor extends MarketItem {
    private final int defense;
    public Armor(String name, int price, int defense) {
        super(name, price);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}

class ArmorLight extends Armor {
    public ArmorLight() {
        super("Hafif Zırh", 1, 15);
    }
}

class ArmorMiddle extends Armor {
    public ArmorMiddle() {
        super("Orta Zırh", 2, 25);
    }
}

class ArmorHeavy extends Armor {
    public ArmorHeavy() {
        super( "Ağır Zırh", 3, 40);
    }
}