/**
 * 
 */

/**
 * @author Shirley Yang, Yan Liu
 *
 */
public class EuropeanPutBlackScholes extends AlgoBlackScholes {

	/**
	 * @param paras
	 */
	public EuropeanPutBlackScholes(Parameters paras) {
		super(paras);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double payoff() {
		return k*Math.exp(-r*t)*StandardNormal.cumulative(-d2)-s*StandardNormal.cumulative(-d1);
	}
	
}
