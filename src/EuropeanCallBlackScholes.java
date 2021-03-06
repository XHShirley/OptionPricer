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
		System.out.println("call");
		return sNaught*StandardNormal.cumulative(d1)-strikePrice*Math.exp(riskFreeRate*(-1)*term)*StandardNormal.cumulative(d2);
	}

}
