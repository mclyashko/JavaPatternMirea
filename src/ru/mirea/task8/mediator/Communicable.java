package ru.mirea.task8.mediator;

@SuppressWarnings("unused")
public abstract class Communicable {
    protected final Mediator mediator;

    public Communicable(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) throws Exception {
        mediator.send(message, this);
    }

    public abstract void notify(String message);
}
