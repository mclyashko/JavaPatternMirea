package ru.mirea.task15.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.mirea.task15.entities.Author;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AuthorService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Author> getAuthors() {
        return session.createQuery("select u from Author u", Author.class).getResultList(); // потом проверить
    }

    public Author getAuthorById(Integer authorId) {
        var transaction = session.beginTransaction();
        Author university = session.createQuery("select u from Author u where u.id = :id", Author.class)
                .setParameter("id", authorId).getSingleResult();
        transaction.commit();
        return university;
    }

    public void saveAuthor(Author author) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(author);
        transaction.commit();
    }

    public void deleteAuthorById(Integer id) {
        var transaction = session.beginTransaction();
        session.createQuery("delete from Author u where u.id = :id").setParameter("id", id).executeUpdate();
        transaction.commit();
    }
}
