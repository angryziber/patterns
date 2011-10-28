package ee.agile.patterns.strategy;

public interface Fighter {
    void action();
    void hitBy(Fighter enemy);
}
