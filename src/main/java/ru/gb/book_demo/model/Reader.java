package ru.gb.book_demo.model;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Reader {
    public static Long sequence = 1L;

    private final Long id;
    private final String name;

    public Reader(String name) {
        this(sequence++, name) ;
    }


}
