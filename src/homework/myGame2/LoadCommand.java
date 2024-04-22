package homework.myGame2;

public class LoadCommand implements Command{
    Game game;

    public LoadCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.load();
    }
}
