package ru.mirea.task6.builderPattern;

public class EnemyDirector {
    @SuppressWarnings("CanBeFinal")
    EnemyBuilder enemyBuilder;

    public EnemyDirector(EnemyBuilder enemyBuilder) {
        this.enemyBuilder = enemyBuilder;
    }

    public void buildEnemy() {
        enemyBuilder.setHealthPoints();
        enemyBuilder.setDamage();
        enemyBuilder.setName();
    }
}
