public class GraphData {
    private int[] arraySizes, time;
    private long[] basicOperations;

    public GraphData(int[] as, long[] bo, int[] time) {
        this.arraySizes = as;
        this.basicOperations = bo;
        this.time = time;
    }

    public int[] getArraySizes() {
        return arraySizes;
    }

    public long[] getBasicOperations() {
        return basicOperations;
    }

    public int[] getTime() {
        return time;
    }


}
