package ru.mirea.task6.builderPattern;

public class SkeletonBuilder implements EnemyBuilder {
    Skeleton skeleton = new Skeleton();

    @SuppressWarnings("unused")
    @Override
    public void setHealthPoints() {
        skeleton.setHealthPoints(100);
    }

    @SuppressWarnings("unused")
    @Override
    public void setDamage() {
        skeleton.setDamage(10);
    }

    @SuppressWarnings("unused")
    @Override
    public void setName() {
        skeleton.setName("SANS");
    }

    @SuppressWarnings("unused")
    @Override
    public void reset() {
        skeleton = new Skeleton();
    }

    @SuppressWarnings("unused")
    @Override
    public Enemy getResult() {
        return skeleton;
    }

}
