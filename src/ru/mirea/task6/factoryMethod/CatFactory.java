package ru.mirea.task6.factoryMethod;

public interface CatFactory {
    Catable makeCat();

    default void goMeow() { // логика над генерируемыми объектами
        Catable cat = makeCat();
        cat.meow();
    }
}
