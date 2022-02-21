package ru.mirea.task6;

import ru.mirea.task6.factoryMethod.*;

public class Main {
    public static void main(String[] args) {
        CatFactory badCatFactory = new BadCatFactory();
        CatFactory proletarianCatFactory = new ProletarianCatFactory();
        CatFactory redHeadedCatFactory = new RedHeadedCatFactory();

        badCatFactory.goMeow();
        proletarianCatFactory.goMeow();
        redHeadedCatFactory.goMeow();
    }
}
