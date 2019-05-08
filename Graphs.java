import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class Graphs extends ApplicationFrame {

    public Graphs( String applicationTitle , String chartTitle , GraphData data) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                chartTitle,
                "Array size in thousands","Basic operations",
                createDataset(data),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private XYDataset createDataset(GraphData data) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries g1 = new XYSeries("Avg Basic Operations out of 100");
        XYSeries g3 = new XYSeries("(n * n)");
        XYSeries g4 = new XYSeries("Time * avg(basic operations / time)");
        //XYSeries g5 = new XYSeries("Lowest Basic Operation");
        XYSeries g6 = new XYSeries("n");
        XYSeries g7 = new XYSeries("(n*n)/2");
        int[] sizes = data.getArraySizes();
        long[] basicOp = data.getBasicOperations();
        int[] time = data.getTime();
        long sumAvg = 0;
        for(int i = 0; i < sizes.length; i += Algorithm.ITERATIONS) {
            long sum = 0;
            long st = 0;
            long max = basicOp[i];
            long min = basicOp[i];
            long sumBo = 0, sumTime = 0;
            for(int x = 0; x < Algorithm.ITERATIONS; x++) {
                sum += basicOp[i + x];
                st += time[i + x];
                if(basicOp[i+x] > max)
                    max = basicOp[i+x];
                else if(basicOp[x+i] < min)
                    min = basicOp[i+x];

                sumBo += basicOp[i+x];
                sumTime += time[i+x];
            }
            sumAvg += sumBo / sumTime;
            long nSquared = (long)sizes[i] * (long)sizes[i];
            int as = sizes[i] / 1000; // Array sizes in thousands
            g1.add(as, sum/Algorithm.ITERATIONS);
            g3.add(as, nSquared);
            g4.add(as, (st / Algorithm.ITERATIONS * 434463));
            //g5.add(as, min);
            g6.add(as, sizes[i]);
            g7.add(as, nSquared / 2);
        }

        System.out.println((sumAvg / 25));
        dataset.addSeries(g1);
        dataset.addSeries(g3);
        dataset.addSeries(g4);
       // dataset.addSeries(g5);
        dataset.addSeries(g6);
        dataset.addSeries(g7);
        return dataset;
    }
}