/**
 * 
 */

/**
 * @author Shirley Yang, Yan Liu
 *
 */
public class EuropeanCallBlackScholes extends AlgoBlackScholes {

	/**
	 * @param paras
	 */
	public EuropeanCallBlackScholes(Parameters paras) {
		super(paras);
	}

	@Override
	public double payoff() {
		return sNaught*StandardNormal.cumulative(d1)-strikePrice*Math.exp(-riskFreeRate*term)*StandardNormal.cumulative(d2);
	}

}
