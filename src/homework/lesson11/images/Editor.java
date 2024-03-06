package homework.lesson11.images;

public final class Editor implements Cloneable {
    private Drawable drawable;

    public Editor(Drawable drawable) {
        setDrawable(drawable);
    }

    public void setDrawable(final Drawable drawable){
        this.drawable = drawable;
    }

    public void show(){
        drawable.draw();
    }

    @Override
    public Editor clone() throws CloneNotSupportedException {
        Editor copyEditor = (Editor) super.clone();
        if(drawable != null){
            copyEditor.setDrawable(drawable.drawableClone());
        }
        return copyEditor;
    }
}