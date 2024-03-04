package homework.lesson09;

import java.util.Random;

public class King extends Unit{
    static final int SIZE_ARMY = 20;
    static final int KING_MONEY = 500;
    static final String[] unitNames = {"knight", "infantry"};
    private BattleUnit[] army;

    public King(){
        super(KING_MONEY);
        this.army = new BattleUnit[SIZE_ARMY];
    }

    @Override
    public void rest(){
        if(getMoney() >= 2){
            if(getInitialHealth() > getHealth()){
                updateHealth(5);
                updateMoney(-2);
            }
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    public int sumHealth(){
        int sum = 0;
        for(int i = 0; i < army.length; i++){
            sum += army[i].getHealth();
        }
        return sum;
    }

    public void createArmy(){
        Random random = new Random();
        for(int i = 0; i < army.length; i++){
            String randomName = unitNames[random.nextInt(unitNames.length)];
            if("knight".equalsIgnoreCase(randomName)){
                army[i] = new Knight(50);
                army[i].setAttackPower(4);
            }
            else if("infantry".equalsIgnoreCase(randomName)){
                army[i] = new Infantry(50);
                army[i].setAttackPower(3);
            }
        }
        this.updateMoney(-200);
    }

    public void updateArmy(){
        for(int i = 0; i < army.length; i++){
            if(army[i].getHealth() < 1 && this.getMoney() > 12){
                if(army[i] instanceof Knight){
                    army[i] = new Knight(50);
                }
                else if(army[i] instanceof Infantry){
                    army[i] = new Infantry(50);
                }
            }
        }
    }

    public void attackArmy(King enemy){
        for(int i = 0; i < army.length; i++){
            for(int j = 0; j < enemy.army.length; j++){
                while (army[i].getHealth() > 0 && enemy.army[j].getHealth() > 0){
                    army[i].attack(enemy.army[j]);
                    if(enemy.army[j].getHealth() > 0){
                        enemy.army[j].attack(army[i]);
                    }
                }
            }
        }

        if(enemy.sumHealth() == 0){
            System.out.println("Армия врага повержена");
            enemy.updateMoney(-(enemy.getMoney() / 2));
            updateMoney(enemy.getMoney() / 2);
            System.out.println(getMoney());
        }
        else if(sumHealth() == 0){
            System.out.println("Твоя армия повержена");
            updateMoney(-(getMoney() / 2));
            enemy.updateMoney(getMoney() / 2);
            System.out.println(enemy.getMoney());
        }
    }
}
