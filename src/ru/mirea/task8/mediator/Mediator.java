package ru.mirea.task8.mediator;

public abstract class Mediator {
    public abstract void send(String message, Communicable sender) throws Exception;
}
