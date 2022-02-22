package ru.mirea.task6.abstractFactory;

public class StrayDog implements Dogable{
    @Override
    public void bark() {
        System.out.println("I am a stray dog");
    }
}
