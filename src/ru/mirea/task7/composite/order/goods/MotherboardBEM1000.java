package ru.mirea.task7.composite.order.goods;

@SuppressWarnings("ALL")
public class MotherboardBEM1000 implements Costable {
    private final double cost;
    private final String developer = "ЭЛПИТЕХ";

    public MotherboardBEM1000(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
