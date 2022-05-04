package ru.mirea.task15.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mirea.task15.entities.Author;
import ru.mirea.task15.entities.Book;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    AuthorService authorService;

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

    public Author getAuthor(Integer bookId) {
        var transaction = session.beginTransaction();
        Book book = session.createQuery("select u from Book u where u.id = :id", Book.class)
                .setParameter("id", bookId).getSingleResult();
        Author author = authorService.getAuthorById(book.getAuthorId());
        transaction.commit();
        return author;
    }

    public <T> List<Book> getBooksFilteredBy(String attribute, T value) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        Predicate predicate = cb.equal(root.get(attribute), value);

        query.select(root).where(predicate);

        return session.createQuery(query).getResultList();
    }
}
