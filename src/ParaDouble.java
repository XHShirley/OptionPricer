/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public class ParaDouble extends Parameter {
	
	double value;
	
	public ParaDouble(String name, double value) {
		super(name);
		this.value = value;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


//	/**
//	 * @param sNaught
//	 * @param strikePrice
//	 * @param riskFreeRate
//	 * @param volatility
//	 * @param term
//	 */
//	public Double(double sNaught, double strikePrice, double riskFreeRate,
//			double volatility, double term) {
//		super(sNaught, strikePrice, riskFreeRate, volatility, term);
//		// TODO Auto-generated constructor stub
//	}

}
