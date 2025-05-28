package ru.gb.book_demo.repository;

import org.springframework.stereotype.Repository;
import ru.gb.book_demo.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository

public class BookRepository {
    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }
}
