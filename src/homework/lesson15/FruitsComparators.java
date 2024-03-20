package homework.lesson15;

import java.util.Comparator;

public class FruitsComparators {
    public static class CountComparator implements Comparator<FruitToStorageInfo>{

        @Override
        public int compare(FruitToStorageInfo o1, FruitToStorageInfo o2) {
            return o1.getCount() - o2.getCount();
        }
    }
    public static class PriceComparator implements Comparator<FruitToStorageInfo>{

        @Override
        public int compare(FruitToStorageInfo o1, FruitToStorageInfo o2) {
            return (int) (o2.getPrice() - o1.getPrice());
        }
    }
    public static class TypeComparator implements Comparator<FruitToStorageInfo>{

        @Override
        public int compare(FruitToStorageInfo o1, FruitToStorageInfo o2) {
            return o1.getType().compareTo(o2.getType());
        }
    }

    public static class CountAndPriceComparator implements Comparator<FruitToStorageInfo>{

        @Override
        public int compare(FruitToStorageInfo o1, FruitToStorageInfo o2) {
            if(o2.getCount() - o1.getCount() == 0){
                return (int) (o1.getPrice() - o2.getPrice());
            }
            return o2.getCount() - o1.getCount();
        }
    }
}
