package ru.mirea.task15.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.mirea.task15.entities.Book;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Book> getBooks() {
        return session.createQuery("select u from Book u", Book.class).getResultList(); // потом проверить
    }

    public void saveBook(Book book) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();
    }

    public void deleteBookById(Integer id) {
        var transaction = session.beginTransaction();
        session.createQuery("delete from Book u where u.id = :id").setParameter("id", id).executeUpdate();
        transaction.commit();
    }
}
