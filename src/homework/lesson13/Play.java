package homework.lesson13;

public class Play extends Action{

    @Override
    public void execute(){
        System.out.println("Play");
    }

    public void nextAction(Action action){
        this.act = action;
    }

}
