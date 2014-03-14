
/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public abstract class AlgoBinomialTree extends Algorithm {
	
	private ParaInteger numIntervals = new ParaInteger("numIntervals",0);

	public AlgoBinomialTree(Parameters paras) {
		super(paras);
		this.numIntervals = (ParaInteger)paras.getParas().get(this.numIntervals.getName());

	}

	public ParaInteger getNumIntervals() {
		return numIntervals;
	}

}
