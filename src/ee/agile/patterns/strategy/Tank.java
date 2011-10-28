package ee.agile.patterns.strategy;

public class Tank implements Fighter {
    public void action() {
        System.out.println("Doing something!");
    }

    public void hitBy(Fighter enemy) {
        System.out.println("Ouch!");
    }
}
