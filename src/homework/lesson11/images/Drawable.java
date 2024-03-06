package homework.lesson11.images;

public interface Drawable{
    void draw();

    Drawable drawableClone() throws CloneNotSupportedException;

}