package homework.myGame2;

import java.io.IOException;

public class SaveCommand implements Command{
    Game game;

    public SaveCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() throws IOException {
        game.save();
    }
}
