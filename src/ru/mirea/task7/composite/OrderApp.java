package ru.mirea.task7.composite;

import ru.mirea.task7.composite.order.Box;
import ru.mirea.task7.composite.order.goods.Longboard;
import ru.mirea.task7.composite.order.goods.MotherboardBEM1000;
import ru.mirea.task7.composite.order.goods.Phone;

import java.text.DecimalFormat;

public class OrderApp {
    public OrderApp() {
        Box box1 = new Box().addItem(
                new Phone(55000.10, "IOS")
        ).addItem(
                new MotherboardBEM1000(68500.00)
        );

        Box box2 = new Box().addItem(
                box1
        ).addItem(
                new Longboard(6499.99, 25.4)
        ).addItem(
                new Longboard(6490, 25.1)
        ); // the order

        System.out.println(new DecimalFormat("#.##").format(box2.getCost()));
    }
}
