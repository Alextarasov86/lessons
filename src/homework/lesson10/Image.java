package homework.lesson10;

public class Image implements Paintable{
    private String name;
    private String path;

    @Override
    public void draw(){
        System.out.println(name);
    }
}
