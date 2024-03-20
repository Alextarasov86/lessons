package homework.lesson15;

import java.util.Objects;

// содержит информацию о фруктах,
// которые будут добавляться на склад
public class FruitToStorageInfo {
    private final FruitType type;
    private double price; // за один фрукт
    private int count; // количество добавляемых фруктов

    public FruitToStorageInfo(FruitType type, double price, int count) {
        this.type = type;
        this.price = price;
        this.count = count;
    }

    public FruitType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void updateCount(int count){
        this.count += count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FruitToStorageInfo that = (FruitToStorageInfo) o;
        return Double.compare(that.price, price) == 0 && count == that.count && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, count);
    }

    @Override
    public String toString() {
        return "FruitToStorageInfo{" +
                "type=" + type +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    // конструктор, принимающий значения всех свойств + проверки

    // доступные геттеры и сеттеры

    // equals + hashCode + toString
    public enum FruitType {
        APPLE, PEAR, BANANA, APRICOT;
    }
}