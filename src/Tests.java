import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class Tests {
        @Test
        void TotalTest() {
            double subTot = 164.99;
            double shipping = 57;
            double expectedTotal = subTot + shipping;
            Program p = new Program();
            assertEquals(expectedTotal, p.GetTotal(subTot, shipping));
        }
}
