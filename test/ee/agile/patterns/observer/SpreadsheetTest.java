package ee.agile.patterns.observer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpreadsheetTest {
    private Spreadsheet spreadsheet = new Spreadsheet();

    @Test
    public void persistenceOfValues() throws Exception {
        assertEquals(0, spreadsheet.get("A1"));

        spreadsheet.set("A1", 13);
        spreadsheet.set("Z99", 42);

        assertEquals(13, spreadsheet.get("A1"));
        assertEquals(42, spreadsheet.get("Z99"));
    }
}
