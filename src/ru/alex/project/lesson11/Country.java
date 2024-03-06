package ru.alex.project.lesson11;

public enum Country {
    // Country.UK.setTitle(String title) - щбращение к сеттерам и геттерам
    USA("usa", 235423545){
        @Override
        public void printInfo(){}

    },
    UK("uk", 1243243){
        @Override
        public void printInfo(){}
    },
    BRAZIL("brazile", 124234){
        @Override
        public void printInfo(){}
    };
    private String title;
    private long population;

    Country(String title, long population) {
        this.title = title;
        this.population = population;
    }

    public String getTitle() {
        return title;
    }

    public long getPopulation() {
        return population;
    }

    abstract void printInfo();
}
