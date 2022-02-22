package ru.mirea.task8.iterator;

@SuppressWarnings("ClassCanBeRecord")
public class SoupItem {
    final int id;

    public SoupItem(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "I am an item № " + id;
    }
}
