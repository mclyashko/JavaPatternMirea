package ru.mirea.task5;

public class Singleton3 { // no catch exceptions
    private Singleton3() {}

    private static class SingletonHolder{
        @SuppressWarnings("InstantiationOfUtilityClass")
        private final static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonHolder.instance;
    }
}
