import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MainAss2 {
    static long bo1Counter = 0, bo2Counter = 0;

    public static void main(String[] args) {

        try {
            // Setting up the output files for Levetin's algorithm and the alternative respectively
            File output1 = new File("Results_algo_1.txt");
            File output2 = new File("Results_algo_2.txt");
            // If file does not exist, create it
            if (!output1.exists())
                output1.createNewFile();
            if(!output2.exists())
                output2.createNewFile();
            writeToFile(output1, "Array size,Basic operations,Time");
            writeToFile(output2, "Array size,Basic operations,Time");

            // Setting variables for increased readability of the code
            int avgIter = 100; // Used for array size < 5000 (1000 to 4000)
            int incrementSize = 1000; // Size of each increment.
            int iterationSize = 10; // Number of iterations over each array size
            int maxArraySize = 20000; // Biggest array size to run the test on

            // Increased iterations for array sizes less than 5000
            for(int i = 1000; i < 5000; i+=incrementSize) {
                // Creating 100 pseudo random arrays of size i.
                // Preventing time being spent during the algorithm to creating the arrays.
                long[][] arrayList = new long[avgIter][i];
                for(int j = 0; j < avgIter; j++)
                    arrayList[j] = randomGenArray(i);

                bo1Counter = 0;
                long avgTime1 = System.currentTimeMillis();
                for(int j = 0; j < avgIter; j++)
                    minDistance(arrayList[j]);
                avgTime1 = System.currentTimeMillis() - avgTime1;

                bo2Counter = 0;
                long avgTime2 = System.currentTimeMillis();
                for(int j = 0; j < 100; j++)
                    minDistance2(arrayList[j]);
                avgTime2 = System.currentTimeMillis() - avgTime2;

                writeToFile(output1, String.format("%d,%d,%d", i, bo1Counter/avgIter, avgTime1/avgIter));
                writeToFile(output2, String.format("%d,%d,%d", i, bo2Counter/avgIter, avgTime2/avgIter));
            }

            // i = array size. Increments by 1000 each time
            for(int i = 5000; i < maxArraySize; i+=incrementSize) {
                for (int j = 0; j < iterationSize; j++) {
                    // Generating the pseudo random array for testing the algorithm
                    long[] testArray = randomGenArray(i);

                    // Levetin's algorithm
                    bo1Counter = 0;
                    long time1 = System.currentTimeMillis(); // Starting time
                    long res1 = minDistance(testArray);
                    time1 = System.currentTimeMillis() - time1; // Stopping time
                    writeToFile(output1, String.format("%d,%d,%d", i, bo1Counter, time1));

                    // The faster alternative to Levetin's algorithm
                    bo2Counter = 0;
                    long time2 = System.currentTimeMillis(); // Starting the time
                    long res2 = minDistance2(testArray);
                    time2 = System.currentTimeMillis() - time2; // Stopping time
                    writeToFile(output2, String.format("%d,%d,%d", i, bo2Counter, time2));
                }
            }
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    /**
     * This function creates an array of integers with values ranging from Integer.MAX_VALUE to Integer_MIN_VALUE.
     * The length of the array is given as an argument
     * @param arraySize The size of the array.
     * @return Returns an array of pseudo random integers
     */
    public static long[] randomGenArray(int arraySize) {
        Random r = new Random();
        long[] retArray = new long[arraySize];
        for(int i = 0; i < arraySize; i++)
            retArray[i] = r.nextInt();

        return retArray;
    }

    /**
     * A function to find the shortest distance between two data points in an array.
     * @param a An array of data points.
     * @return Returns the absolute distance between the two closest data points
     */
    public static long minDistance(long[] a) {
        // Assigning a variable to represent the maximum distance between two values.
        // This has to be a long variable because we are operating in the outer bounds of integer. in the case of
        // Math.abs(Integer.MIN_VALUE - 1) we'd en up exceeding the limit of int.
        long dmin = Integer.MAX_VALUE; // as close to infinite as you can get using int
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                bo1Counter++;
                if(i != j && Math.abs(a[i] - a[j]) < dmin)
                    dmin = Math.abs(a[i] - a[j]);
            }
        }
        return dmin;
    }

    /**
     * A function to find the shortest distance between two data points in an array.
     * This function does not check the distance between points we've already calculated
     * @param a An array of data points.
     * @return Returns the absolute distance between the two closest data points
     */
    public static long minDistance2(long[] a) {
        long dmin = Integer.MAX_VALUE; // as close to infinite as you can get using int
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                long temp = Math.abs(a[i] - a[j]);
                bo2Counter++;
                if(temp < dmin)
                    dmin = temp;
            }
        }

        return dmin;
    }

    /**
     * A file that adds text to any given text file. This function appends the given text at the end of the
     * file. It doesn't overwrite the current content
     * @param f File to write to
     * @param add Text to add to the file
     * @throws IOException
     */
    public static void writeToFile(File f, String add) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
        bw.write(add);
        bw.newLine();
        bw.close();
    }
}
