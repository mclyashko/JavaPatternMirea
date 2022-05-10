package ru.mirea.task24.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.mirea.task24.entities.Book;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        EmailService.class
})
public class EmailServiceTests {
    @MockBean
    JavaMailSender javaMailSender;

    @Autowired
    private EmailService emailService;

    @Test
    public void sendNotification() {
        // given
        Book book = getBook();
        Mockito.doNothing().when(javaMailSender).send(Mockito.any(SimpleMailMessage.class));

        // when
        emailService.sendNotification(book);

        // then
        Mockito.verify(javaMailSender,Mockito.times(1)).send(Mockito.any(SimpleMailMessage.class));
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
