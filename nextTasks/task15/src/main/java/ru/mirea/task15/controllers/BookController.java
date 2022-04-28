package ru.mirea.task15.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
}
