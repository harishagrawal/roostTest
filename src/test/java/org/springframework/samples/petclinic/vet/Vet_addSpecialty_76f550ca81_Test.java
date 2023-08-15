import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void testAddition() {
        int a = 5;
        int b = 10;
        int result = a + b;
        Assert.assertEquals(15, result);
    }
}
