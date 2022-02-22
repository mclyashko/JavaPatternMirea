package ru.mirea.task6.builderPattern;

public class SkeletonBuilder implements EnemyBuilder {
    Skeleton skeleton = new Skeleton();

    @Override
    public void setHealthPoints() {
        skeleton.setHealthPoints(100);
    }

    @Override
    public void setDamage() {
        skeleton.setDamage(10);
    }

    @Override
    public void setName() {
        skeleton.setName("SANS");
    }

    @Override
    public void reset() {
        skeleton = new Skeleton();
    }

    @Override
    public Enemy getResult() {
        return skeleton;
    }

}
