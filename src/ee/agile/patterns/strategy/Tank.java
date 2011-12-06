package ee.agile.patterns.strategy;

import static ee.agile.patterns.strategy.Tank.Strategy.*;

public class Tank implements Fighter {
    private int health = 100;

    enum Strategy {
        AGAINST_PLANE,
        AGAINST_MOLOTOV,
        KAMIKAZE,
        SEEK_AND_DESTROY,
        RUN;

        public void action() {};
    }

    private Strategy strategy = SEEK_AND_DESTROY;

    public void action() {
        strategy.action();
        // turnBy(10);
    }

    public void scanned(Fighter enemy, int x, int y) {
        // strategy =
    }

    public void hitBy(Fighter enemy) {
        if (enemy instanceof F16)
            strategy = AGAINST_PLANE;

        else if (health < 10)
            strategy = RUN;
    }
}
