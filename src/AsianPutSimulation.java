import java.util.Random;

/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public class AsianPutSimulation extends AlgoSimulation {

	private double sNaught;
	private double strikePrice;
	private double riskFreeRate;
	private double volatility;
	private double term;
	private int numIntervals;
	private int numTrials;
	double deltaT;
	double valueOfOption;

	/**
	 * @param paras
	 */
	public AsianPutSimulation(Parameters paras) {
		super(paras);
		this.numIntervals = super.getNumIntervals().getValue();
		this.numTrials = super.getNumTrials().getValue();
		this.sNaught = ((ParaDouble)paras.getParas().get("sNaught")).getValue();
		this.strikePrice = ((ParaDouble)paras.getParas().get("strikePrice")).getValue();
		this.riskFreeRate = ((ParaDouble)paras.getParas().get("riskFreeRate")).getValue();
		this.volatility = ((ParaDouble)paras.getParas().get("volatility")).getValue();
		this.term = ((ParaDouble)paras.getParas().get("term")).getValue();		
		this.deltaT = this.term/this.numIntervals;
		this.valueOfOption=0.0;

	}
	
	private void calculate(){

		int i, trialCount;
		double trialRunningSum, trialAverage, trialPayoff;
		double simulationRunningSum, simulationAveragePayoff;
		double s;
		Random rand = new Random();
		simulationRunningSum = 0.0;
		for (trialCount = 1; trialCount <= this.numTrials; trialCount++) {
			s = this.sNaught;
			trialRunningSum = 0.0;
			double nns = 0;
			for (i = 0; i < this.numIntervals; i++) {
				nns = rand.nextGaussian();
				s = s*Math.exp((this.riskFreeRate-this.volatility*this.volatility/2)*this.deltaT + 
					this.volatility*nns*Math.sqrt(this.deltaT));
				trialRunningSum += s;

			}
			trialAverage = trialRunningSum/this.numIntervals;
			// put option
			trialPayoff = Math.max(this.strikePrice - trialAverage,  0.0);
			simulationRunningSum += trialPayoff;			
		}
		simulationAveragePayoff = simulationRunningSum / this.numTrials;
		double result;
		result = simulationAveragePayoff * Math.exp(-this.riskFreeRate*this.term);
		this.valueOfOption = result;
	}

	public double getValueOfOption() {
		this.calculate();
		return valueOfOption;
	}
}
