
/**
 * @author Shirley Yang, Yan Liu
 *
 */
public abstract class AlgoBlackScholes extends Algorithm {
	protected double d1;
	protected double d2;
	protected double sNaught;
	protected double strikePrice;
	protected double term;
	protected double riskFreeRate;
	protected double volatility;
	
	/**
	 * @param paras
	 */
	public AlgoBlackScholes(Parameters paras) {
		super(paras);
		this.sNaught = ((ParaDouble)paras.getParas().get("sNaught")).getValue();
		this.strikePrice = ((ParaDouble)paras.getParas().get("strikePrice")).getValue();
		this.riskFreeRate = ((ParaDouble)paras.getParas().get("riskFreeRate")).getValue();
		this.volatility = ((ParaDouble)paras.getParas().get("volatility")).getValue();
		this.term = ((ParaDouble)paras.getParas().get("term")).getValue();		
	}
	

	public void calculate(double v){
		d1=(Math.log(sNaught/strikePrice)+(riskFreeRate+Math.pow(v,2)/2)/term)/(v*Math.sqrt(term));
		d2=d1-v*Math.sqrt(term);
		result = payoff();
	}
	
	public double getResult(){
		this.calculate(volatility);
		return this.result;
	}
	
	public abstract double payoff();
}
