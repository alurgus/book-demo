package ru.gb.book_demo.api;

import lombok.Data;

/**
    * запрос на выдачу
*/
@Data
public class IssueRequest {

    private long readerId;
    private long bookId;
}
