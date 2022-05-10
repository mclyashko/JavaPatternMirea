package ru.mirea.task24.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.mirea.task24.entities.Author;
import ru.mirea.task24.entities.Book;

import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        SchedulerService.class
})
public class SchedulerServiceTests {
    @MockBean
    private AuthorService authorService;

    @MockBean
    private BookService bookService;

    @Autowired
    private SchedulerService schedulerService;

    @Test
    public void backupMe() throws IOException {
        // given
        List<Author> authorList = List.of(getAuthor());
        Mockito.when(authorService.getAuthors()).thenReturn(authorList);

        List<Book> bookList = List.of(getBook());
        Mockito.when(bookService.getBooks()).thenReturn(bookList);

        // when
        schedulerService.backupMe();

        // then
        Mockito.verify(authorService, Mockito.times(1)).getAuthors();
        Mockito.verify(bookService, Mockito.times(1)).getBooks();
    }

    private Author getAuthor() {
        Author author = new Author();

        author.setId(1L);
        author.setFirstName("A");
        author.setLastName("B");
        author.setMiddleName("C");
        author.setBirthDate("0");

        return author;
    }

    private Book getBook() {
        Book book = new Book();

        book.setId(1L);
        book.setName("A");
        book.setCreationDate("B");
        book.setAuthorId(1L);

        return book;
    }
}
