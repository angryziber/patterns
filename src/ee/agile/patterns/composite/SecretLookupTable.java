package ee.agile.patterns.composite;

import java.util.HashMap;

/**
 * Patent pending :-)
 */
public class SecretLookupTable extends HashMap<Character, String> {
    {
        put('1', "number");
        put('6', "six");
        put('0', "hundred");
        put('a', "a");
        put('&', "and");
        put('-', "it");
        put('=', "is");
        put('O', "of");
        put('!', "the");
        put('$', "has");
        put('H', "him");
        put('M', "man");
        put('W', "who");
        put('%', "wisdom");
        put('U', "understanding");
        put('C', "calculate");
    }

    public boolean isMarker(int c) {
        return c == '~';
    }
}
