package ee.agile.patterns.decorator;

public abstract class AsciiMap implements Map {
    private String[] data;

    public AsciiMap(String[] data) {
        this.data = data;
    }

    public String line(int y) {
        return data[y];
    }

    public char get(int x, int y) {
        return line(y).charAt(x);
    }

    public int width() {
        return data[0].length();
    }

    public int height() {
        return data.length;
    }
}
