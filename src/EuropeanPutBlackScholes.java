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
		System.out.println("put");
		return strikePrice*Math.exp(riskFreeRate*(-1)*term)*StandardNormal.cumulative(d2*(-1))-sNaught*StandardNormal.cumulative(d1*(-1));
	}
	
}
