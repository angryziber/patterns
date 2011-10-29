package ee.agile.patterns.builder;

import java.nio.DoubleBuffer;

import static ee.agile.patterns.builder.Topping.*;

public class PizzaOrder {
    private Pizza pizza = new Pizza();

    public Pizza order() {
        return pizza;
    }

    public PizzaOrder named(String name) {
        pizza.name = name;
        return this;
    }

    public PizzaOrder with(Topping topping) {
        pizza.toppings.add(topping);
        return this;
    }

    public PizzaOrder and(Topping topping) {
        return with(topping);
    }

    public PizzaOrder margherita() {
        return named("Margherita").with(SAUCE).and(CHEESE);
    }
}
