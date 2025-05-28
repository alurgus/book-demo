package ru.gb.book_demo.repository;

import org.springframework.stereotype.Repository;
import ru.gb.book_demo.model.Reader;


import java.util.ArrayList;
import java.util.List;

@Repository

public class ReaderRepository {
    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }
}
