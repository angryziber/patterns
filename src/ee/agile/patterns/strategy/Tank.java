package ee.agile.patterns.strategy;

import static ee.agile.patterns.strategy.Tank.Strategy.*;

public class Tank implements Fighter {
    enum Strategy {
        RUN_AWAY,
        RUN_OVER_THE_TROOPER,
        ONE_TO_ONE_WITH_ANOTHER_TANK,
        RANDOM_BATTLE;

        public void doSomething() {
            // every strategy would move and shoot differently
        }
    }

    private Strategy currentStrategy = RANDOM_BATTLE;

        public void action() {
        currentStrategy.doSomething();
    }

    public void hitBy(Fighter enemy) {
        if (enemy instanceof Tank) {
            currentStrategy = ONE_TO_ONE_WITH_ANOTHER_TANK;
        }
    }
}
