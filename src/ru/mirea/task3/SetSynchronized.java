package ru.mirea.task3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetSynchronized<K> implements Set<K> {

    private final Set<K> mySet = new HashSet<>();

    @Override
    public int size() {
        return mySet.size();
    }

    @Override
    public boolean isEmpty() {
        return mySet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return mySet.contains(o);
    }

    @Override
    public Iterator<K> iterator() {
        return mySet.iterator();
    }

    @Override
    public Object[] toArray() {
        return mySet.toArray();
    }

    @Override
    @SuppressWarnings("all")
    public <T> T[] toArray(T[] a) {
        return mySet.toArray(a);
    }

    @Override
    public boolean add(K k) {
        return mySet.add(k);
    }

    @Override
    public boolean remove(Object o) {
        return mySet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return mySet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends K> c) {
        return mySet.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return mySet.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return mySet.removeAll(c);
    }

    @Override
    public void clear() {
        mySet.clear();
    }
}
