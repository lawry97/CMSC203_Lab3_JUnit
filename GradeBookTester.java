import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GradeBookTester {
    private GradeBook book; 
    private GradeBook book2;
    private GradeBook book3;
    @Before
    public void setUp() throws Exception {
        book = new GradeBook(5);
        book2 = new GradeBook(5);
        book3 = new GradeBook(5);

        book.addScore(87.5);
        book.addScore(90.3);
        book.addScore(40.0);

        book2.addScore(90);
        book2.addScore(95.7);

        book3.addScore(70);
        book3.addScore(90);
        book3.addScore(98.5);
        book3.addScore(89.5);
    }

    @After
    public void tearDown() throws Exception {
        book = null;
        book2 = null;
        book3 = null;
    }

    @Test
    public void addScore() {

        assertEquals("87.5 90.3 40.0 0.0 0.0 ", book.toString());

        assertEquals("90.0 95.7 0.0 0.0 0.0 ", book2.toString());

        assertEquals("70.0 90.05 98.5 89.5 0.0 ", book3.toString());
    }

    @Test
    public void sum() {
        assertEquals((87.5 + 90.3 + 40), book.sum(), 0.001);
        assertEquals((90 + 95.7), book2.sum(),0.001);
        assertEquals((70 + 90 + 98.5 + 89.5), book3.sum(),0.001);
    }

    @Test
    public void minimum() {

        assertEquals(40.0, book.minimum(), 0.001);
        assertEquals(90, book2.minimum(),0.001);
        assertEquals(70, book3.minimum(), 0.001);
    }

    @Test
    public void finalScore() {

        assertEquals(((87.5 + 90.3 + 40.0)-40.0), book.finalScore(), 0.001);
        assertEquals(((90.0 + 95.7)-90.0), book2.finalScore(), 0.001);
        assertEquals(((70.0 + 90.0 + 98.5 + 89.5)-70.0), book3.finalScore(), 0.001);
    }

}