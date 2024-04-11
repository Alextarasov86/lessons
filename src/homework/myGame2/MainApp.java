package homework.myGame2;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game = new Game(
                new StartNewGameCommand(menu),
                new ReturnToGameCommand(menu),
                new SaveCommand(menu),
                new LoadCommand(menu),
                new ExitCommand(menu),
                new ReturnToMenuCommand(menu),
                new ChoiceCommand(menu)
        );
        game.printMenu();
        Scanner scanner =new Scanner(System.in);
        int command;
        command = scanner.nextInt();

        while (command != 5){
            switch (command) {
                case 1 -> game.startNewGame();
                case 2 -> game.returnToGame();
                case 3 -> game.saveGame();
                case 4 -> game.loadGame();
                case 5 -> game.exitGame();
                default -> System.out.println("Команда не распознана, попробуйте ещё!");
            }
        }
    }
}
