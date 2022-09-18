import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;

public class Graph {
    public void showGraph() {
        XYSeries function = new XYSeries("function");
        XYSeries spline = new XYSeries("spline");
        for (int i = 0; i < 10; i++){
            function.add(FirstLab.setX_I(i), FirstLab.function(i));
            spline.add(FirstLab.setX_I(i), FirstLab.spline(i));
        }
        XYSeriesCollection d = new XYSeriesCollection();
        d.addSeries(spline);
        d.addSeries(function);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = 2 * sin(x)", "x", "y",
                        d);
        JFrame frame =
                new JFrame("Graph");
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        frame.show();
    }
}

