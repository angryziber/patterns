package ee.agile.patterns.composite;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Unzipper {
    private Map<Character, String> table = new HashMap<Character, String>() {{
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
    }};

    public String unzip(Reader reader) throws IOException {
        StringBuilder buf = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            if (c == '~') substituteNextChars(buf, reader);
            else buf.append((char)c);
        }
        return buf.toString();
    }

    public String unzip(String compressed) throws IOException {
        return unzip(new StringReader(compressed));
    }

    private void substituteNextChars(StringBuilder buf, Reader reader) throws IOException {
        int c;
        while ((c = reader.read()) != -1) {
            String sub = table.get((char)c);
            if (sub == null) {
                buf.append((char)c);
                break;
            }
            buf.append(' ').append(sub);
        }
    }

    public static void main(String[] args) throws IOException {
        String text = new Unzipper().unzip(
            "Here~=%. Let~HW$UC!1O! beast, for~-=!1OaM: his~1=60&6ty-~6. (Rev.13:18-NKJV)"
        );
        System.out.println(text);
    }
}
