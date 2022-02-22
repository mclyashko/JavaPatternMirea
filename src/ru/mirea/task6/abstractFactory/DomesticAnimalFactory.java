package ru.mirea.task6.abstractFactory;

public class DomesticAnimalFactory implements AnimalFactory {
    @Override
    public Catable makeCat() {
        return new DomesticCat();
    }

    @Override
    public Dogable makeDog() {
        return new DomesticDog();
    }
}
