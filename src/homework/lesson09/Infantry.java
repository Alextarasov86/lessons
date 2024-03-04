package homework.lesson09;

public class Infantry extends BattleUnit{
    Infantry(int health){
        super(health);
    }

    @Override
    public void attack(Unit unit){
        super.attack(unit);
        if(unit.getHealth() < 5){
            super.attack(unit);
        }
        if(unit instanceof Knight){
            if(unit.getHealth() > 1){
                updateHealth(-((Knight) unit).getAttackPower());
            }
        }
    }

    public void treat(Unit unit){
        if(unit.getHealth() == unit.getInitialHealth()){
            throw new IllegalArgumentException("Лечение не нужно - у юнита максимальное здоровье");
        } else {
            unit.updateHealth(2);
        }
    }
}
