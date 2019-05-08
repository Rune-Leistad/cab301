import java.util.Random;

public class MainAss2 {

    public static void main(String[] args) {
        //int[] testArray = randomGenArray(10);
        int[] testArray = {100, -36, 5, 100000, 59, 141414141, 23232};
        for(int i = 0; i<testArray.length; i++)
            System.out.println(testArray[i] + ", ");
        int res = minDistance(testArray);
        int res2 = minDistance2(testArray);

        System.out.println("Result 1: " + res + "\nResult 2: " + res2);
    }

    public static int[] randomGenArray(int arraySize) {
        Random r = new Random();
        int[] retArray = new int[arraySize];
        for(int i = 0; i < arraySize; i++)
            retArray[i] = r.nextInt();

        return retArray;
    }

    public static int minDistance(int[] a) {
        // Assigning a variable to represent the maximum distance between two values
        int dmin = Integer.MAX_VALUE; // as close to infinite as you can get using int
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                if(i != j && Math.abs(a[i] - a[j]) < dmin)
                    dmin = Math.abs(a[i] - a[j]);
            }
        }
        return dmin;
    }

    public static int minDistance2(int[] a) {
        int dmin = Integer.MAX_VALUE; // as close to infinite as you can get using int
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                int temp = Math.abs(a[i] - a[j]);
                if(temp < dmin)
                    dmin = temp;
            }
        }

        return dmin;
    }
}
