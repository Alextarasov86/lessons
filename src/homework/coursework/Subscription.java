package homework.coursework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Subscription {
    private int number;
    private Owner owner;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private SubType subType;

    public Subscription(int number, Owner owner, LocalDate dateEnd, SubType subType) {
        if(number < 0){
            throw new IllegalArgumentException("Номер табонемента должен быть положительным числом");
        }
        if(owner == null){
            throw new IllegalArgumentException("Владаелец не должен быть null");
        }
        if((LocalDate.now().getYear() - owner.getYearOfBirth()) < 14){
            throw new IllegalArgumentException("Наш абонемент можно получить только с 14 лет");
        }
        if(LocalDate.now().isAfter(dateEnd)){
            throw new IllegalArgumentException("Вы указали неверную дату окончания абонемента");
        }

        if(subType == SubType.ONETIME){
            if(!LocalDate.now().equals(dateEnd)){
                throw new IllegalArgumentException("Вы указали не верную дату окончания абонемента");
            }
        }
        this.number = number;
        this.owner = owner;
        this.dateStart = LocalDate.now();
        this.dateEnd = dateEnd;
        this.subType = subType;
    }

    public int getNumber() {
        return number;
    }

    public Owner getOwner() {
        return owner;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setOwner(Owner owner) {
        if(owner == null){
            throw new IllegalArgumentException("Владаелец не должен быть null");
        }
        this.owner = owner;
    }

    public void setDateEnd(LocalDate dateEnd) {
        if(!dateStart.isBefore(dateEnd)){
            throw new IllegalArgumentException("Вы указали неверную дату окончания абонемента");
        }
        else if(subType == SubType.ONETIME){
            this.dateEnd = dateStart;
        } else {
            this.dateEnd = dateEnd;
        }
    }

    public void setType(SubType subType) {
        this.subType = subType;
    }

    public enum SubType {
        ONETIME(new Zone[]{Zone.GYM, Zone.POOL}, LocalTime.of(8, 0, 0), LocalTime.of(22, 0, 0)),
        DAY(new Zone[]{Zone.GYM, Zone.GROUP}, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0)),
        FULL(new Zone[]{Zone.GYM, Zone.POOL, Zone.GROUP}, LocalTime.of(8, 0, 0), LocalTime.of(22, 0, 0));
        private Zone[] zones;
        private LocalTime timeStart;
        private LocalTime timeEnd;

        SubType(Zone[] zones, LocalTime timeStart, LocalTime timeEnd){
            this.zones = zones;
            this.timeStart = timeStart;
            this.timeEnd = timeEnd;
        }

    }
    public enum Zone {
        GYM, POOL, GROUP;
    }
}
