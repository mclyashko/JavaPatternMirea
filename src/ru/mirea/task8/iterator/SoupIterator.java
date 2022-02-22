package ru.mirea.task8.iterator;

public final class SoupIterator implements IteratorForSoup {

    private final Soup collection;
    private int iterationState;

    public SoupIterator(Soup collection) {
        this.collection = collection;
        this.iterationState = collection.items.size() - 1;
    }

    @Override
    public SoupItem getNext() {
        if (!hasMore()) {
            return null;
        } else {
            var item = collection.items.get(iterationState);
            iterationState -= 1;
            return item;
        }
    }

    @Override
    public boolean hasMore() {
        return (iterationState >= 0);
    }

    @Override
    public void reset() {
        this.iterationState = collection.items.size() - 1;
    }
}
