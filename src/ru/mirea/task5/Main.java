package ru.mirea.task5;

public class Main {
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton11 = Singleton1.getInstance();

        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton21 = Singleton2.getInstance();

        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton31 = Singleton3.getInstance();

        if (!(singleton1 == singleton11 && singleton2 == singleton21 && singleton3 == singleton31)) {
            System.out.println("Not Singleton");
        }
    }
}
