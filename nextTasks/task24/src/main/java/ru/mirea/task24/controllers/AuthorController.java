package ru.mirea.task24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task24.entities.Author;
import ru.mirea.task24.services.AuthorService;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/get_authors")
    @ResponseBody
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping(value = "/add_author")
    @ResponseBody
    public String addAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return author.toString();
    }

    @DeleteMapping(value = "/delete_author")
    @ResponseBody
    public boolean deleteBook(Long id) {
        authorService.deleteAuthorById(id);
        return authorService.getAuthors().size() != 0;
    }

    @GetMapping("/get_authors/first_name/{first_name}")
    @ResponseBody
    public List<Author> getAuthorsByFirstName(@PathVariable String first_name) {
        return authorService.getAuthorsByFirstName(first_name);
    }

    @GetMapping("/get_authors/last_name/{last_name}")
    @ResponseBody
    public List<Author> getAuthorsByLastName(@PathVariable String last_name) {
        return authorService.getAuthorsByLastName(last_name);
    }

    @GetMapping("/get_authors/middle_name/{middle_name}")
    @ResponseBody
    public List<Author> getAuthorsByMiddleName(@PathVariable String middle_name) {
        return authorService.getAuthorsByMiddleName(middle_name);
    }

    @GetMapping("/get_authors/date/{date}")
    @ResponseBody
    public List<Author> getAuthorsByBirthDate(@PathVariable String date) {
        return authorService.getAuthorsByBirthDate(date);
    }
}
