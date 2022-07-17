package Java102.AdventureGame;

import java.util.Random;

public abstract class GameChar {
    public static int count = 10;
    private final int id, damage, health;
    private final String name;

    public GameChar(String name, int damage, int health) {
        this.id = count++;
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}

abstract class Warrior extends GameChar {
    private final int price;
    public Warrior(String name, int damage, int health, int price) {
        super(name, damage, health);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Peasant extends Warrior {
    public Peasant() {
        super("Köylü", 4, 16, 0);
    }
}

class Samurai extends Warrior {
    public Samurai() {
        super("Samuray", 5, 21, 60);
    }
}

class Archer extends Warrior {
    public Archer() {
        super("Okçu", 7, 18, 70);
    }
}

class Knight extends Warrior {
    public Knight() {
        super("Şovalye", 8, 24, 100);
    }
}

abstract class Monster extends GameChar {
    private final int money;
    public Monster(String name, int damage, int health, int money) {
        super(name, damage, health);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}

class Zombie extends Monster {
    public Zombie() {
        super("Zombi", 3, 10, 4);
    }
}

class Vampire extends Monster {
    public Vampire() {
        super("Vampir", 4, 14, 7);
    }
}

class Bear extends Monster {
    public Bear() {
        super("Ayı", 7, 20, 12);
    }
}

class Snake extends Monster {
    public Snake() {
        super("Yılan", new Random().nextInt(4) + 3, 12, 0);
    }
}