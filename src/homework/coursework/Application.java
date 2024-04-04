package homework.coursework;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.plusDays(1);

        Owner owner1 = new Owner("Alex", "Ivanov", 2002);
        Owner owner2 = new Owner("Ivan", "Petrov", 1975);
        Owner owner3 = new Owner("Mariya", "Sidorova", 1990);
        Owner owner4 = new Owner("Olga", "Pavlova", 1983);
        Owner owner5 = new Owner("Liliya", "Tarasova", 1992);
        Owner owner6 = new Owner("Anton", "Maslov", 1980);
        Owner owner7 = new Owner("Mikhail", "Popov", 1998);

        Subscription subscription1 = new Subscription(1, owner1, LocalDate.now(), Subscription.SubType.ONETIME);
        Subscription subscription2 = new Subscription(2, owner2, LocalDate.now(), Subscription.SubType.ONETIME);
        Subscription subscription3 = new Subscription(3, owner3, LocalDate.of(2024, 12, 31), Subscription.SubType.DAY);
        Subscription subscription4 = new Subscription(4, owner4, LocalDate.of(2024, 6, 30), Subscription.SubType.DAY);
        Subscription subscription5 = new Subscription(5, owner5, LocalDate.of(2025, 2, 28), Subscription.SubType.FULL);
        Subscription subscription6 = new Subscription(6, owner6, LocalDate.of(2024, 12, 31), Subscription.SubType.FULL);

        Fitness fitness = new Fitness();
        fitness.createGroups(20);
        fitness.addSubscription(Fitness.Zone.GROUP, subscription5);
        fitness.addSubscription(Fitness.Zone.GYM, subscription1);
        fitness.addSubscription(Fitness.Zone.POOL, subscription6);
        fitness.addSubscription(Fitness.Zone.POOL, subscription2);
        fitness.addSubscription(Fitness.Zone.GYM, subscription3);

        fitness.currentSubscriptionsInfo();
    }
}
