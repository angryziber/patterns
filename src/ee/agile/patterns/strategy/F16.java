package ee.agile.patterns.strategy;

public class F16 implements Fighter {
    public void action() {
        System.out.println("Find and kill everyone!");
    }

    public void hitBy(Fighter enemy) {
        System.out.println("Die!");
    }
}
