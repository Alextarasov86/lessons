package homework.myGame2;

public class SaveCommand implements Command{
    Menu menu;

    public SaveCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.save();
    }
}
