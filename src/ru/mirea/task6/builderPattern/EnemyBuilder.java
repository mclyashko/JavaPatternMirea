package ru.mirea.task6.builderPattern;

public interface EnemyBuilder {
    void setHealthPoints();

    void setDamage();

    void setName();

    void reset();

    Enemy getResult();
}
