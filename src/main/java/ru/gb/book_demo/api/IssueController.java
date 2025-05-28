package ru.gb.book_demo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.book_demo.model.Issue;
import ru.gb.book_demo.service.IssuerService;

import java.util.NoSuchElementException;


@Slf4j
@RestController
@RequestMapping("/issue")

public class IssueController {

    @Autowired
    private IssuerService service;

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request){
        log.info("Получен запрос на выдачу: readerId {}, bookId {}", request.getReaderId(), request.getBookId());

        final Issue issue;

        try{
            issue = service.issue(request);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(issue);

    }

}
