/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public class ParaInteger extends Parameter {

	int value;
	
	
	/**
	 * @param name
	 */
	public ParaInteger(String name, int value) {
		super(name);
		this.value = value;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}
	

}
