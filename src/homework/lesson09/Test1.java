package homework.lesson09;

public class Test1 {
    public static void main(String[] args) {
        Knight knight = new Knight(5);
        Knight knight1 = new Knight(5);
        knight1.setAttackPower(4);
        knight.setAttackPower(4);
        Infantry infantry = new Infantry(10);
        infantry.setAttackPower(3);
        knight.attack(infantry);
//        infantry.attack(knight);
        System.out.println(infantry.getHealth());
        System.out.println(knight.getHealth());
//        System.out.println(knight1.getHealth());
    }
}
