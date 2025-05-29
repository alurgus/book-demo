package ru.gb.book_demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {

    public static Long sequence = 1L;

    private final Long id;
    private final String name;


    public Book(String name) {
        this(sequence++, name) ;
    }


}
