package homework.myGame2;

public class ChoiceCommand implements Command{
    Menu menu;

    public ChoiceCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.choice();
    }
}
