package homework.myGame2;

public class ReturnToMenuCommand implements Command{
    Menu menu;

    public ReturnToMenuCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.returnToMenu();
    }
}
