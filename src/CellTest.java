import org.junit.Assert;
import org.junit.Test;

public class CellTest {
    @Test
    public void testConstructor(){
        Cell cell = new Cell(1,1);
        Assert.assertNotNull(cell);
    }
}
