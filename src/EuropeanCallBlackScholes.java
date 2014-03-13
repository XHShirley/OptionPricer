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
		// TODO Auto-generated constructor stub
	}

	@Override
	public double payoff() {
		return s*StandardNormal.cumulative(d1)-k*Math.exp(-r*t)*StandardNormal.cumulative(d2);
	}

}
