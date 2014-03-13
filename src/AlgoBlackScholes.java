/**
 * 
 */

/**
 * @author Shirley Yang, Yan Liu
 *
 */
public abstract class AlgoBlackScholes extends Algorithm {
	protected double d1;
	protected double d2;
	protected double s;
	protected double k;
	protected double t;
	protected double r;
	protected double v;
	
	/**
	 * @param paras
	 */
	public AlgoBlackScholes(Parameters paras) {
		super(paras);
		// TODO Auto-generated constructor stub
	}
	

	public double calculate(){
		d1=(Math.log(s/k)+(r+Math.pow(v,2)/2)/t)/(v*Math.sqrt(t));
		d2=d1-v*Math.sqrt(t);
		return payoff();
	}
	
	public abstract double payoff();
}
