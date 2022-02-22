package ru.mirea.task8;

import ru.mirea.task8.iterator.Soup;
import ru.mirea.task8.mediator.Bear;
import ru.mirea.task8.mediator.Cat;
import ru.mirea.task8.mediator.Fox;
import ru.mirea.task8.mediator.ZooMediator;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws Exception {
        Soup soup = new Soup(10);

        var soupIterator = soup.createIterator();

        while (soupIterator.hasMore()) {
            System.out.println(soupIterator.getNext());
        }

        System.out.println(soupIterator.hasMore());
        System.out.println(soupIterator.getNext());

        soupIterator.reset();

        while (soupIterator.hasMore()) {
            System.out.println(soupIterator.getNext());
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        ZooMediator zooMediator = new ZooMediator();

        Fox fox = new Fox(zooMediator);
        Cat cat = new Cat(zooMediator);
        Bear bear = new Bear(zooMediator);

        zooMediator.setFox(fox);
        zooMediator.setCat(cat);
        zooMediator.setBear(bear);

        fox.send("Is Java good?");
        cat.send("ABOBA");
        bear.send("I'm writing a program about the three of us");
    }
}
