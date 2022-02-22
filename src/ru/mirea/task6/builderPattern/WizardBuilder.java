package ru.mirea.task6.builderPattern;

public class WizardBuilder implements EnemyBuilder {
    Wizard wizard = new Wizard();

    @Override
    public void setHealthPoints() {
        wizard.setHealthPoints(10);
    }

    @Override
    public void setDamage() {
        wizard.setDamage(100);
    }

    @Override
    public void setName() {
        wizard.setName("Arch Wizard of the Crimson Magic Clan");
    }

    @Override
    public void reset() {
        wizard = new Wizard();
    }

    @Override
    public Enemy getResult() {
        return wizard;
    }

}
