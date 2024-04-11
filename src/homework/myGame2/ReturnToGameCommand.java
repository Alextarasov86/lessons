package homework.myGame2;

public class ReturnToGameCommand implements Command{
    Menu menu;

    public ReturnToGameCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.returnToGame();
    }
}
