package ru.mirea.task6.factoryMethod;

public class BadCat implements Catable{
    @Override
    public void meow() {
        System.out.println("Bark");
    }
}
