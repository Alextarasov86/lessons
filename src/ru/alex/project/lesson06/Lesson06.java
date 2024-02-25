package ru.alex.project.lesson06;

import ru.alex.project.lesson06.books.Author;
import ru.alex.project.lesson06.books.Book;

public class Lesson06 {
    public static void main(String[] args) {
        Author author1 = new Author(1);
        author1.name = "Ольга";
        author1.email = "olga@mail.ru";

        Author author2 = new Author(2);

        Author author3 = new Author("Макар");

        Author author4 = new Author(3, "Саша", "sasha@mail.ru");

        Book book = new Book(1, "", 101);
        book.setPrice(150);
        System.out.println(book.getPrice());

    }
}
