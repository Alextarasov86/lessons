package homework.lesson09;

public class Test2 {
    public static void main(String[] args) {
        King king = new King();
        King king2 = new King();
        king.createArmy();
        king2.createArmy();
        king.attackArmy(king2);
//        for(int i = 0; i < king.army.length; i++){
//            if(king.army[i] instanceof Knight){
//                System.out.println(king.army[i].getHealth());
//            }
//        }
//        System.out.println(king.getMoney());
    }
}
