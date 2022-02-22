package ru.mirea.task6.abstractFactory;

public class DomesticDog implements Dogable {
    @Override
    public void bark() {
        System.out.println("I am a domestic dog");
    }
}
