/**
 * 
 * @author Yan Liu
 *
 */
public abstract class AlgorithmFactory {
	
	private Option op;
	private Algorithm algo;
	private double result;
	private double[][] vols;
	
	protected abstract Option createOption(String string, Parameters paras);
	
	protected abstract Algorithm createAlgorithm(Parameters paras);

	public double calculate(String string, Parameters paras){
		
		op = this.createOption(string, paras);
		algo = this.createAlgorithm(paras);
		this.result = algo.getResult();
		return this.result;
		
	}
	
	public double[][] getVolatilities(String string, Parameters paras){
		
		op = this.createOption(string, paras);
		algo = this.createAlgorithm(paras);
		this.vols = algo.getVolatilities();
		return this.vols;
		
	}
	
}
