package ru.mirea.task3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetSynchronized<K> implements Set<K> {

    private final Set<K> mySet = new HashSet<>();

    @Override
    synchronized public int size() {
        return mySet.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return mySet.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return mySet.contains(o);
    }

    @Override
    synchronized public Iterator<K> iterator() {
        return mySet.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return mySet.toArray();
    }

    @Override
    @SuppressWarnings("all")
    synchronized public <T> T[] toArray(T[] a) {
        return mySet.toArray(a);
    }

    @Override
    synchronized public boolean add(K k) {
        return mySet.add(k);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return mySet.remove(o);
    }

    @Override
    synchronized public boolean containsAll(Collection<?> c) {
        return mySet.containsAll(c);
    }

    @Override
    synchronized public boolean addAll(Collection<? extends K> c) {
        return mySet.addAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return mySet.retainAll(c);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return mySet.removeAll(c);
    }

    @Override
    synchronized public void clear() {
        mySet.clear();
    }
}
