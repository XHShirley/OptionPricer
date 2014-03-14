/**
 * 
 */

/**
 * @author Shirley Yang, Yan Liu
 *
 */
public abstract class EuropeanPutBlackScholes extends AlgoBlackScholes {

	/**
	 * @param paras
	 */
	public EuropeanPutBlackScholes(Parameters paras) {
		super(paras);
	}

	@Override
	public double payoff() {
		return strikePrice*Math.exp(-riskFreeRate*term)*StandardNormal.cumulative(-d2)-sNaught*StandardNormal.cumulative(-d1);
	}
	
}
