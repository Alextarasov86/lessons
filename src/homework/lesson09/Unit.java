package homework.lesson09;

abstract public class Unit {
    private int health;
    private int speed;
    private int money;
    private int initialHealth;


    public Unit(int money){
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setHealth(int health) {
        this.health = health;
        this.initialHealth = health;
    }

    public void rest(){
        if(initialHealth > health){
            health++;
        }
    }

    public void updateHealth(int health){
        if(health < -100 || health > 100){
            throw new IllegalArgumentException("Вы указали недопустимое значение для здоровья");
        }
        else if(health < initialHealth){
            this.health += health;
            if(this.health > initialHealth){
                this.health = initialHealth;
                System.out.println("Здоровье полность восстановлено");
            }
            else if(this.health < 0){
                this.health = 0;
            }
        }
    }

    public void updateMoney(int money){
        if(money > 1000 || money < -1000){
            throw new IllegalArgumentException("Вы указали недопустимое значение для денег");
        }
        else if((this.money + money) < 0){
            throw new IllegalArgumentException("На счету недостаточно средств");
        } else {
            this.money += money;
        }
    }

}
