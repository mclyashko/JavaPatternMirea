package ru.mirea.task5;

public class Singleton1 { // not thread-safe
    private static Singleton1 instance;

    private Singleton1() {
    } // private

    @SuppressWarnings("InstantiationOfUtilityClass")
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
