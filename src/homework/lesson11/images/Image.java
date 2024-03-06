package homework.lesson11.images;

public class Image implements Drawable, Cloneable{
    private String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void draw() {
        System.out.println(path);
    }



    @Override
    public Image clone() throws CloneNotSupportedException {
        Image copyImage = (Image) super.clone();
        if(this.path != null){
            copyImage.path = this.getPath();
        }
        return copyImage;
    }

    @Override
    public Drawable drawableClone() throws CloneNotSupportedException {
        Drawable dr = this.clone();
        return dr;
    }

}