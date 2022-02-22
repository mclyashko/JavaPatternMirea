package ru.mirea.task6.abstractFactory;

public class DomesticCat implements Catable{
    @Override
    public void meow() {
        System.out.println("I am a domestic cat");
    }
}
