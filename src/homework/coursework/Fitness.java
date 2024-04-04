package homework.coursework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Fitness {
    private Subscription[] gym;
    private Subscription[] pool;
    private Subscription[] group;
    private int countGym = 0;
    private int countPool = 0;
    private int countGroup = 0;

    public enum Zone {
        GYM, POOL, GROUP;
    }

    public void createGroups(int size){
        this.gym = new Subscription[size];
        this.pool = new Subscription[size];
        this.group = new Subscription[size];
    }

    private void showInfo(Subscription subscription){
        System.out.println(subscription.getOwner().getName() + " " +
                subscription.getOwner().getSurname()+ " " + subscription.getSubType());
        System.out.println(LocalDateTime.now());
    }

    private void addGym(Subscription subscription){
        for(int i =0; i < gym.length; i++){
            if(gym[i] == null){
                gym[i] = subscription;
                countGym++;
                showInfo(subscription);
                break;
            }
        }
    }

    private void addPool(Subscription subscription){
        for(int i =0; i < pool.length; i++){
            if(pool[i] == null){
                pool[i] = subscription;
                countPool++;
                showInfo(subscription);
                break;
            }
        }
    }

    private void addGroup(Subscription subscription){
        for(int i = 0; i < group.length; i++){
            if(group[i] == null){
                group[i] = subscription;
                countGroup++;
                showInfo(subscription);
                break;
            }
        }
    }

    public void addSubscription(Zone zone, Subscription subscription){
        if(zone == Zone.GYM){
            if(countGym < 20){
                if(!LocalDate.now().isAfter(subscription.getDateEnd())){
                    if(subscription.getSubType() == Subscription.SubType.DAY){
                        if(LocalTime.now().getHour() < 16){
                            addGym(subscription);
                        } else {
                            System.out.println("Вы можете посещать тренажерный зал только до 16 часов");
                        }
                    } else{
                        addGym(subscription);
                    }
                } else {
                    System.out.println("Ваш абонемент прострочен");
                }
            } else {
                System.out.println("Тренажерный зал переполнен");
            }
        }
        else if (zone == Zone.POOL){
            if(subscription.getSubType() == Subscription.SubType.DAY){
                System.out.println("Вы не можете посещать бассейн");
            }
            else if(countPool < 20){
                if(!LocalDate.now().isAfter(subscription.getDateEnd())){
                    addPool(subscription);
                } else {
                    System.out.println("Ваш абонемент прострочен");
                }
            } else {
                System.out.println("Тренажерный зал переполнен");
            }
        }
        else if(zone == Zone.GROUP){
            if(subscription.getSubType() == Subscription.SubType.ONETIME){
                System.out.println("Вы не можете посещать групповые занятия");
            }
            else if(countGroup < 20){
                if(!LocalDate.now().isAfter(subscription.getDateEnd())){
                    if(subscription.getSubType() == Subscription.SubType.DAY){
                        if(LocalTime.now().getHour() < 16){
                            addGroup(subscription);
                        } else {
                            System.out.println("Вы можете посещать групповые занятия только до 16 часов");
                        }
                    } else {
                        addGroup(subscription);
                    }
                } else {
                    System.out.println("Ваш абонемент прострочен");
                }
            } else {
                System.out.println("Зал с групповыми занятиями переполнен");
            }
        }
    }

    public void currentSubscriptionsInfo(){
        System.out.println("Посетители тренажерного зала:");
        for (Subscription subscription : gym) {
            if(subscription != null) System.out.println(subscription.getOwner());
        }
        System.out.println("Посетители бассейна:");
        for (Subscription subscription : pool) {
            if(subscription != null) System.out.println(subscription.getOwner());
        }
        System.out.println("Посетители групповых занятий:");
        for (Subscription subscription : group) {
            if(subscription != null) System.out.println(subscription.getOwner());
        }
    }
}
