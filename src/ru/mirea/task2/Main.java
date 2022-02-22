package ru.mirea.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Human> myList = new ArrayList<>();
        myList.add(
                new Human(
                        18, "Виктор", "Ляшенко",
                        LocalDate.of(2003, 5, 2), 80
                )
        );
        myList.add(
                new Human(
                        100, "Дмитрий", "Вальков",
                        LocalDate.of(3002, 5, 2), 993
                )
        );
        myList.add(
                new Human(
                        19, "Павел", "Журавлев",
                        LocalDate.of(993, 1, 1), 1
                )
        );
        myList.add(
                new Human(
                        28, "Павел", "Соломатин",
                        LocalDate.of(123, 12, 3), 13
                )
        );
        myList.add(
                new Human(
                        28, "Иван", "Иванов",
                        LocalDate.of(11, 11, 11), 11
                )
        );

        Stream<Human> stream1 = myList.stream();

        stream1.sorted(Comparator.comparingInt(Human::getWeight).reversed())
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        Stream<Human> stream2 = myList.stream();

        stream2.filter(o1 -> !o1.getLastName().equals("Иванов"))
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        Stream<Human> stream3 = myList.stream();

        stream3.sorted(Comparator.comparingInt(Human::getAge))
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        Stream<Human> stream4 = myList.stream();

        System.out.println(Objects.requireNonNull(
                stream4.reduce((o1, o2) -> new Human(o1.getAge() * o2.getAge()))
                        .orElse(null)).getAge()
        );
    }
}
