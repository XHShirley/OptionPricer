/**
 * 
 */

/**
 * @version 1.0
 * @author Shirley Yang
 *1/3/2014
 */
public class Product {
	
	private String name;
	Parameter paraOfP;
	
	public Product(String name){
		this.name = name;
		this.paraOfP = new Parameter();
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

}
