package ru.mirea.task10.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea.task10.components.Junior;
import ru.mirea.task10.components.Middle;
import ru.mirea.task10.components.Senior;
import ru.mirea.task10.interfaces.Programmer;

// Spring @Configuration annotation is part of the spring core framework.
// Spring Configuration annotation indicates that the class has @Bean definition methods.
// Класс с аннотацией @Configuration говорит о том, что он является источником определения бинов
@Configuration
public class ProgrammerConfiguration {

    // Чтобы создать Bean, необходимо добавить аннотацию Bean к методам,
    // которые возвращают объекты классов соответствующего типа.
    // Такие методы находятся в классе с аннотацией Configuration

    @Bean("Junior")
    public Programmer junior() {
        return new Junior();
    }

    @Bean("Middle")
    public Programmer middle() {
        return new Middle();
    }

    @Bean("Senior")
    public Programmer senior() {
        return new Senior();
    }
}
