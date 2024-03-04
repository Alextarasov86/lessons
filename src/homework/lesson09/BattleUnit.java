package homework.lesson09;

abstract public class BattleUnit extends Unit{
    private int attackPower;

    public BattleUnit(int health){
        super(0);
        this.setHealth(health);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public void rest(){
        if(getInitialHealth() > getHealth()){
            updateHealth(2);
        }
    }
    public void attack(Unit unit){
        unit.updateHealth(-getAttackPower());
    }
}
