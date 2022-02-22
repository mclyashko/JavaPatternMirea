package ru.mirea.task6.factoryMethod;

public class ProletarianCatFactory implements CatFactory {
    @Override
    public Catable makeCat() {
        return new ProletarianCat();
    }
}
