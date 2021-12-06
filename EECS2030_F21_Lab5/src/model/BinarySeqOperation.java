package model;

public class BinarySeqOperation extends SeqOperation {
	
	protected int[] sequence2;
	public BinarySeqOperation(int[] seq1, int[] seq2) {
		super(seq1);
		this.sequence2 = seq2;
	}
	public int[] getSequence2() {
		return sequence2;
	}
	public void setSequence2(int[] sequence2) {
		this.sequence2 = sequence2;
	}

	
}
