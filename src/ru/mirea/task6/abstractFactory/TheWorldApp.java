package ru.mirea.task6.abstractFactory;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
public class TheWorldApp {
    public final AnimalFactory animalFactory;

    public TheWorldApp(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;

        animalFactory.makeCat().meow();
        animalFactory.makeDog().bark();

    }
}
