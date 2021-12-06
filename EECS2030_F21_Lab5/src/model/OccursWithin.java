package model;

public class OccursWithin extends BinarySeqOperation {

	private String result;
	public OccursWithin(int[] seq1, int[] seq2) {
		super(seq1, seq2);
		this.result = "";
		this.applyOccursWithin(seq1, seq2);
		// this.applyOccursWithin(sequence1, sequence2);

	}
	private void applyOccursWithin(int[] seq1, int[] seq2) {
		//		* 	1) An empty seq1 [] occurs within any seq2 (either empty or non-empty).
		//	 * 	2) A non-empty seq1 does not occur within an empty seq2 []. 
		//	 * 	3) A sequence does not occur within another shorter sequence.  
		int count = 0;
		boolean b = true;
		if(seq1.length == 0) {
			this.result = "occurs within";
		} else if (seq1.length > 0 && (seq1.length > seq2.length || seq2.length == 0)) {
			this.result = "does not occur within";
		} else {
			
			int expectedMatches = seq1.length;
			int actualMatches = 0;
			for(int i = 0, j = 0; j < seq2.length; j++) {
				if(seq1[i] == seq2[j]) {
					i++;
					actualMatches += 1;
					if(actualMatches == expectedMatches) {
						j = seq2.length;
					}
				} else if(actualMatches > 0 && (seq1[i] != seq2[j])){
					actualMatches = 0;
					i = 0;
				}
				else {
					actualMatches = 0;
					
				}
			}

			if(actualMatches == expectedMatches ) {
				this.result = "occurs within";
			} else {
				this.result = "does not occur within";
			}

		}
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String toString() {
		return String.format("%s %s %s", this.SequencetoString(sequence1), this.getResult(),  this.SequencetoString(sequence2));
	}
}
