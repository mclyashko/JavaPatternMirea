package ru.mirea.task7.composite.order.goods;

@SuppressWarnings("ALL")
public class Phone implements Costable {
    private final double cost;
    private final String OS;

    public Phone(double cost, String OS) {
        this.cost = cost;
        this.OS = OS;
    }

    @SuppressWarnings("unused")
    public String getOS() {
        return OS;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
