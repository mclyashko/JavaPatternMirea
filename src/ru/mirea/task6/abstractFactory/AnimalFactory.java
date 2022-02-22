package ru.mirea.task6.abstractFactory;

public interface AnimalFactory {
    Catable makeCat();

    Dogable makeDog();
}
