package homework.lesson13;

abstract public class Action {
    public Action act;
    abstract void execute();

    public void nextAction(Action action){
        this.act = action;
    }
//
}
