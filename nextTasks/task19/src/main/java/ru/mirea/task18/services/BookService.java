package ru.mirea.task18.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mirea.task18.entities.Book;
import ru.mirea.task18.entities.Dto.AuthorDto;
import ru.mirea.task18.entities.Dto.BookDto;
import ru.mirea.task18.repositories.AuthorRepository;
import ru.mirea.task18.repositories.BookRepository;

import java.util.List;


@Service
@Component
@RequiredArgsConstructor
@Slf4j
public class BookService {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final AuthorRepository authorRepository;

    public List<Book> getBooks() {
        log.info("Find all books");
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        log.info("Save book {}", book);
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        log.info("Delete book {}", id);
        bookRepository.deleteById(id);
    }

    public AuthorDto getAuthorByBookId(Long bookId) {
        log.info("getAuthorByBookId {}", bookId);
        BookDto bookDto = bookRepository.getById(bookId).makeDto();
        AuthorDto authorDto = authorRepository.getById(bookDto.getAuthorId()).makeDto();
        return authorDto;
    }

    public List<Book> getBooksByName(String name) {
        log.info("getBooksByName {}", name);
        return bookRepository.findAllByName(name);
    }

    public List<Book> getBooksByCreationDate(String creationDate) {
        log.info("getBooksByCreationDate {}", creationDate);
        return bookRepository.findAllByCreationDate(creationDate);
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        log.info("getBooksByAuthorId {}", authorId);
        return bookRepository.findAllByAuthorId(authorId);
    }
}