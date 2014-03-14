/**
 * 
 * @author Yan Liu
 *
 */
public class EuropeanCallBlackScholesFactory extends AlgorithmFactory {

	@Override
	public Option createOption(String string, Parameters paras) {
		Option option = new EuropeanOption(string, paras);
		return option;
	}
	
	@Override
	public Algorithm createAlgorithm(Parameters paras) {
		Algorithm algorithm = new EuropeanCallBlackScholes(paras);
		return algorithm;
	}
}
