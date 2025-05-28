package ru.gb.book_demo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.book_demo.model.Book;
import ru.gb.book_demo.model.Reader;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository

public class ReaderRepository {
    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generatedData(){
        readers.addAll(List.of(
                new Reader("John")

        ));
    }
    public Reader getReaderById(long id){
        return readers.stream()
                .filter(it -> Objects.equals(it.getId(),id))
                .findFirst()
                .orElse(null);
    }
}
