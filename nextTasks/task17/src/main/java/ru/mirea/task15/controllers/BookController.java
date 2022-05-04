package ru.mirea.task15.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task15.entities.Author;
import ru.mirea.task15.entities.Book;
import ru.mirea.task15.service.BookService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/get_books")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(value = "/add_book")
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return book.toString();
    }

    @DeleteMapping(value = "/delete_book")
    @ResponseBody
    public boolean deleteBook(Integer id) {
        bookService.deleteBookById(id);
        return bookService.getBooks().size() != 0;
    }

    @GetMapping("/get_books/{bookId}/author")
    @ResponseBody
    public Author getAuthorByBookId(@PathVariable Integer bookId) {
        return bookService.getAuthor(bookId);
    }

    @GetMapping("/get_books/name/{name}")
    @ResponseBody
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksFilteredBy("name", name);
    }

    @GetMapping("/get_books/date/{date}")
    @ResponseBody
    public List<Book> getBooksByDate(@PathVariable String date) {
        return bookService.getBooksFilteredBy("creationDate", date);
    }

    @GetMapping("/get_books/author_id/{author_id}")
    @ResponseBody
    public List<Book> getBooksByAuthorId(@PathVariable Integer author_id) {
        return bookService.getBooksFilteredBy("authorId", author_id);
    }
}
