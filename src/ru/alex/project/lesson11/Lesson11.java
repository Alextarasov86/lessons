package ru.alex.project.lesson11;

public class Lesson11 {
    public static void main(String[] args) {
        Point point1 = new Point(2, 8);
        Point point2 = new Point(2, 8);

        System.out.println(point1);
        System.out.println(point1.equals(point2));

        Figure figure01 = new Figure(2);
        Figure figure02 = new Figure(2);
        figure01.addPoint(point1);
        figure01.addPoint(point2);

        figure02.addPoint(point1);
        figure02.addPoint(point2);

        Figure figure3 = figure01.clone();
        System.out.println(figure3.equals(figure01));

//        System.out.println(figure01.equals(figure02));

        Country country = Country.USA;
        Article article = new Article(country);
        Article article1 = new Article(Country.UK);

        System.out.println(country == article1.getCountry());

        Country[] countries = Country.values();
        int index = Country.UK.ordinal();
        String name1 = Country.UK.name(); //UK
        String name2 = Country.UK.toString(); //UK
    }
}
