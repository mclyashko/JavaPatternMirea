package ru.mirea.task24.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.mirea.task24.entities.Book;
import ru.mirea.task24.repositories.AuthorRepository;
import ru.mirea.task24.repositories.BookRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        BookService.class
})
public class BookServiceTests {
    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    public void getBooksByName() {
        // given
        List<Book> bookList = List.of(getBook());
        String name = getBook().getName();
        Mockito.when(bookRepository.findAllByName(name)).thenReturn(bookList);

        // when
        List<Book> get = bookService.getBooksByName(name);

        // then
        Mockito.verify(bookRepository, Mockito.times(1)).findAllByName(name);
        assertThat(bookList).isEqualTo(get);
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
