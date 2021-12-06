package model;

public class SumsOfPrefixes extends SeqOperation {
	private int[] prefixSum;
	
	public SumsOfPrefixes(int[] seq) {
		super(seq);
		this.prefixSum = new int[seq.length + 1];
		this.findPrefixSum(seq);
	}
	
	private void findPrefixSum(int[] seq) {
		
		this.prefixSum[0] = 0;
		for(int i = 1; i < this.prefixSum.length; i++) {
			this.prefixSum[i] = this.prefixSum[i - 1] + this.sequence1[i-1];
		}
		
	}
	

	public int[] getPrefixSum() {
		return prefixSum;
	}

	public void setPrefixSum(int[] prefixSum) {
		this.prefixSum = prefixSum;
	}

	public String toString() {
		return String.format("Sums of prefixes of %s is: %s", this.SequencetoString(sequence1), this.SequencetoString(prefixSum));
	}


}
