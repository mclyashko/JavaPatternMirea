package ru.mirea.task1;

import java.util.function.Function;

public class Coder implements Function<String[], String[]> {

    @Override
    public String[] apply(String[] strings) {
        String[] newArray = new String[strings.length];

        for(int i = 0; i < strings.length; i++) {
            newArray[strings.length - i - 1] = new StringBuilder(strings[i]).reverse().toString();
        }

        return (String[]) newArray;
    }
}
