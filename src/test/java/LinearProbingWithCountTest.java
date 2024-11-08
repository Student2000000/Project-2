import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinearProbingWithCountTest {

    private LinearProbingWithCount<String, String> dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new LinearProbingWithCount<>();
    }

    @Test
    void add() {
        assertThrows(IllegalArgumentException.class, () -> {
            dictionary.add("key1", null);
        });

        Integer result = dictionary.add("key1", 100);
        assertNull(result, "Old value needs to be null");
        assertEquals(100, dictionary.getValue("key1"));

        for (int i = 0; i < 100; i++) {
            dictionary.add("key" + i, "i");
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(i, dictionary.getValue("key" + i));
        }
    }

    @Test
    void remove() {
    }

    @Test
    void getValue() {
    }

    @Test
    void contains() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void getSize() {
    }

    @Test
    void clear() {
    }

    @Test
    void getKeyIterator() {
    }

    @Test
    void getValueIterator() {
    }

    @Test
    void search() {
    }

    @Test
    void linearProbe() {
    }
}