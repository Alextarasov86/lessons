package homework.lesson09;

public class Knight extends BattleUnit{
    Knight(int health){
        super(health);
    }

    @Override
    public void attack(Unit unit){
        super.attack(unit);
        if(unit instanceof Knight){
            if(unit.getHealth() >= 1){
                updateHealth(-((Knight) unit).getAttackPower());
            }
        }
    }
}
