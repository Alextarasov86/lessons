package homework.lesson10;

public class Gallery implements Paintable{
    private String name;
    private Paintable[] paintables;

    @Override
    public void draw(){
        System.out.println(name);
        for (Paintable paintable : paintables) {
            paintable.draw();
        }
    }
}
