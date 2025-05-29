package ru.gb.book_demo.repository;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.gb.book_demo.model.Book;
import ru.gb.book_demo.model.Reader;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@Repository

public class ReaderRepository {
    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generatedData(){
        readers.addAll(List.of(
                new Reader("John"),
                new Reader("Ivan"),
                new Reader("Vasiliy"),
                new Reader("Nikolay")

        ));


    }
    public Reader getReaderById(long id){
        return readers.stream()
                .filter(it -> Objects.equals(it.getId(),id))
                .findFirst()
                .orElse(null);
    }
    public boolean removeReader(long id){
        return readers.removeIf(reader -> reader.getId().equals(id));

    }
    public void addItem(Reader reader){
        readers.add(reader);
    }
}
