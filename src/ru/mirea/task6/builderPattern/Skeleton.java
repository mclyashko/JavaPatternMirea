package ru.mirea.task6.builderPattern;

public class Skeleton extends Enemy { // можно работать и без extends Enemy
    @Override
    public void ultimateAbility() {
        System.out.println("*SHAKES*");
    }
}
