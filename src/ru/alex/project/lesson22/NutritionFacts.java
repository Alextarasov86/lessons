package ru.alex.project.lesson22;

public class NutritionFacts {
    private final String name;
    private final int calories;
    private final int fat;
    private final int servings;

    private NutritionFacts(Builder builder){
        name = builder.name;
        calories = builder.cal;
        fat = builder.f;
        servings = builder.ser;
    }

    public static class Builder{
        String name;
        int cal;
        int f;
        int ser;

        Builder(String name){
            this.name = name;
        }

        public Builder calories(int calories){
            cal = calories;
            return this;
        }
        public Builder fat(int fat){
            f = fat;
            return this;
        }

        public Builder servings(int servings){
            ser = servings;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    public static void main(String[] args) {
        // NutritionFacts milk = new NutritionFacts("молоко");
        // milk.setFat(10);
        NutritionFacts milk = new NutritionFacts.Builder("молоко")
                .fat(10) // жирность
                .calories(30)
                .servings(10)
                .build(); // создает и возвращает NutritionFacts
        System.out.println(milk.servings);
        // NutritionFacts meat = new NutritionFacts("мясо");
        // meat.setCalories(300);
        // meat.setServings(200);
        // meat.setFat(80);
        NutritionFacts meat = new NutritionFacts.Builder("мясо")
                .calories(300) // калории
                .servings(200) // порции
                .fat(80) // жирность
                .build(); // создает и возвращает NutritionFacts
    }

}
