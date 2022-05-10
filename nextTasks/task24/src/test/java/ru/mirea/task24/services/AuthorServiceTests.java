package ru.mirea.task24.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.mirea.task24.entities.Author;
import ru.mirea.task24.repositories.AuthorRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        AuthorService.class
})
public class AuthorServiceTests {
    @MockBean
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @Test
    public void getAuthorsByFirstName() {
        // given
        List<Author> authorList = List.of(getAuthor());
        String firstName = getAuthor().getFirstName();
        Mockito.when(authorRepository.findAllByFirstName(firstName)).thenReturn(authorList);

        // when
        List<Author> get = authorService.getAuthorsByFirstName(firstName);

        // then
        Mockito.verify(authorRepository,Mockito.times(1)).findAllByFirstName(firstName);
        assertThat(authorList).isEqualTo(get);
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
}
