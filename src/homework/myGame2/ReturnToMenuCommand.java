package homework.myGame2;

import java.io.IOException;

public class ReturnToMenuCommand implements Command{
    Game game;

    public ReturnToMenuCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() throws IOException {
        game.returnToMenu();
    }
}
