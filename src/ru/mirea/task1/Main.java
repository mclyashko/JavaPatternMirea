package ru.mirea.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Coder myCoder = new Coder();

        String[] testArray = {"ABOBA", "BOBA", "ME"};

        System.out.println(Arrays.toString(myCoder.apply(testArray)));
    }
}
