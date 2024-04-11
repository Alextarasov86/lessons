package homework.myGame2;

import java.io.IOException;

public class StartNewGameCommand implements Command{
    Menu menu;

    public StartNewGameCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute(){
        menu.startNewGame();
    }
}
