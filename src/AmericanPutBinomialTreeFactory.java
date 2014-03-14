/**
 * 
 * @author Yan Liu
 *
 */
public class AmericanPutBinomialTreeFactory implements AlgorithmFactory {

	@Override
	public Option createOption(String string, Parameters paras) {
		Option option = new AmericanOption(string, paras);
		return option;
	}
	
	@Override
	public Algorithm createAlgorithm(Parameters paras) {
		Algorithm algorithm = new AmericanPutBinomialTree(paras);
		return algorithm;
	}
}
