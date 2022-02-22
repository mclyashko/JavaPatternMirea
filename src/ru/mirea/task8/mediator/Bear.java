package ru.mirea.task8.mediator;

public class Bear extends Communicable {

    public Bear(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println(message + ". Message received by Comrade Bear and added to the archive.");
    }
}
