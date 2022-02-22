package ru.mirea.task7.decorator.logic;

public abstract class Wrapper {
    private Wrapper preprocessor;

    public Wrapper() {

    }

    public Wrapper(Wrapper preprocessor) {
        this.preprocessor = preprocessor;
    }

    public String editText(String someText) {
        if (!(preprocessor == null)) {
            someText = preprocessor.editText(someText);
        }

        return someText;
    }
}
