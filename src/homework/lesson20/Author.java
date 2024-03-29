package homework.lesson20;

import java.time.LocalDate;
import java.util.Objects;

public class Author {
    private final String name;
    private final String email;
    private LocalDate birth;

    public Author(String name, String email, LocalDate birth) {
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
    public LocalDate getBirth() {
        return birth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(email, author.email) && Objects.equals(birth, author.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, birth);
    }
}