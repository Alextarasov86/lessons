package homework.lesson10;

public class Editor{
    private Paintable paintable;

    public Editor(Paintable paintable) {
        this.paintable = paintable;
    }

    public void setPaintable(Paintable paintable) {
        this.paintable = paintable;
    }

    public void show(){
        paintable.draw();
    }

}
