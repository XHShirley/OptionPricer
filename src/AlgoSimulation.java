/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */


public abstract class AlgoSimulation extends Algorithm {
	
	private ParaInteger numIntervals = new ParaInteger("numIntervals",0);
	private ParaInteger numTrials = new ParaInteger("numTrials",0);
	private int totalPara = 2;
	
	public AlgoSimulation(Parameters paras) {
		super(paras);
		this.numIntervals = (ParaInteger)paras.getParas().get(this.numIntervals.getName());
		this.numTrials = (ParaInteger)paras.getParas().get(this.numTrials.getName());
	}

	public ParaInteger getNumIntervals() {
		return numIntervals;
	}

	public ParaInteger getNumTrials() {
		return numTrials;
	}

	public int getTotalPara() {
		return totalPara;
	}
	
	
	

}
