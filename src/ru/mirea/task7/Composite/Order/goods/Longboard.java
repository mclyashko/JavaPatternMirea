package ru.mirea.task7.Composite.Order.goods;

public class Longboard implements Costable {
    private final double cost;
    private final double width; // например, 25.4 cm

    public Longboard(double cost, double width) {
        this.cost = cost;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
