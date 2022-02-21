package ru.mirea.task4;

import java.util.concurrent.Callable;

@SuppressWarnings("ALL")
public class ExecutorTask2 implements Callable<String> {
    final String input;

    public ExecutorTask2(String input) {
        this.input = input;
    }

    @Override
    public String call() {
        return input + " " + input;
    }
}
