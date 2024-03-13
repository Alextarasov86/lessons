package homework.lesson11.images;

public class Gallery implements Drawable, Cloneable {
    private String name;
    private Drawable[] drawables;

    public Gallery(String name, Drawable[] drawables) {
        this.drawables = drawables;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable[] getImages() {
        return drawables;
    }

    @Override
    public void draw() {
        System.out.println(name);
        for (Drawable drawable : drawables) {
            drawable.draw();
        }
    }

    @Override
    public Gallery clone() throws CloneNotSupportedException {
        Gallery copyGallery = (Gallery) super.clone();
        if(this.getName() != null){
            copyGallery.setName(this.getName());
        }
        if(drawables != null){
            for(int i = 0; i < drawables.length; i++){
                copyGallery.drawables[i] = drawables[i].drawableClone();
            }
        }
        return copyGallery;
    }

    @Override
    public Drawable drawableClone() throws CloneNotSupportedException {
        Drawable dr = this.clone();
        return dr;
    }
}