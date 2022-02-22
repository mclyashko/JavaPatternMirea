package ru.mirea.task8.mediator;

public class Cat extends Communicable {

    public Cat(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println(message + ". Monsieur Cat is here. Hello. Hello? Hello! IS ANYONE HERE?");
    }
}
