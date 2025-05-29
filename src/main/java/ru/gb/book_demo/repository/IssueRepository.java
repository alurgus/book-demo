package ru.gb.book_demo.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;

import ru.gb.book_demo.model.Book;
import ru.gb.book_demo.model.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@Data
public class IssueRepository {
    private final List<Issue> issues;

    public IssueRepository() {
        this.issues = new ArrayList<>();
    }

    public void save(Issue issue){
        issues.add(issue);
    }

    public Issue getIssueById(long id){
        return issues.stream()
                .filter(it -> Objects.equals(it.getId(),id))
                .findFirst()
                .orElse(null);
    }
}
