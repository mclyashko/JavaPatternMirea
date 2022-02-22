package ru.mirea.task6.abstractFactory;

public class TheWorldApp {
    public final AnimalFactory animalFactory;

    public TheWorldApp(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;

        animalFactory.makeCat().meow();
        animalFactory.makeDog().bark();

//        AnimalFactory domesticAnimalFactory = new DomesticAnimalFactory();
//        AnimalFactory strayAnimalFactory = new StrayAnimalFactory();
    }
}
