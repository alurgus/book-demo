package ru.gb.book_demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.book_demo.model.Book;
import ru.gb.book_demo.model.Reader;
import ru.gb.book_demo.repository.BookRepository;
import ru.gb.book_demo.repository.ReaderRepository;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ReaderRepository readers;

    @GetMapping ("/{id}")
    public ResponseEntity<String> getReaderById(@PathVariable Long id){
        Reader item = readers.getReaderById(id);

        if (item != null){
            return ResponseEntity.ok(item.getName());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReader(@PathVariable Long id) {
        Reader item = readers.getReaderById(id);
        if (readers.removeReader(id)) {
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
    public ResponseEntity<Reader> createBook(@RequestBody CreateReaderRequest request) {
        Reader newReader = new Reader(request.getName()); // авто-присвоение ID в конструкторе
        readers.addItem(newReader);
        return ResponseEntity.ok(newReader);
    }

    @GetMapping
    public ResponseEntity<List<Reader>> getAllBooks() {
        return ResponseEntity.ok(readers.getReaders());
    }
}
