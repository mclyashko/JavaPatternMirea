package ru.mirea.task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapLock<K, V> implements Map<K, V> {

    private final Map<K, V> myMap = new HashMap<>();

    private static final Lock lock = new ReentrantLock();

    @Override
    public int size() {
        lock.lock();
        var size = myMap.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        var isEmpty = myMap.isEmpty();
        lock.unlock();
        return isEmpty;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        var containsKey = myMap.containsKey(key);
        lock.unlock();
        return containsKey;
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        var containsValue = myMap.containsValue(value);
        lock.unlock();
        return containsValue;
    }

    @Override
    public V get(Object key) {
        lock.lock();
        var get = myMap.get(key);
        lock.unlock();
        return get;
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        var put = myMap.put(key, value);
        lock.unlock();
        return put;
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        var remove = myMap.remove(key);
        lock.unlock();
        return remove;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        lock.lock();
        myMap.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        myMap.clear();
        lock.unlock();
    }

    @Override
    public Set<K> keySet() {
        lock.lock();
        var keySet = myMap.keySet();
        lock.unlock();
        return keySet;
    }

    @Override
    public Collection<V> values() {
        lock.lock();
        var values = myMap.values();
        lock.unlock();
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        lock.lock();
        var entrySet = myMap.entrySet();
        lock.unlock();
        return entrySet;
    }
}
