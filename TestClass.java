import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    public void testMinDistance() {
        long[] array = {10, 4, 8, 1, 2};
        int expected = 1;
        assertEquals(expected, MainAss2.minDistance(array));
        assertEquals(expected, MainAss2.minDistance2(array));

        long[] array1 = {0, 500, 1000, -501, 10};
        expected = 10;
        assertEquals(expected, MainAss2.minDistance(array1));
        assertEquals(expected, MainAss2.minDistance2(array1));

        long[] array2 = {0, -1, -2, -3, 1, 2, 3};
        expected = 1;
        assertEquals(expected, MainAss2.minDistance(array2));
        assertEquals(expected, MainAss2.minDistance2(array2));

        long[] array3 = {10, 0, 3, 1, 0, 6, 0};
        expected = 0;
        assertEquals(expected, MainAss2.minDistance(array3));
        assertEquals(expected, MainAss2.minDistance2(array3));
    }
}
