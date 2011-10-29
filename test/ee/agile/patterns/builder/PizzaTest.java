package ee.agile.patterns.builder;

import org.junit.Test;

import java.util.EnumSet;

import static ee.agile.patterns.builder.Topping.*;
import static org.junit.Assert.*;

public class PizzaTest {
    @Test
    public void bianca() throws Exception {
        Pizza pizza = new Pizza();
        assertEquals("Bianca", pizza.getName());
        assertTrue(pizza.getToppings().isEmpty());
    }

    @Test
    public void margherita() throws Exception {
        Pizza pizza =
                new PizzaOrder().named("Margherita").
                    with(SAUCE).and(CHEESE).order();
        assertEquals("Margherita", pizza.getName());
        assertEquals(EnumSet.of(SAUCE, CHEESE), pizza.getToppings());
    }

    @Test
    public void recipes() throws Exception {
        Pizza pizza = new PizzaOrder().margherita().with(SHRIMPS).order();
        assertEquals("Margherita", pizza.getName());
        assertEquals(EnumSet.of(SAUCE, CHEESE, SHRIMPS), pizza.getToppings());
    }
}
