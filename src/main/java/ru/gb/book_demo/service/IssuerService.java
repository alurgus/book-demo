package ru.gb.book_demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.book_demo.api.IssueRequest;
import ru.gb.book_demo.model.Issue;
import ru.gb.book_demo.repository.BookRepository;
import ru.gb.book_demo.repository.IssueRepository;
import ru.gb.book_demo.repository.ReaderRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssuerService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }

        Issue issue = new Issue(request.getBookId(),request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }
}
