package ru.mirea.task8.mediator;

public class ZooMediator extends Mediator {

    private Fox fox;
    private Cat cat;
    private Bear bear;

    public void setFox(Fox fox) {
        this.fox = fox;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setBear(Bear bear) {
        this.bear = bear;
    }

    @Override
    public void send(String message, Communicable sender) throws Exception {
        if (fox.equals(sender)) {
            cat.notify(message);
        } else if (cat.equals(sender)) {
            bear.notify(message);
        } else if (bear.equals(sender)) {
            fox.notify(message);
        } else {
            throw new Exception("Wrong sender");
        }
    }
}
