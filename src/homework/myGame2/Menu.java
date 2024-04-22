package homework.myGame2;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static Command startNewGame;
    private static Command returnToGame;
    private static Command save;
    private static Command load;
    private static Command exit;
    private Command returnToMenu;


    public Menu(Command startNewGame, Command returnToGame, Command save,
                Command load, Command exit, Command returnToMenu) {
        this.startNewGame = startNewGame;
        this.returnToGame = returnToGame;
        this.save = save;
        this.load = load;
        this.exit = exit;
        this.returnToMenu = returnToMenu;
    }

    public static void startNewGame() throws IOException { startNewGame.execute();}
    public static void returnToGame() throws IOException { returnToGame.execute();}
    public static void saveGame() throws IOException {save.execute();}
    public static void loadGame() throws IOException {load.execute();}
    public static void exitGame() throws IOException {exit.execute();}
    public void returnToMenuGame() throws IOException {returnToMenu.execute();}

    public static void printMenu() throws IOException {
        System.out.println("Добро пожаловать в игру. Выберите пункт меню: ");
        System.out.println("1. Начать игру");
        System.out.println("2. Вернуться в игру");
        System.out.println("3. Сохранить игру");
        if(Game.isSave){
            System.out.println("4. Загрузить игру");
            System.out.println("5. Выйти из игры");
        } else{
            System.out.println("4. Выйти из игры");
        }

        Scanner scanner = new Scanner(System.in);
        int command;
        command = scanner.nextInt();
        switch (command){
            case 1:
                startNewGame();
            case 2:
                returnToGame();
            case 3:
                saveGame();
            case 4:
                if(Game.isSave){
                    loadGame();
                } else {
                    exitGame();
                }
            case 5:
                if(Game.isSave){
                    exitGame();
                } else {
                    System.out.println("Команда не распознана, попробуйте ещё!");
                }
            default:
                System.out.println("Команда не распознана, попробуйте ещё!");
        }
    }
}
