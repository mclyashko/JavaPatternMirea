package ru.mirea.task6.builderPattern;

public class WizardBuilder implements EnemyBuilder {
    Wizard wizard = new Wizard();

    @SuppressWarnings("unused")
    @Override
    public void setHealthPoints() {
        wizard.setHealthPoints(10);
    }

    @SuppressWarnings("unused")
    @Override
    public void setDamage() {
        wizard.setDamage(100);
    }

    @SuppressWarnings("unused")
    @Override
    public void setName() {
        wizard.setName("Arch Wizard of the Crimson Magic Clan");
    }

    @SuppressWarnings("unused")
    @Override
    public void reset() {
        wizard = new Wizard();
    }

    @SuppressWarnings("unused")
    @Override
    public Enemy getResult() {
        return wizard;
    }

}
