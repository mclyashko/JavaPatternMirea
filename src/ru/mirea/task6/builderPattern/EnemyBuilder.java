package ru.mirea.task6.builderPattern;

@SuppressWarnings("unused")
public interface EnemyBuilder {
    void setHealthPoints();

    void setDamage();

    void setName();

    void reset();

    Enemy getResult();
}
