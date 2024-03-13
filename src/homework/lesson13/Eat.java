package homework.lesson13;

public class Eat extends Action{

    @Override
    public void execute(){
        System.out.println("Eat");
    }

    @Override
    public void nextAction(Action action){
        this.act = action;
    }
}
