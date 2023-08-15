import org.junit.Assert;
import org.junit.Test;

public class ExampleTest {

    @Test
    public void testAddition() {
        int a = 5;
        int b = 10;
        int result = a + b;
        Assert.assertEquals("Addition result is incorrect", 15, result);
    }
}
