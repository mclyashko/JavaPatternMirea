package ru.mirea.task4;

import java.util.concurrent.Future;

public class Main {
    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {
        MyExecutorService executorService = new MyExecutorService(3);

        Future<String> task1 = executorService.submit(new ExecutorTask1("AMOGUS"));
        Future<String> task2 = executorService.submit(new ExecutorTask2("AMOGUS"));
        Future<String> task3 = executorService.submit(new ExecutorTask2("GOOSE"));

        while (!(task1.isDone() && task2.isDone() && task3.isDone())) {
            Thread.sleep(1); // sleep 1 ms -> busy CPU
        }

        // пробуем получить результаты выполнения задач
        try {
            System.out.println("task1: " + task1.get());
            System.out.println("task2: " + task2.get());
            System.out.println("task3: " + task3.get());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        executorService.shutdown();
    }
}
