package ee.agile.patterns.strategy;

import java.awt.*;

public class Missle implements Fighter {
    private Point target;

    public Missle(Point target) {
        this.target = target;
    }

    public void action() {
        System.out.println("Fly to " + target);
    }

    public void hitBy(Fighter enemy) {
        throw new IllegalArgumentException("Can't catch me!");
    }
}
