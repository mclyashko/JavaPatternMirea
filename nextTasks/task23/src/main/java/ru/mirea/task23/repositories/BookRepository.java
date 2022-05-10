package ru.mirea.task23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.task23.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByName(String name);
    List<Book> findAllByCreationDate(String creationDate);
    List<Book> findAllByAuthorId(Long authorId);
}
