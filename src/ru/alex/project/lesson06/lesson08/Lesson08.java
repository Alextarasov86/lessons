package ru.alex.project.lesson06.lesson08;

public class Lesson08 {
    public static void main(String[] args) {
        Unit u = new Unit(22);
        u.rest();
        BattleUnit bU1 = new BattleUnit(10, 13, 20);
        bU1.rest();
        BattleUnit bU2 = new BattleUnit(10, 13, 20);
        bU2.rest();

        bU1.attack(u);
        bU1.attack(bU1);
        bU1.attack(bU2);

        BattleUnit [] bus = new BattleUnit[4];
    }
}
