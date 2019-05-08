import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    public void testMinDistance() {
        int[] array = {0, 500, 1000, -501, 10};
        int expected = 10;
        assertEquals(expected, MainAss2.minDistance(array));
        assertEquals(expected, MainAss2.minDistance2(array));

        int[] array2 = {0, -1, -2, -3, 1, 2, 3, 4};
        expected = 1;
        assertEquals(expected, MainAss2.minDistance(array2));
        assertEquals(expected, MainAss2.minDistance2(array2));

        int[] array3 = {0, 0, 0, 1, 2, 3, 4};
        expected = 0;
        assertEquals(expected, MainAss2.minDistance(array3));
        assertEquals(expected, MainAss2.minDistance2(array3));

    }
}
