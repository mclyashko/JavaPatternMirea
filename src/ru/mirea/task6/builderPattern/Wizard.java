package ru.mirea.task6.builderPattern;

public class Wizard extends Enemy { // можно работать и без extends Enemy
    @Override
    public void ultimateAbility() {
        System.out.println("Let the hammer of eternity descend unto me!\n" +
                "Explosion!"
        );
    }
}
