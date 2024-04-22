package homework.myGame2;

public class ReturnToGameCommand implements Command{
    Game game;

    public ReturnToGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.returnToGame();
    }
}
