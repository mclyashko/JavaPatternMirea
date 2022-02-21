package ru.mirea.task4;

import java.util.concurrent.Callable;

@SuppressWarnings("ClassCanBeRecord")
public class ExecutorTask1 implements Callable<String> {
    final String input;

    public ExecutorTask1(String input) {
        this.input = input;
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder(input);
        builder.reverse();
        return builder.toString();
    }
}
