package ee.agile.patterns.builder;

import static ee.agile.patterns.builder.Style.*;
import static ee.agile.patterns.builder.Topping.*;
import static java.util.Arrays.asList;

public class PizzaBuilder {
    private Pizza pizza = new Pizza();

    public PizzaBuilder named(String name) {
        pizza.name = name;
        return this;
    }

    public PizzaBuilder small() {
        pizza.diameter = 18;
        return this;
    }

    public PizzaBuilder partySize() {
        pizza.diameter = 50;
        return this;
    }

    public PizzaBuilder with(Topping ... topping) {
        pizza.toppings.addAll(asList(topping));
        return this;
    }

    public Pizza build() {
        return pizza;
    }

    public PizzaBuilder margherita() {
        return named("Margherita").with(SAUCE, CHEESE);
    }

    public PizzaBuilder americana() {
        return margherita().named("Americana").with(PINEAPPLE, HAM, ONIONS);
    }
}
