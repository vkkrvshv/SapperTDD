import org.junit.Assert;
import org.junit.Test;

public class ViewTest {
    Model model;

    @Test
    public void testConstructor(){
        View view = new View(model);
        Assert.assertNotNull(view);
    }

    @Test
    public void testGameOver(){
        View view = new View(model);
        view.gameOver();
        Assert.assertEquals("Игра окончена", view.getTitle());
    }

    @Test
    public void testStartGame(){
        View view = new View(model);
        view.startGame();
        Assert.assertEquals("Игра идёт", view.getTitle());
    }

    @Test
    public void testWin(){
        View view = new View(model);
        view.win();
        Assert.assertEquals("Победа!", view.getTitle());
    }
}
