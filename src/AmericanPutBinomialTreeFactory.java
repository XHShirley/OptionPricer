/**
 * 
 * @author Yan Liu
 *
 */
public class AmericanPutBinomialTreeFactory extends AlgorithmFactory {

//	AmericanOption ao;
//	AmericanPutBinomialTree apb;
	
	public Option createOption(String string, Parameters paras) {
		AmericanOption option = new AmericanOption(string, paras);
		return option;
	}
	
	public Algorithm createAlgorithm(Parameters paras) {
		AmericanPutBinomialTree algorithm = new AmericanPutBinomialTree(paras);
		return algorithm;
	}
}
