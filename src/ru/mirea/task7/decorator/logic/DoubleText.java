package ru.mirea.task7.decorator.logic;

public class DoubleText extends Wrapper {
    public DoubleText() {
    }

    public DoubleText(Wrapper preprocessor) {
        super(preprocessor);
    }

    @Override
    public String editText(String someText) {
        String preprocessedText = super.editText(someText);

        return preprocessedText + preprocessedText;
    }
}
