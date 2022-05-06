package ru.mirea.task18.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mirea.task18.entities.Author;
import ru.mirea.task18.repositories.AuthorRepository;

import java.util.List;


@Service
@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        log.info("Find all authors");
        return authorRepository.findAll();
    }

    public void saveAuthor(Author author) {
        log.info("Save author {}", author);
        authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        log.info("Delete author {}", id);
        authorRepository.deleteById(id);
    }

    public List<Author> getAuthorsByFirstName(String firstName) {
        log.info("getAuthorsByFirstName {}", firstName);
        return authorRepository.findAllByFirstName(firstName);
    }

    public List<Author> getAuthorsByLastName(String lastName) {
        log.info("getAuthorsByLastName {}", lastName);
        return authorRepository.findAllByLastName(lastName);
    }

    public List<Author> getAuthorsByMiddleName(String middleName) {
        log.info("getAuthorsByMiddleName {}", middleName);
        return authorRepository.findAllByMiddleName(middleName);
    }

    public List<Author> getAuthorsByBirthDate(String birthDate) {
        log.info("getAuthorsByBirthDate {}", birthDate);
        return authorRepository.findAllByBirthDate(birthDate);
    }
}
