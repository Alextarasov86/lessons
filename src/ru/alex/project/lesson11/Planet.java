package ru.alex.project.lesson11;

public enum Planet {
    MARS("mars", 1000, 5000),
    URAN("uran", 2000, 7000),
    JUPITER("jupiter", 5000, 20000);
    private int radius;
    private String title;
    private int mass;

    Planet(String title, int radius, int mass){
        this.title = title;
        this.mass = mass;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public String getTitle() {
        return title;
    }

    public int getMass() {
        return mass;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "radius=" + radius +
                ", title='" + title + '\'' +
                ", mass=" + mass +
                '}';
    }


    public static void main(String[] args) {
        Planet[] planets = Planet.values();
        for(int i = 0; i< planets.length; i++){
            System.out.println(planets[i].toString());
        }
    }
}
