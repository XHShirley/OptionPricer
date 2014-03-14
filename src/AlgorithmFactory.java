/**
 * 
 * @author Yan Liu
 *
 */
public abstract class AlgorithmFactory {
	
	private Option op;
	private Algorithm algo;
	private double result;
	
	protected abstract Option createOption(String string, Parameters paras);
	
	protected abstract Algorithm createAlgorithm(Parameters paras);

	public double calculate(String string, Parameters paras){
		
		op = this.createOption(string, paras);
		algo = this.createAlgorithm(paras);
		this.result = algo.getResult();
		return this.result;
		
	}
	
}
