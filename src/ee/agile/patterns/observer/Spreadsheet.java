package ee.agile.patterns.observer;

import static java.lang.Integer.parseInt;

public class Spreadsheet {
    private int[][] data = new int[100][26];

    public void set(String cell, int value) {
        data[y(cell)][x(cell)] = value;
    }

    public int get(String cell) {
        return data[y(cell)][x(cell)];
    }

    private int x(String cell) {
        return cell.charAt(0) - 'A';
    }

    private int y(String cell) {
        return parseInt(cell.substring(1));
    }
}
