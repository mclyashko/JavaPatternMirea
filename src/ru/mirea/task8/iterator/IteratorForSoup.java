package ru.mirea.task8.iterator;

public interface IteratorForSoup {
    SoupItem getNext();

    boolean hasMore();

    void reset();
}
