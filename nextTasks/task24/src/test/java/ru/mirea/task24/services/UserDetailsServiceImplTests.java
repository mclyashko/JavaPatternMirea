package ru.mirea.task24.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.mirea.task24.entities.User;
import ru.mirea.task24.repositories.UserRepository;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        UserDetailsServiceImpl.class
})
public class UserDetailsServiceImplTests {

    @MockBean
    private UserRepository userRepository;

    @Test
    public void loadUserByUsername() {
        // given
        User user = getUser();
        org.springframework.security.core.userdetails.User userS =
                new org.springframework.security.core.userdetails.User(
                        user.getLogin(),
                        user.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("USER"))
                );
        Mockito.when(userRepository.findByLogin(userS.getUsername())).thenReturn(java.util.Optional.of(user));

        // when
        Optional<User> get = userRepository.findByLogin(userS.getUsername());

        // then
        Mockito.verify(userRepository, Mockito.times(1)).findByLogin(userS.getUsername());
        get.ifPresent(value -> assertThat(value).isEqualTo(user));
    }

    private User getUser() {
        User user = new User();

        user.setId(1L);
        user.setLogin("admin");
        user.setPassword("admin");

        return user;
    }
}
