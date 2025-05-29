package ru.gb.book_demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.book_demo.model.Book;
import ru.gb.book_demo.repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository books;

    @GetMapping ("/{id}")
    public ResponseEntity<String> getBookById(@PathVariable Long id){
       Book item = books.getBookById(id);

       if (item != null){
           return ResponseEntity.ok(item.getName());
        }else {
           return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        Book item = books.getBookById(id);
        if (books.removeBook(id)) {
            return ResponseEntity.ok("Удалено: " + item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {

        books.addItem(newBook);
        return ResponseEntity.ok(newBook);
    }*/

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest request) {
        Book newBook = new Book(request.getName()); // авто-присвоение ID в конструкторе
        books.addItem(newBook);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(books.getBooks());
    }
}
