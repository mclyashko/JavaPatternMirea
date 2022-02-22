package ru.mirea.task8;

import ru.mirea.task8.iterator.Soup;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
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
    }
}
