package Java102.AdventureGame;

public class Player {
    private int totalHealth, totalDamage, totalDefense, totalMoney;
    private Warrior warrior;
    private final Inventory inventory = new Inventory();
    private boolean isAlive;

    public Player(Warrior warrior) {
        this.warrior = warrior;
        this.totalHealth = warrior.getHealth();
        this.totalDamage = warrior.getDamage();
        this.totalDefense = 0;
        this.totalMoney = 0;
        this.isAlive = true;
    }

    public void attack(WarZone warZone) {
        int count = warZone.getMonsterAmount();
        boolean isWin = true;

        while (this.isAlive() && count > 0) {
            for (Monster monster : warZone.getMonsters()) {
                while (this.isAlive() && warZone.getMonsterHealth() > 0) {
                    warZone.setMonsterHealth(warZone.getMonsterHealth() - this.totalDamage);

                    if (warZone.getMonsterHealth() <= 0) {
                        warZone.setMonsterHealth(monster.getHealth());
                        count -= 1;
                        break;
                    } else {
                        this.setTotalHealth(this.getTotalHealth() + this.getTotalDefense() - monster.getDamage());
                        if (this.getTotalHealth() <= 0) {
                            isWin = false;
                            System.out.println((warZone.getMonsterAmount() - count + 1) + "/" +
                                    warZone.getMonsterAmount() + " | Savaşta öldünüz !");
                            break;
                        }
                    }
                    this.playerStats();
                    warZone.warZoneStats();
                }
                if (!this.isAlive()) {
                    isWin = false;
                    break;
                }
            }
        }
        if (isWin) {
            String awardName = warZone.getAward().getName();
            int awardAmount = warZone.getAwardAmount();
            int money = warZone.getMonster().getMoney();

            inventory.addAward(awardName, awardAmount);
            addMoney(money);
            System.out.println(warZone.getMonsterAmount() + "/" + warZone.getMonsterAmount() +
                    " | Tebrikler, savaşı kazandınız " + awardAmount + " " + awardName + " ve " +
                    money + " para kazandınız.");
        }
    }

    public void playerStats() {
        System.out.println("=========================================================" + "\n" +
                "(Name: " + this.getWarrior().getName() + ")\t" +
                "Health: " + this.getTotalHealth() + "\t" +
                "Damage: " + this.getTotalDamage() + "\t" +
                "Defense: " + this.getTotalDefense() + "\n" +
                "=========================================================");
    }
    public void playerFullStats() {
        System.out.println("=========================================================" + "\n" +
                "(Name: " + this.getWarrior().getName() + ")\t" +
                "Id: " + this.getWarrior().getId() + "\t" +
                "Health: " + this.getTotalHealth() + "\t" +
                "Damage: " + this.getTotalDamage() + "\t" +
                "Defense: " + this.getTotalDefense() + "\t" +
                "Money: " + this.getTotalMoney() + "\n" +
                "=========================================================");
    }

    public void listInventory() {
        String weapon, armor;
        if (this.inventory.getWeapon() == null) {
            weapon = "YOK";
        } else {
            weapon = (this.inventory.getWeapon().getName());
        }
        if (this.inventory.getArmor() == null) {
            armor = "YOK";
        } else {
            armor = (this.inventory.getArmor().getName());
        }
        System.out.println("Weapon: " + weapon + "\t | \t" + "Armor: " + armor + "\n" +
                "Food: " + this.inventory.getFood() + "\t | \t" +
                "Wood: " + this.inventory.getWood() + "\t | \t" +
                "Water: " + this.inventory.getWater() + "\n" +
                "=========================================================");
    }


    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        if (totalHealth <= 0) {
            this.totalHealth = 0;
            this.isAlive = false;
        } else {
            this.totalHealth = totalHealth;
        }
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = totalDamage;
    }

    public int getTotalDefense() {
        return totalDefense;
    }

    public void setTotalDefense(int totalDefense) {
        this.totalDefense = totalDefense;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    private void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void addMoney (int money) {
        this.totalMoney += money;
    }

    public void subtractMoney (int money) {
        if (this.totalMoney < money) {
        } else {
            this.totalMoney -= money;
        }
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
        this.setTotalHealth(warrior.getHealth());
        if (inventory.getWeapon() == null) {
            this.setTotalDamage(warrior.getDamage());
        } else if (inventory.getWeapon() != null){
            this.setTotalDamage(warrior.getDamage() + inventory.getWeapon().getDamage());
        }
        if (inventory.getArmor() == null || this.totalDefense == 0) {
            this.setTotalDefense(0);
        } else if (inventory.getArmor() != null){
            this.setTotalDefense(inventory.getArmor().getDefense());
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean value) {
        if (!value) {
            this.totalHealth = 0;
        }
        isAlive = value;
    }
}
