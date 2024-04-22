package homework.myGame2;

public class Paragraph {

    private String title;
    private String text;
    private String choice1;
    private String choice2;

    public Paragraph(String title, String text, String choice1, String choice2) {
        this.title = title;
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public void showParagraph(){
        if(!getChoice1().equals("0") && !getChoice2().equals("0")){
            System.out.println("1. " + getChoice1());
            System.out.println("2. " + getChoice2());
            System.out.println("3. Вернуться в главное меню");
        }
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                '}';
    }
}
