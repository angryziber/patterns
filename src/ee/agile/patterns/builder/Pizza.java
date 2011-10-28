package ee.agile.patterns.builder;

import java.util.Set;

public class Pizza {
    private String name;
    private int diameter;
    private Style style;
    private Set<Topping> toppings;

    @Override
    public String toString() {
        return "Pizza " + name + ", " + diameter + "cm, " +
                style + " with " + toppings;
    }
}
