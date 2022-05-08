package ru.mirea.task21.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task21.entities.Book;
import ru.mirea.task21.entities.Dto.AuthorDto;
import ru.mirea.task21.services.BookService;

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
    public boolean deleteBook(Long id) {
        bookService.deleteBookById(id);
        return bookService.getBooks().size() != 0;
    }

    @GetMapping("/get_books/{bookId}/author")
    @ResponseBody
    public AuthorDto getAuthorByBookId(@PathVariable Long bookId) {
        return bookService.getAuthorByBookId(bookId);
    }

    @GetMapping("/get_books/name/{name}")
    @ResponseBody
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }

    @GetMapping("/get_books/date/{date}")
    @ResponseBody
    public List<Book> getBooksByCreationDate(@PathVariable String date) {
        return bookService.getBooksByCreationDate(date);
    }

    @GetMapping("/get_books/author_id/{author_id}")
    @ResponseBody
    public List<Book> getBooksByAuthorId(@PathVariable Long author_id) {
        return bookService.getBooksByAuthorId(author_id);
    }
}
