package view;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class Statistique extends JFrame{
    
  
/**
* The starting point for the demo.
*
* @param args ignored.
* 
*/
public Statistique(){    // create a dataset...
setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

DefaultPieDataset dataset = new DefaultPieDataset();
dataset.setValue("Cours Magistral", 53.3);
dataset.setValue("TP", 12.7);
dataset.setValue("TD", 32);
// create a chart...
JFreeChart chart = ChartFactory.createPieChart(
"Ratio des Cours Promo 2022",
dataset,
true, // legend?
true, // tooltips?
false // URLs?
);
// create and display a frame...
ChartFrame frame = new ChartFrame("First", chart);
frame.pack();
frame.setVisible(true);
}
}
