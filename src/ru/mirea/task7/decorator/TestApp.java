package ru.mirea.task7.decorator;

import ru.mirea.task7.decorator.logic.DoubleText;
import ru.mirea.task7.decorator.logic.ReverseText;

public class TestApp {
    public TestApp() {
        String testString = "ABOBUS";

        String resultString1 = new ReverseText(new DoubleText()).editText(testString);
        String resultString2 = new DoubleText(new ReverseText()).editText(testString);
        String resultString3 = new ReverseText(new DoubleText(new ReverseText(new DoubleText()))).editText(testString);

        System.out.println(resultString1);
        System.out.println(resultString2);
        System.out.println(resultString3);
    }
}
