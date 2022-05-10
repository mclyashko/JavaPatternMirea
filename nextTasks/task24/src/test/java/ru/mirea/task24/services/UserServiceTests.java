package ru.mirea.task24.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.mirea.task24.entities.User;
import ru.mirea.task24.repositories.AuthorRepository;
import ru.mirea.task24.repositories.UserRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        UserService.class
})
public class UserServiceTests {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Test
    public void create() {
        // given
        User user = getUser();
        Mockito.when(passwordEncoder.encode(user.getPassword())).
                thenReturn("$2a$10$lb.fBytxRRqUGNl0YOhideSJqFphce0L.DhHtryer9Q3WQgDoOdeS");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        // when
        User get = userService.create(user);

        // then
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Assertions.assertEquals(user, get);
    }

    private User getUser() {
        User user = new User();

        user.setId(1L);
        user.setLogin("admin");
        user.setPassword("admin");

        return user;
    }
}
