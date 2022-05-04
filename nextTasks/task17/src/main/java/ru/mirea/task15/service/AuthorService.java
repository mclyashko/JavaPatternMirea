package ru.mirea.task15.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.mirea.task15.entities.Author;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
                .setParameter("id",  authorId).getSingleResult();
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

    public <T> List<Author> getAuthorsFilteredBy(String attribute, T value) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> query = cb.createQuery(Author.class);
        Root<Author> root = query.from(Author.class);

        Predicate predicate = cb.equal(root.get(attribute), value);

        query.select(root).where(predicate);

        return session.createQuery(query).getResultList();
    }
}
