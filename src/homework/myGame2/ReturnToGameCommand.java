package homework.myGame2;

import java.io.IOException;

public class ReturnToGameCommand implements Command{
    Game game;

    public ReturnToGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() throws IOException {
        game.returnToGame();
    }
}
