package homework.myGame2;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Menu menu = new Menu(
                new StartNewGameCommand(game),
                new ReturnToGameCommand(game),
                new SaveCommand(game),
                new LoadCommand(game),
                new ExitCommand(game),
                new ReturnToMenuCommand(game)
        );
        Menu.printMenu();
    }
}
