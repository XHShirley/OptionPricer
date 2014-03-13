/**
 * 
 * @author Yan Liu
 *
 */
public interface AlgorithmFactory {
	public Option createOption(String string, Parameters paras);
	public Algorithm createAlgorithm(Parameters paras);
	
}
