package ru.alex.project.books;

public class Book {
    private int id;
    private String name;
    private int numberOfPages;
    private int price;
    private Author[] authors;

    public Book(int id, String name, int price){
        if(id < 0){
            throw new IllegalArgumentException("id должно быть положительным");
        }
        if(price < 100){
            throw new IllegalArgumentException("price должна быть больше 100");
        }
        if("".equals(name)){
            throw new IllegalArgumentException("Название не может быть пустой строкой");
        }
        this.id = id;
        this.name = name;
        this.price = price;

    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setNumberOfPages(int numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getPrice() {
        return price;
    }
}
