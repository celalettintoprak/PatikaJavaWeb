package Java102.AdventureGame;

public class Game {
    public void start() {
        GameFunctions gameFunctions = new GameFunctions();
        gameFunctions.player.playerFullStats();

        boolean isWin = false;
        while (!gameFunctions.isExit() && !isWin) {
            gameFunctions.selectPlace(isWin);
            if (!gameFunctions.player.isAlive()) {
                System.out.println("Canınız sıfırlandı, oyunu kaybettiniz !");
                break;
            }
        }
    }
}
