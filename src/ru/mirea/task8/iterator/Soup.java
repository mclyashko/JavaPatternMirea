package ru.mirea.task8.iterator;

import java.util.ArrayList;
import java.util.List;

public class Soup implements IterableSoup {
    public final List<SoupItem> items = new ArrayList<>();

    public Soup(int amountOfItems) {
        for (int i = 0; i < amountOfItems; i++) {
            items.add(new SoupItem(i + 1));
        }
    }

    @Override
    public IteratorForSoup createIterator() {
        return new SoupIterator(this);
    }
}
