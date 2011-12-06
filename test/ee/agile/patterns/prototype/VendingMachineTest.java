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

    @Test
    public void exampleItemPriceIsPreserved() throws Exception {
        VendingMachine machine1 = new VendingMachine(new HintaiMagazine(650), 1);
        VendingMachine machine2 = new VendingMachine(new HintaiMagazine(699), 1);

        assertEquals(650, machine1.dispense().getPrice());
        assertEquals(699, machine2.dispense().getPrice());
    }
}
