package ru.mirea.task6.prototypeMethod;

@SuppressWarnings("ALL")
public class Dog implements Copyable {

    private String musicalGroup = "КИНО";

    public Dog() {

    }

    public Dog(String musicalGroup) {
        this.musicalGroup = musicalGroup;
    }

    public String getMusicalGroup() {
        return musicalGroup;
    }

    @Override
    public Object copy() {
        return new Dog(musicalGroup);
    }
}
