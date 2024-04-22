package homework.myGame2;

import java.io.IOException;

public class StartNewGameCommand implements Command{
    Game game;

    public StartNewGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() throws IOException {
        game.startNewGame();
    }
}
