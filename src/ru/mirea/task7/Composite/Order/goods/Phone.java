package ru.mirea.task7.Composite.Order.goods;

public class Phone implements Costable {
    private final double cost;
    private final String OS;

    public Phone(double cost, String OS) {
        this.cost = cost;
        this.OS = OS;
    }

    public String getOS() {
        return OS;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
