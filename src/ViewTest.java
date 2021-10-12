import org.junit.Assert;
import org.junit.Test;

public class ViewTest {
    Model model;

    @Test
    public void testConstructor(){
        View view = new View(model);
        Assert.assertNotNull(view);
    }
}
