package ee.agile.patterns.decorator;

public interface Map {
    char get(int x, int y);
    String line(int y);

    int width();
    int height();
}
