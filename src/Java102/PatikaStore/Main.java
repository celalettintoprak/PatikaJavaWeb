package Java102.PatikaStore;

public class Main {
    public static void main(String[] args) {
        StoreManager storeManager = new StoreManager();
        boolean isExit = false;
        while (!isExit) {
            isExit = storeManager.selectMenu();
        }

        /*
        float floatVar = 5;
        int intVar = 10;
        String stringVar = "TEST";

        System.out.format("%-10d%-12s%-10d%-16s", 1, "Apple", 16, "Macbook");
        System.out.println();
        System.out.format("The value of " + "the float variable is " +
                "%f, while the value of the " + "integer variable is %d, " +
                "and the string is %s", floatVar, intVar, stringVar);
        System.out.println();
        int i = 461012;
        System.out.format("The value of i is: %d%n", i);
         */
    }
}