package homework.myGame2;

public class ExitCommand implements Command{
    Game game;

    public ExitCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.exit();
    }
}
