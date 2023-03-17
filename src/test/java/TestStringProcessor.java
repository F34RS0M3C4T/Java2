import org.junit.Assert;
import org.junit.Test;

public class TestStringProcessor {

    @Test
    public void testMultiplyString() throws Exception {
        Assert.assertEquals("hellohello", StringProcessor.multiply("hello",2));
    }

    @Test
    public void testCountOfSubstrings() throws Exception {
        Assert.assertEquals(4, StringProcessor.subs("aaaa", "a"));
    }

    @Test
    public void testCharToNumber() throws Exception {
        Assert.assertEquals("onetwothree", StringProcessor.toNumbers("123"));
    }

    @Test
    public void testDelete() throws Exception {
        Assert.assertEquals("135", StringProcessor.delete(new StringBuilder("123456")));
    }
}
