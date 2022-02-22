package ru.mirea.task7;

import ru.mirea.task7.composite.OrderApp;
import ru.mirea.task7.decorator.TestApp;

public class Main {
    public static void main(String[] args) {
        new OrderApp();

        System.out.println("-----------------------------------------------------------------------------------------");

        new TestApp();
    }
}
