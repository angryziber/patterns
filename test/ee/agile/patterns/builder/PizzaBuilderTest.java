package ee.agile.patterns.builder;

import org.junit.Test;

import java.util.EnumSet;

import static ee.agile.patterns.builder.Topping.*;
import static org.junit.Assert.assertEquals;

public class PizzaBuilderTest {
    @Test
    public void margherita() throws Exception {
        Pizza pizza = new PizzaBuilder().small().named("Margherita").with(SAUCE).with(CHEESE).build();
        assertEquals("Margherita", pizza.getName());
        assertEquals(EnumSet.of(SAUCE, CHEESE), pizza.getToppings());
        assertEquals(18, pizza.getDiameter());
    }

    @Test
    public void recipes() throws Exception {
        Pizza pizza = new PizzaBuilder().americana().build();
        assertEquals("Americana", pizza.getName());
        assertEquals(EnumSet.of(SAUCE, CHEESE, PINEAPPLE, HAM, ONIONS), pizza.getToppings());
    }
}
