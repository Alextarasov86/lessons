package homework.lesson06class.task1;

public class Group {
    private int sizeGroup;
    private boolean isRecruit = true;
    private Climber[] climbers;
    private Mountain mountain;


    public Group(int sizeGroup){
        if(sizeGroup < 0){
            throw new IllegalArgumentException("Групы должна состоять хотя бы из одного человека");
        }
        this.sizeGroup = sizeGroup;
        this.climbers = new Climber[this.sizeGroup];
    }

    public void recruitClimber(Climber climber){
        int count = 0;
        if(isRecruit){
            for(int i = 0; i < climbers.length; i++){
                if(climbers[i] == null){
                    climbers[i] = climber;
                    count++;
                    break;
                }
            }
            if(count == 0){
                isRecruit = false;
                System.out.println("Набор в первую группу закрыт. " + climber.getName() + ", дождитесь следующего набора" );
            }
        }
    }

    public static void main(String[] args) {
        Group group1 = new Group(3);
        group1.mountain = new Mountain("Elbrus", "Russia", 5642);
        Climber climber1 = new Climber("Alex", "Moscow");
        Climber climber2 = new Climber("Petr", "Kazan");
        Climber climber3 = new Climber("Ivan", "Samara");
        Climber climber4 = new Climber("Anton", "Sochi");
        group1.recruitClimber(climber1);
        group1.recruitClimber(climber2);
        group1.recruitClimber(climber3);
        group1.recruitClimber(climber4);

        Group group2 = new Group(3);
        group1.mountain = new Mountain("Kazbek", "Georgia", 5032);
        Climber climber5 = new Climber("Olga", "Murmansk");
        Climber climber6 = new Climber("Mark", "Moscow");
        group2.recruitClimber(climber5);
        group2.recruitClimber(climber6);

        Group group3 = new Group(5);
        group3.mountain = new Mountain("Belukha", "Russia", 4506);
        Climber climber7 = new Climber("Egor", "Saransk");
        group3.recruitClimber(climber4);
        group3.recruitClimber(climber7);
    }
}
