 
import java.util.*; 

interface BigPrimes {
	public String[] getPrimes();
}


public class BigPrimesFactory implements BigPrimes  {
	
	private String[] bp;
	Random random;
	public BigPrimesFactory() {
		bp = new String[]{"37975227936943673922808872755445627854565536638199", "40094690950920881030683735292761468389214899724061", "6122421090493547576937037317561418841225758554253106999", "5846418214406154678836553182979162384198610505601062333"};
		random  = new Random();
	}
	public String[] getPrimes() {
		int index1 = random.nextInt(bp.length);
		int index2 = index1;
		while(index2== index1) {
			index2 = random.nextInt(bp.length);
		}
		return new String[] {bp[index1], bp[index2]};
	}
}
