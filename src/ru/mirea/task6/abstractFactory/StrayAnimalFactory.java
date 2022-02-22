package ru.mirea.task6.abstractFactory;

public class StrayAnimalFactory implements AnimalFactory {
    @Override
    public Catable makeCat() {
        return new StrayCat();
    }

    @Override
    public Dogable makeDog() {
        return new StrayDog();
    }
}
