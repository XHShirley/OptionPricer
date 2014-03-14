/**
 * 
 * @author Yan Liu
 *
 */
public class AmericanCallBinomialTreeFactory extends AlgorithmFactory {

	public Option createOption(String string, Parameters paras) {
		AmericanOption option = new AmericanOption(string, paras);
		return option;
	}
	
	public Algorithm createAlgorithm(Parameters paras) {
		AmericanCallBinomialTree algorithm = new AmericanCallBinomialTree(paras);
		return algorithm;
	}
}
