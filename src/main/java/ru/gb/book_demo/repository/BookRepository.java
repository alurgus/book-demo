package ru.gb.book_demo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.book_demo.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository

public class BookRepository {
    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    @PostConstruct
    public void generatedData(){
        books.addAll(List.of(
                new Book("война и мир"),
                new Book("нахаленок"),
                new Book("му-му")
        ));
    }
    public Book getBookById(long id){
        return books.stream()
                .filter(it -> Objects.equals(it.getId(),id))
                .findFirst()
                .orElse(null);
    }
}
