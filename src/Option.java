import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public abstract class Option extends Product {
	
	// Basic values of a stock option; A client can change 
	// these by using the "set" methods declared below
	private ParaDouble sNaught = new ParaDouble("sNaught",0);
	private ParaDouble strikePrice = new ParaDouble("strikePrice",0);
	private ParaDouble riskFreeRate = new ParaDouble("riskFreeRate",0);
	private ParaDouble volatility = new ParaDouble("volatility",0);
	private ParaDouble term = new ParaDouble("term",0);
	private int totalPara = 5;

	//para are just number having already matched.
	public Option(String name, Parameters paras) {
		
		super(name);
		this.sNaught= (ParaDouble)paras.getParas().get(this.sNaught.getName());
		this.strikePrice= (ParaDouble)paras.getParas().get(this.strikePrice.getName());
		this.riskFreeRate= (ParaDouble)paras.getParas().get(this.riskFreeRate.getName());
		this.volatility= (ParaDouble)paras.getParas().get(this.volatility.getName());
		this.term= (ParaDouble)paras.getParas().get(this.term.getName());	
		
	}

	public ParaDouble getsNaught() {
		return sNaught;
	}

	public ParaDouble getStrikePrice() {
		return strikePrice;
	}

	public ParaDouble getRiskFreeRate() {
		return riskFreeRate;
	}

	public ParaDouble getVolatility() {
		return volatility;
	}

	public ParaDouble getTerm() {
		return term;
	}

	public int getTotalPara() {
		return totalPara;
	}
	
	

}
