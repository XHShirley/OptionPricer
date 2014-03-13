
public class ParameterInteger extends Parameter {

	private int value;

	public ParameterInteger(String parameterName) {
		super(parameterName);
	}
		
	
	public void check(String valueString) throws Exception{
		
		try {
            Integer.parseInt(valueString); 
        }
        catch(NumberFormatException e){
            throw new Exception("Integer Number");
        }	 
        this.setValue(Integer.parseInt(valueString));
		
	}



	public double getValue() {
		return value;
	}



	public void setValue(int value) {
		this.value = value;
	}


}
