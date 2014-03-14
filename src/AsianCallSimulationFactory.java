/**
 * 
 * @author Yan Liu
 *
 */
public class AsianCallSimulationFactory extends AlgorithmFactory {

	public Option createOption(String string, Parameters paras) {
		Option option = new AsianOption(string, paras);
		return option;
	}
	
	public Algorithm createAlgorithm(Parameters paras) {
		Algorithm algorithm = new AsianCallSimulation(paras);
		return algorithm;
	}
}
