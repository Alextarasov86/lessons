package homework.lesson06class.task2;

public class Product {
    private String name;
    private double protein;
    private double fat;
    private double carbohydrates;
    private int calories;

    public Product(){}

    public Product(String name){
        if (name.length() < 3){
            throw new IllegalArgumentException("В названии слишком мало букв");
        }
        this.name = name;
    }

    public Product(double protein, double fat, double carbohydrates, int calories){
        if(protein < 0){
            throw new IllegalArgumentException("Слишком мало белка");
        }
        if(fat < 0){
            throw new IllegalArgumentException("Слишком мало жиров");
        }
        if(carbohydrates < 0){
            throw new IllegalArgumentException("Слишком мало калорий");
        }
        if(calories < 0){
            throw new IllegalArgumentException("Слишком мало калорий");
        }

        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public Product(String name, double protein, double fat, double carbohydrates, int calories){
        if (name.length() < 3){
            throw new IllegalArgumentException("В названии слишком мало букв");
        }
        if(calories < 0){
            throw new IllegalArgumentException("Слишком мало калорий");
        }
        if(protein < 0){
            throw new IllegalArgumentException("Слишком мало белка");
        }
        if(fat < 0){
            throw new IllegalArgumentException("Слишком мало жиров");
        }
        if(carbohydrates < 0){
            throw new IllegalArgumentException("Слишком мало калорий");
        }

        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setProtein(double protein){
        this.protein = protein;
    }
    public void setFat(double fat){
        this.fat = fat;
    }
    public void setCarbohydrates(double carbohydrates){
        this.carbohydrates = carbohydrates;
    }
    public void setCalories(int calories){
        this.calories =calories;
    }

    public String getName() {
        return name;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public int getCalories() {
        return calories;
    }

    public static void main(String[] args) {
        Product prod1 = new Product("milk", 2.8, 3.5, 4,42 );
        Product prod2 = new Product("mayonnaise", 1, 75, 0.6,680 );
        Product prod3 = new Product("bread", 9, 3.2, 49,265 );
        Product prod4 = new Product("avocado", 2, 14, 1.8,200 );
    }
}
