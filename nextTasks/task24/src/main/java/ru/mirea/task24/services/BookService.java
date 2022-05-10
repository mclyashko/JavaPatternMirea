package ru.mirea.task24.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.task24.annotations.SendMail;
import ru.mirea.task24.entities.Book;
import ru.mirea.task24.entities.dto.AuthorDto;
import ru.mirea.task24.entities.dto.BookDto;
import ru.mirea.task24.repositories.AuthorRepository;
import ru.mirea.task24.repositories.BookRepository;

import java.util.List;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BookService {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final AuthorRepository authorRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @SendMail
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public AuthorDto getAuthorByBookId(Long bookId) {
        BookDto bookDto = bookRepository.getById(bookId).makeDto();
        return authorRepository.getById(bookDto.getAuthorId()).makeDto();
    }

    public List<Book> getBooksByName(String name) {
        return bookRepository.findAllByName(name);
    }

    public List<Book> getBooksByCreationDate(String creationDate) {
        return bookRepository.findAllByCreationDate(creationDate);
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }
}
