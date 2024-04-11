package homework.myGame2;

public class LoadCommand implements Command{
    Menu menu;

    public LoadCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.load();
    }
}
