import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListExample {
    @Test
    void listIndexOfMethod(){
        List<Character> alphabet = new ArrayList<>(List.of('A','E','I','O','U'));
        int i = alphabet.indexOf('I');
        assertEquals(i, 2);
    }
}
