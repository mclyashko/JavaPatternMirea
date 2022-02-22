package ru.mirea.task8.mediator;

public class Fox extends Communicable {

    public Fox(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println(message + ". This message is important, but 3/10. Mr Fox.");
    }
}
