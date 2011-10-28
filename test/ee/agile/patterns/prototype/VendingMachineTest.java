package ee.agile.patterns.prototype;

import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {
    @Test
    public void canDispenseItems() throws Exception {
        VendingMachine machine = new VendingMachine(new SushiBox(), 25);

        ItemForSale item1 = machine.dispense();
        ItemForSale item2 = machine.dispense();

        assertEquals(23, machine.itemsLeft());
        assertNotSame(item1, item2);
    }

    @Test(expected = IllegalStateException.class)
    public void cantDispenseIfEmpty() throws Exception {
        VendingMachine machine = new VendingMachine(new PepsiBottle(), 0);
        machine.dispense();
    }
}
