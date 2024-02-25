package ru.alex.project.lesson06.books;

public class Author {
    public int id;
    public String name;
    public String email;

    public Author(){
        System.out.println("Default constructor created");
    }

    public Author(int authorId){
        id = authorId;
        System.out.println("Author with ID created");
    }

    public Author(String authorName){
        name = authorName;
        System.out.println("Author with Name created");
    }

    public Author(int id, String name, String email){
        this(name);
        this.id = id;
        this.email = email;
        System.out.println("Author created");
    }
}
