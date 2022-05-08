package ru.mirea.task21.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.task21.annotations.SendMail;
import ru.mirea.task21.entities.Author;
import ru.mirea.task21.repositories.AuthorRepository;

import java.util.List;


@Service
@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @SendMail
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Author> getAuthorsByFirstName(String firstName) {
        return authorRepository.findAllByFirstName(firstName);
    }

    public List<Author> getAuthorsByLastName(String lastName) {
        return authorRepository.findAllByLastName(lastName);
    }

    public List<Author> getAuthorsByMiddleName(String middleName) {
        return authorRepository.findAllByMiddleName(middleName);
    }

    public List<Author> getAuthorsByBirthDate(String birthDate) {
        return authorRepository.findAllByBirthDate(birthDate);
    }
}
