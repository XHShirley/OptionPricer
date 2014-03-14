

/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public class AmericanCallBinomialTree extends AlgoBinomialTree {

	private double sNaught;
	private double strikePrice;
	private double riskFreeRate;
	private double volatility;
	private double term;
	private int numIntervals;
	double deltaT;
	double up;
	double down;
	double upProb;
	double downProb;
//	double binomValue;
	
	/**
	 * @param para
	 */
	public AmericanCallBinomialTree(Parameters paras) {
		super(paras);
		this.numIntervals = super.getNumIntervals().getValue();
		this.sNaught = ((ParaDouble)paras.getParas().get("sNaught")).getValue();
		this.strikePrice = ((ParaDouble)paras.getParas().get("strikePrice")).getValue();
		this.riskFreeRate = ((ParaDouble)paras.getParas().get("riskFreeRate")).getValue();
		this.volatility = ((ParaDouble)paras.getParas().get("volatility")).getValue();
		this.term = ((ParaDouble)paras.getParas().get("term")).getValue();		
		this.deltaT = this.term/this.numIntervals;
		
		this.up = 1.0 + this.riskFreeRate * this.deltaT + (this.volatility * Math.sqrt(this.deltaT));
		this.down = 1.0 + this.riskFreeRate * this.deltaT - (this.volatility * Math.sqrt(this.deltaT));
		this.upProb = 0.5;
		this.downProb = 0.5;
		//this.binomValue = 0.0;
	}
	
	private class Price
	{
		public double stockPrice;
		public double optionPrice;
	}


	/** Price an American or European option using a binomial tree. 
	 *@return the estimated price of the option
	 */
	private void calculate() {
		// the additional parameter here (int ao.getNumIntervals()) will be created in the GUI
		// TODO Auto-generated method stub
		int i;
		int j;
		
		// End Hrusa
		double result;
		Price[][] binomialTree;

		binomialTree = new Price[this.numIntervals+ 1][];
		for (i = 0; i <= this.numIntervals; i++)
		{
			binomialTree[i] = new Price[i + 1];
		}
		// Fill the stockPrice component of the binomialTree
		for (i = 0; i <= this.numIntervals; i++)
		{
			for (j = 0; j <= i; j++)
			{
				binomialTree[i][j] = new Price();
				binomialTree[i][j].stockPrice = this.sNaught * Math.pow(this.up, j) * Math.pow(this.down, i - j);
			}
		}
		// Fill the optionPrices at the terminal nodes
		for (j = 0; j <= this.numIntervals; j++)
		{
			binomialTree[this.numIntervals][j].optionPrice = Math.max(this.strikePrice - binomialTree[this.numIntervals][j].stockPrice, 0.0);
		}
		// Now work backwards, filling optionPrices in the rest of the tree
		double discount = Math.exp(-this.riskFreeRate * this.deltaT);
		for (i = this.numIntervals - 1; i >= 0; i--)
		{
			//method for call
			for (j = 0; j <= i; j++)
			{
					binomialTree[i][j].optionPrice = Math.max(binomialTree[i][j].stockPrice - this.strikePrice, discount * (upProb * binomialTree[i + 1][j + 1].optionPrice + downProb * binomialTree[i + 1][j].optionPrice));
			}
		}

		// Report the result, then clean up
		result = binomialTree[0][0].optionPrice;
		for (int k = 0; k <= this.numIntervals; k++)
		{
			binomialTree[k] = null;
		}
		binomialTree = null;
		this.result = result;
	}


	public double getBinomValue() {
		this.calculate();
		return binomValue;
	}
	
}
