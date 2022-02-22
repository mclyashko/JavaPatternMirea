package ru.mirea.task7.composite.order;

import ru.mirea.task7.composite.order.goods.Costable;

import java.util.ArrayList;
import java.util.List;

public class Box implements Costable {
    List<Costable> insideTheBox = new ArrayList<>();

    public Box() {

    }

    @SuppressWarnings("unused")
    public Box(List<Costable> insideTheBox) {
        this.insideTheBox = insideTheBox;
    }

    public Box addItem(Costable item) {
        insideTheBox.add(item);
        return this;
    }

    @Override
    public double getCost() {
        double cost = 0;

        for (var i :
                insideTheBox) {
            cost += i.getCost();
        }

        return cost;
    }
}
