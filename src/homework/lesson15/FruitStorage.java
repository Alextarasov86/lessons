package homework.lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

// склад содержит информацию о добавленных фруктах+
public class FruitStorage {
    // максимальное количество фруктов
    // заполняемость зависит не от количества переданных FruitToStorageInfo,
    // а от значения свойства count
    private int numberOfSlots;
    ArrayList<FruitToStorageInfo> fruits;
    // коллекция fruits, для хранения экземпляров FruitToStorageInfo
    // TODO: КОЛЛЕКЦИЮ ВЫБРАТЬ САМОСТОЯТЕЛЬНО

    public FruitStorage(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    // TODO: НАПИСАТЬ РЕАЛИЗАЦИЮ СЛЕДУЮЩИХ МЕТОДОВ
    public boolean addToStorage(FruitToStorageInfo toStorageInfo){
        if(toStorageInfo != null){
            if(!fruits.contains(toStorageInfo)){
                for(int i = 0; i < fruits.size(); i++){
                    if(fruits.get(i).getType() == toStorageInfo.getType() &&
                        fruits.get(i).getPrice() == toStorageInfo.getPrice()) {
                            if(numberOfSlots > toStorageInfo.getCount()){
                                fruits.get(i).updateCount(toStorageInfo.getCount());
                                numberOfSlots -= toStorageInfo.getCount();
                                return true;
                            }
                    }
                }
                if(numberOfSlots > toStorageInfo.getCount()){
                    fruits.add(toStorageInfo);
                    numberOfSlots -= toStorageInfo.getCount();
                    return true;
                }
            }
        }
        // Информация о фруктах добавляется в хранилище по следующим правилам:
        // 1. fruit не может быть null;
        // 2. fruit не может быть ссылкой на существующий элемент коллекции
        // 3. если в коллекции fruits уже есть фрукт с типом и ценой, как у toStorageInfo,
        //   увеличивать значение свойства count фрукта коллекции на значение свойства count toStorageInfo.
        //   В противном случае добавлять toStorageInfo в коллекцию fruits.
        //   numberOfSlots уменьшается на значение count добавляемого фрукта.
        // 4. в хранилище нельзя добавить больше numberOfSlots фруктов
        return false;
    }

    // вернуть количество фруктов определённого типа
    public int getNumberOfFruitsByType(FruitToStorageInfo.FruitType fruitType) {
        int countFruit = 0;
        for(int i = 0; i < fruits.size(); i++){
            if(fruits.get(i).getType().equals(fruitType)){
                countFruit += fruits.get(i).getCount();
            }
        }
        return countFruit;
    }

    // вернуть количество свободных мест в хранилище
    public int getNumberOfEmptySlots(){
        return numberOfSlots;
    }

    public void increasePrice(int value){
        if(value >= 10 && value < 30){
            for(int i = 0; i < fruits.size(); i++){
                fruits.get(i).setPrice(fruits.get(i).getPrice() + (fruits.get(i).getPrice() / 100) * value);
            }
        }
        // value может быть в диапазоне [10; 30)
        // увеличить цену всех фруктов на value процентов
    }

    public List<FruitToStorageInfo> getFruitsByTypeAndPrice(FruitToStorageInfo.FruitType fruitType, int maxPrice) {
        List<FruitToStorageInfo> list = new ArrayList<>();
        if(maxPrice > 0 && fruitType != null){
            for (int i = 0; i < fruits.size(); i++){
                if(fruits.get(i).getType().equals(fruitType) && fruits.get(i).getPrice() <= maxPrice){
                    list.add(fruits.get(i));
                }
            }
        }
        // maxPrice должна быть положительной, fruitType не null
        // возвращает список, в который войдут фрукты из коллекции fruits
        // с типом fruitType и ценой не выше maxPrice
        return list;
    }

    public double getMinPriceByType(FruitToStorageInfo.FruitType fruitType){
        double minPrice = 0;
        for(int i = 0; i < fruits.size(); i++ ){
            if(fruits.get(i).getType().equals(fruitType)){
                minPrice = fruits.get(i).getPrice();
                break;
            }
        }
        for(int i = 0; i < fruits.size(); i++){
            if(fruits.get(i).getType().equals(fruitType) && minPrice > fruits.get(i).getPrice()){
                minPrice = fruits.get(i).getPrice();
            }
        }
        // вернуть минимальную цену фрукта с типом fruitType
        return minPrice;
    }

    public TreeSet<FruitToStorageInfo> sortFruit(FruitsComparators.CountComparator fruitComp){
        TreeSet<FruitToStorageInfo> treeSet = new TreeSet<>(fruitComp);
        for (FruitToStorageInfo fruit : fruits) {
            if(fruit != null){
                treeSet.add(fruit);
            }
        }
        return treeSet;
    }
}