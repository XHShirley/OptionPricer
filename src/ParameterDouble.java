
public class ParameterDouble extends Parameter{
	
	private double value;

	public ParameterDouble(String parameterName) {
		super(parameterName);
	}
	
	
	
	public void check(String valueString) throws Exception{
		
		try {
            Double.parseDouble(valueString); 
        }
        catch(NumberFormatException e){
            throw new Exception("Double Number");
        }	 
        this.setValue(Double.parseDouble(valueString));
		
	}



	public double getValue() {
		return value;
	}



	public void setValue(double value) {
		this.value = value;
	}

}
