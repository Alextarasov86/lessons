package homework.myGame2;

public class Paragraph {
    private int id;
    private String title;
    private String text;
    private String choice;
    private int nextParagraphId;

    public Paragraph(int id, String title, String text, String choice) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.choice = choice;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getChoice() {
        return choice;
    }

    public void showParagraph(){
        System.out.println(getTitle());
        System.out.println(getText());
        System.out.println(getChoice());
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", choice='" + choice + '\'' +
                '}';
    }
}
