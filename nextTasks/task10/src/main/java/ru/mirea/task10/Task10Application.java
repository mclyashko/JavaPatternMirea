package ru.mirea.task10;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mirea.task10.configuration.ProgrammerConfiguration;
import ru.mirea.task10.interfaces.Programmer;

import java.util.ArrayList;
import java.util.Arrays;

// Вариант 18 -> 3
// 3) Интерфейс Programmer с методом doCoding(), его имплементации: Junior, Middle, Senior.

@SpringBootApplication
public class Task10Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProgrammerConfiguration.class);

        ArrayList<String> beanNames = new ArrayList<>(Arrays.asList("Junior", "Middle", "Senior"));

        for (var i :
                beanNames) {
            Programmer someProgrammer = (Programmer) applicationContext.getBean(i);

			someProgrammer.doCoding();
        }
    }

}
