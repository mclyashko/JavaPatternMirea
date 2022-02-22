package ru.mirea.task5;

@SuppressWarnings("FieldMayBeFinal")
public class Singleton2 { // no lazy init, no catching exceptions
    @SuppressWarnings({"InstantiationOfUtilityClass", "CanBeFinal"})
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
