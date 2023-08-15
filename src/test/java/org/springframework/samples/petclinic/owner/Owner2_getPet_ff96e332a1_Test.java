import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    @Test
    public void testAddition() {
        int a = 5;
        int b = 10;
        int expected = 15;
        int actual = a + b;
        assertEquals(expected, actual, "5 + 10 should equal 15");
    }
}
