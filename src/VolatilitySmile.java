import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 
 * @author Yiming
 *
 */

@SuppressWarnings("serial")
public class VolatilitySmile extends ApplicationFrame {
	
	
	public VolatilitySmile(String title, double[][] volatilities) {
		super(title);
		final XYDataset dataset = createDataset(volatilities);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        setContentPane(chartPanel);
		// TODO Auto-generated constructor stub
	}
	
	public void displayChart(){
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}
	
	private XYDataset createDataset(double[][] volatilities){
		final XYSeries series = new XYSeries("Volatility Smile");
		for (int i=0; i<volatilities.length; i++){
			series.add(volatilities[i][0], volatilities[i][1]);
			
		}
		final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
		return dataset;
		
	}
	
	private JFreeChart createChart(final XYDataset dataset){
		
		final JFreeChart chart = ChartFactory.createXYLineChart(
	            "Volatility Smile",      
	            "Volatility",                      
	            "Option Price",                      
	            dataset,                  
	            PlotOrientation.VERTICAL,
	            true,                     
	            true,                     
	            false                    
	        );
		
		chart.setBackgroundPaint(Color.white);
		final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return chart;
		
	}
	
}

