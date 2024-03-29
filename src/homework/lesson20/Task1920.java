package homework.lesson20;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Task1920 {
    public static void main(String[] args) {
        // Написать реализацию методов task01 - task04
        // Перед выполнением посмотрите методы flatMap / flatMapToInt / map / mapToInt / allMatch / anyMatch / noneMatch
        // Некоторые из этих методов могут понадобиться при решении задач
        Author author1 = new Author("Oleg", "oleg@mail.ru", LocalDate.of(1965, 12, 23));
        Author author2 = new Author("Dmitriy", "dmitriy@mail.ru", LocalDate.of(1970, 1, 2));
        Author author3 = new Author("Mariya", "mariya@mail.ru", LocalDate.of(1975, 2, 3));
        Author author4 = new Author("Ivan", "ivan@mail.ru", LocalDate.of(1980, 10, 9));
        Author author5 = new Author("Ivan", "ivan2@mail.ru", LocalDate.of(1988, 8, 29));
        Author author6 = new Author("Olga", "olga@mail.ru", LocalDate.of(1960, 4, 19));

        Article article1 = new Article("Travel1", Article.Category.TRAVELLING, author1,author2);
        article1.setPublished(LocalDateTime.now());
        Article article2 = new Article("Food", Article.Category.FOOD, author5,author2);
        Article article3 = new Article("History1", Article.Category.HISTORY, author4);
        article3.setPublished(LocalDateTime.of(2021, 1, 30, 8, 0,0));
        Article article4 = new Article("Shopping", Article.Category.SHOPPING, author1,author5);
        Article article5 = new Article("History2", Article.Category.HISTORY, author6,author2);
        article5.setPublished(LocalDateTime.of(2023, 6, 24, 12, 0, 0));
        Article article6 = new Article("History3", Article.Category.HISTORY, author5,author3,author2);
        Article article7 = new Article("Travel2", Article.Category.TRAVELLING, author1,author3);
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
        articles.add(article7);
        task03(articles, Article.Category.HISTORY, 20,55 );
        task01(articles);
        task02(articles, Article.Category.TRAVELLING);
        task04(articles, Article.Category.HISTORY);

    }

    public static double task01(ArrayList<Article> articles) {
        // Вернуть средний возраст авторов статей
        List<LocalDate> list = articles.stream().flatMap(article -> article.getAuthors().values().
                stream().map(author -> author.getBirth())).toList();
        double count = 0;

        for (LocalDate localDate : list) {
            count += LocalDate.now().getYear() - localDate.getYear();

        }
        System.out.println(count / list.size());
        return count /list.size();
    }

    public static List<String> task02(ArrayList<Article> articles, Article.Category category) {
        // Вернуть список email авторов статей категории == category
        List<String> list = articles.stream().filter(article -> article.getCategory() == category).
                flatMap(article -> article.getAuthors().values().stream().map(author -> author.getEmail())).distinct().toList();
        System.out.println(list);
        return list;
    }

    public static List<Article> task03(ArrayList<Article> articles, Article.Category category, int min, int max) {
        // Вернуть список статей категории == category,
        // возраст авторов которых попадает в диапазон от min до max
        List<Article> articleList = articles.stream().filter(article -> article.getCategory() == category).toList();

        List<Author> authorList = articleList.stream().flatMap(article ->
             article.getAuthors().values().stream().filter(author ->
                 (LocalDate.now().getYear() - author.getBirth().getYear()) < max &&
                        (LocalDate.now().getYear() - author.getBirth().getYear()) > min)
                ).toList();
        ArrayList<Article> myList = new ArrayList<>();
        for (Article article : articleList) {
            if(article.getAuthors().values().stream().allMatch(author -> authorList.contains(author))){
                myList.add(article);
            }
        }
        myList.stream().forEach(article -> System.out.println(article.getTitle()));
        return myList;
    }

    public static List<Article> task04(ArrayList<Article> articles, Article.Category category) {
        // Вернуть список статей категории == category, опубликованных сегодня
        List<Article> articleList = articles.stream().filter(article -> article.getCategory() == category).toList();
        List<Article> articleList2 = articleList.stream().filter(article -> article.getPublished().getYear() == LocalDateTime.now().getYear() &&
                article.getPublished().getMonth() == LocalDateTime.now().getMonth() &&
                article.getPublished().getDayOfMonth() == LocalDateTime.now().getDayOfMonth()).toList();
        articleList2.stream().forEach(article -> System.out.println(article.getTitle()));
        return articleList2;
    }
}