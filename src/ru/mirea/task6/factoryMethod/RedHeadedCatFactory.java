package ru.mirea.task6.factoryMethod;

public class RedHeadedCatFactory implements CatFactory{
    @Override
    public Catable makeCat() {
        return new RedHeadedCat();
    }
}
