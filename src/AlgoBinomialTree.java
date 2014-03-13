
/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public class AlgoBinomialTree extends Algorithm {
	
	private ParaInteger numIntervals = new ParaInteger("numIntervals",0);
	private ParaDouble priceIntervals = new ParaDouble("priceIntervals",0.0);

	public AlgoBinomialTree(Parameters paras) {
		super(paras);
		this.numIntervals = (ParaInteger)paras.getParas().get(this.numIntervals.getName());
		this.priceIntervals = (ParaDouble)paras.getParas().get(this.priceIntervals.getName());

	}

	public ParaInteger getNumIntervals() {
		return numIntervals;
	}

	public ParaDouble getPriceIntervals() {
		return priceIntervals;
	}

}
