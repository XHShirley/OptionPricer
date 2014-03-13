/**
 * 
 * @author Yan Liu
 *
 */
public class AsianCallSimulationFactory implements AlgorithmFactory {

	@Override
	public Option createOption(String string, Parameters paras) {
		Option option = new AsianOption(string, paras);
		return option;
	}
	
	@Override
	public Algorithm createAlgorithm(Parameters paras) {
		Algorithm algorithm = new AsianCallSimulation(paras);
		return algorithm;
	}
}
