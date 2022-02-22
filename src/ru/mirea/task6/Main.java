package ru.mirea.task6;

import ru.mirea.task6.abstractFactory.DomesticAnimalFactory;
import ru.mirea.task6.abstractFactory.StrayAnimalFactory;
import ru.mirea.task6.abstractFactory.TheWorldApp;
import ru.mirea.task6.builderPattern.*;
import ru.mirea.task6.factoryMethod.BadCatFactory;
import ru.mirea.task6.factoryMethod.CatFactory;
import ru.mirea.task6.factoryMethod.ProletarianCatFactory;
import ru.mirea.task6.factoryMethod.RedHeadedCatFactory;
import ru.mirea.task6.prototypeMethod.Cat;
import ru.mirea.task6.prototypeMethod.Dog;

public class Main {
    public static void main(String[] args) {
        CatFactory badCatFactory = new BadCatFactory();
        CatFactory proletarianCatFactory = new ProletarianCatFactory();
        CatFactory redHeadedCatFactory = new RedHeadedCatFactory();

        badCatFactory.goMeow();
        proletarianCatFactory.goMeow();
        redHeadedCatFactory.goMeow();

        System.out.println("-----------------------------------------------------------------------------------------");

        new TheWorldApp(new DomesticAnimalFactory()); // if на выбор фабрики, затем используем только один объект
        new TheWorldApp(new StrayAnimalFactory()); // TheWorldApp с требуемым типом фабрики
        // в отличие от "фабричного метода", в "абстрактной фабрике" каждая фабрика может создавать
        // несколько типов объектов одновременно

        System.out.println("-----------------------------------------------------------------------------------------");

        EnemyBuilder wizardBuilder = new WizardBuilder();
        EnemyBuilder skeletonBuilder = new SkeletonBuilder();

        EnemyDirector wizardDirector = new EnemyDirector(wizardBuilder);
        EnemyDirector skeletonDirector = new EnemyDirector(skeletonBuilder);

        wizardDirector.buildEnemy();
        skeletonDirector.buildEnemy();

        Enemy wizard = wizardBuilder.getResult();
        Enemy skeleton = skeletonBuilder.getResult();

        wizard.ultimateAbility();
        skeleton.ultimateAbility();

        System.out.println("-----------------------------------------------------------------------------------------");

        Cat cat = new Cat();
        Dog dog = new Dog("DIO");

        System.out.println(cat.getVerse());
        System.out.println(dog.getMusicalGroup());

        Cat catCopy = (Cat) cat.copy();
        Dog dogCopy = (Dog) dog.copy();

        System.out.println(catCopy.getVerse());
        System.out.println(dogCopy.getMusicalGroup());

        if (cat == catCopy || dog == dogCopy) {// сравнение ссылок
            System.out.println("Something went wrong");
        } else {
            System.out.println("It's ok");
        }
    }
}
