import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    public void testMinDistance() {
        int[] array = {0, 500, 1000, -501, 10};
        assertEquals(MainAss2.minDistance(array), 10);
        assertEquals(MainAss2.minDistance2(array), 10);

        int[] array2 = {0, -1, -2, -3, 1, 2, 3, 4};
        assertEquals(MainAss2.minDistance(array2), 1);
        assertEquals(MainAss2.minDistance2(array2), 1);

        int[] array3 = {0, 0, 0, 1, 2, 3, 4};
        assertEquals(MainAss2.minDistance(array3), 0);
        assertEquals(MainAss2.minDistance2(array3), 0);

    }
}
