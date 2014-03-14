import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public class Parameters {
	
	HashMap<String,Parameter> paras;

	/**
	 * 
	 */
	public Parameters(ArrayList<Parameter> para) {
		
		int length = para.size();
		paras = new HashMap<String,Parameter>(length);
		for(int i=0;i<length; i++){
			this.paras.put(para.get(i).getName(), para.get(i));
		}
	}

	public HashMap<String, Parameter> getParas() {
		return paras;
	}

}
