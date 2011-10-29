package ee.agile.patterns.observer;

import java.util.Observable;
import java.util.Observer;

import static java.lang.Integer.parseInt;

public class Spreadsheet extends Observable {
    private int[][] data = new int[100][26];

    public void set(String cell, int value) {
        data[y(cell)][x(cell)] = value;
        setChanged();
        notifyObservers();
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
