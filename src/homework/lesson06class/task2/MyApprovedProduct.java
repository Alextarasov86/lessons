package homework.lesson06class.task2;

public class MyApprovedProduct {
    private double maxProtein;
    private double maxFat;
    private double maxCarbohydrates;
    private int maxCalories;

    public MyApprovedProduct(double maxProtein, double maxFat, double maxCarbohydrates, int maxCalories){
        if(maxProtein < 0){
            throw new IllegalArgumentException("Вы указали недопустимое значение белка");
        }
        if(maxFat < 0){
            throw new IllegalArgumentException("Вы указали недопустимое значение жиров");
        }
        if(maxCarbohydrates < 0){
            throw new IllegalArgumentException("Вы указали недопустимое значение углеводов");
        }
        if(maxCalories < 0){
            throw new IllegalArgumentException("Вы указали недопустимое значение калорий");
        }
        this.maxProtein = maxProtein;
        this.maxFat = maxFat;
        this.maxCarbohydrates = maxCarbohydrates;
        this.maxCalories = maxCalories;
    }

    boolean checkProduct(Product prod){
        if(prod.getProtein() > maxProtein ||
           prod.getFat() > maxFat ||
           prod.getCarbohydrates() > maxCarbohydrates ||
           prod.getCalories() > maxCalories){
            System.out.println("Продукт не соответствует заявленным разрешениям");
            return false;
        }
        else {
            System.out.println("Продукт соответствует заявленным разрешениям");
            return true;
        }
    }

    public static void main(String[] args) {
        MyApprovedProduct mAP = new MyApprovedProduct(15, 15, 25, 350);
        Product prod1 = new Product(12.4,29,15,250);
        prod1.setFat(12.5);
        mAP.checkProduct(prod1);
    }
}
