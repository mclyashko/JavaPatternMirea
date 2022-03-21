package ru.mirea.task10.components;

import ru.mirea.task10.interfaces.Programmer;

public class Middle implements Programmer {

    @Override
    public void doCoding() {
        System.out.println("Do code: System.out.println(\"HI!\");");
    }
}
