package Java102.AdventureGame;

public class Inventory {
    private int food, wood, water;
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.food = 0;
        this.wood = 0;
        this.water = 0;

    }

    public int getFood() {
        return food;
    }

    private void setFood(int food) {
        this.food = food;
    }

    public int getWood() {
        return wood;
    }

    private void setWood(int wood) {
        this.wood = wood;
    }

    public int getWater() {
        return water;
    }

    private void setWater(int water) {
        this.water = water;
    }

    public void addAward(String awardName, int amount) {
        switch (awardName) {
            case "Yemek":
                this.food += amount;
                break;
            case "Odun":
                this.wood += amount;
                break;
            case "Su":
                this.water += amount;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + awardName);
        }
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
}
