package ru.mirea.task3;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> myMap = new MapLock<>();

        List<String> firstListKeys = new ArrayList<>(Arrays.asList("ABOBA", "SUS", "lorem", "some", "word", "k6", "k7", "k7", "qwe", "k7")); // k7 - v10 -> k10 - v10
        List<String> firstListValues = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "vVv", "VvV", "VVV", "value3", "v10"));

        List<String> secondListKeys = new ArrayList<>(Arrays.asList("k1", "k2", "k3", "k4", "k5", "k6", "k7", "k8", "k9", "k10")); // k7 -> v7
        List<String> secondListValues = new ArrayList<>(Arrays.asList("v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10"));

        int n = 10; // firstListKeys, firstListValues, secondListKeys, secondListValues size
        int m = 10; // firstListKeys, firstListValues, secondListKeys, secondListValues size

        Thread one = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                myMap.put(firstListKeys.get(i), firstListValues.get(i));
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < m; i++) {
                myMap.put(secondListKeys.get(i), secondListValues.get(i));
            }
        });

        one.start();
        two.start();

        Thread.sleep(1000); // главный поток "спит" секунду - ждем завершения двух других потоков
        // альтернатива - join()

        myMap.forEach((key, value) -> System.out.println(key + ":" + value));

        System.out.println("-----------------------------------------------------------------------------------------");

        Set<String> mySet = new SetSynchronized<>();

        int k = 10; // firstListKeys, firstListValues, secondListKeys, secondListValues size
        int l = 10; // firstListKeys, firstListValues, secondListKeys, secondListValues size

        one = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                mySet.add(firstListKeys.get(i));
            }
        });

        two = new Thread(() -> {
            for (int i = 0; i < m; i++) {
                mySet.add(firstListValues.get(i));
            }
        });

        Thread three = new Thread(() -> {
            for (int i = 0; i < k; i++) {
                mySet.add(secondListKeys.get(i));
            }
        });

        Thread four = new Thread(() -> {
            for (int i = 0; i < l; i++) {
                mySet.add(secondListValues.get(i));
            }
        });

        one.start();
        two.start();
        three.start();
        four.start();

        Thread.sleep(1000); // главный поток "спит" секунду - ждем завершения четырех других потоков
        // альтернатива - join()

        mySet.forEach(System.out::println);
    }
}
