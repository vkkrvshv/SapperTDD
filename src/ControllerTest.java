import org.junit.Assert;
import org.junit.Test;

public class ControllerTest {
    Model model;

    @Test
    public void testConstructor(){
        Controller controller = new Controller(model);
        Assert.assertNotNull(controller);
    }


}
