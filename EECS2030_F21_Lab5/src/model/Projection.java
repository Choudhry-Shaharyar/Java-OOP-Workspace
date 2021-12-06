package model;


public class Projection extends BinarySeqOperation {
	
	private int[] projectedSequence;
	private int size;

	public Projection(int[] seq1, int[] seq2) {
		super(seq1, seq2);
		this.applyProjection(seq1, seq2);
		this.size = 0;
	}
	
	public void applyProjection(int[] seq1, int[] seq2) {
		int numberOfMatches = 0;
		int[] projectedSequence;
		
		for(int i = 0; i < seq2.length; i++) {
			for(int j = 0; j <  seq1.length; j++) {
				if(seq2[i] == seq1[j]) {
					numberOfMatches += 1;
					j = seq1.length + 1;
				}
			}
		}
		this.size = numberOfMatches;
		this.projectedSequence = new int[this.size];
		
		for(int i = 0, size = 0; i < seq2.length; i++) {
			for(int j = 0; j <  seq1.length; j++) {
				if(seq2[i] == seq1[j]) {
					this.projectedSequence[size] = seq2[i];
					size++;
					j = seq1.length + 1;

				}
			}
		}
	}

	public int[] getProjectedSequence() {

		return projectedSequence;
		
	}
	
	public String toString() {
		return String.format("Projecting %s to %s results in: %s", this.SequencetoString(sequence1), this.SequencetoString(sequence2),this.SequencetoString(projectedSequence));
	}
	//assertEquals("Projecting [1, 3, 5] to [2, 1, 6, 3, 1, 4, 5, 3] results in: [1, 3, 1, 5, 3]", op.toString());

}
