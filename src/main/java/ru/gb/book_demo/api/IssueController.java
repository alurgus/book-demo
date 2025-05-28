package ru.gb.book_demo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/issue")

public class IssueController {

    @PostMapping
    public void issueBook(@RequestBody IssueRequest request){
        log.info("Получен запрос на выдачу: readerId {}, bookId {}", request.getReaderId(), request.getBookId());
    }

}
