package ee.agile.patterns.builder;

import org.junit.Test;

import java.util.EnumSet;

import static ee.agile.patterns.builder.Topping.*;
import static org.junit.Assert.*;

public class PizzaTest {
    @Test
    public void bianca() throws Exception {
        Pizza pizza = new PizzaOrder().order();
        assertEquals("Bianca", pizza.getName());
        assertTrue(pizza.getToppings().isEmpty());
    }

    @Test
    public void customMargherita() throws Exception {
        Pizza pizza = new PizzaOrder().named("Margherita").
                        with(SAUCE).with(CHEESE).order();

        assertEquals("Margherita", pizza.getName());
        assertEquals(EnumSet.of(SAUCE, CHEESE), pizza.getToppings());
    }

    @Test
    public void preDefinedMargherita() throws Exception {
        Pizza pizza = new PizzaOrder().margerita().order();

        assertEquals("Margherita", pizza.getName());
        assertEquals(EnumSet.of(SAUCE, CHEESE), pizza.getToppings());

    }
}
