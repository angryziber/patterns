package ee.agile.patterns.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaTest {
    @Test
    public void bianca() throws Exception {
        Pizza pizza = new Pizza();
        assertEquals("Bianca", pizza.getName());
        assertTrue(pizza.getToppings().isEmpty());
    }
}
