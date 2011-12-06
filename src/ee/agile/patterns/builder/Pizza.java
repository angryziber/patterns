package ee.agile.patterns.builder;

import java.util.EnumSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public class Pizza {
    String name = "Bianca";
    int diameter = 18;
    Style style = Style.THIN_CRUST;
    Set<Topping> toppings = EnumSet.noneOf(Topping.class);
    boolean isDoubleCheese;

    Pizza() {
    }

    public String getName() {
        return name;
    }

    public int getDiameter() {
        return diameter;
    }

    public Style getStyle() {
        return style;
    }

    public Set<Topping> getToppings() {
        return unmodifiableSet(toppings);
    }

    @Override
    public String toString() {
        return "Pizza " + name + ", " + diameter + "cm, " +
                style + " with " + toppings;
    }
}
