package ru.mirea.task6.factoryMethod;

public class BadCatFactory implements CatFactory{
    @Override
    public Catable makeCat() {
        return new BadCat();
    }

}
