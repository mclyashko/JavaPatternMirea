package ru.mirea.task7.decorator.logic;

public class ReverseText extends Wrapper {
    public ReverseText() {

    }

    public ReverseText(Wrapper preprocessor) {
        super(preprocessor);
    }

    @Override
    public String editText(String someText) {
        String preprocessedText = super.editText(someText);

        return new StringBuilder(preprocessedText).reverse().toString();
    }
}
