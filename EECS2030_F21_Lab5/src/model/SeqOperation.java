package model;

public class SeqOperation {
	protected int[] sequence1;
	
	public SeqOperation(int[] seq1) {
		this.sequence1 = seq1;
	}

	public int[] getSequence1() {
		return sequence1;
	}

	public void setSequence1(int[] sequence1) {
		this.sequence1 = sequence1;
	}
	
	public String SequencetoString(int[] seq) {
		String output = "";
		
		
		for(int i = 0; i < seq.length; i++) {
			if(seq.length == 1) {
				output  = "[" + seq[i] + "]";
				continue;
			}
			else if(i == 0) {
				output  = "[" + seq[i];
			} 
			else if(i == (seq.length -1)){
				output += ", " + seq[i] +"]";
				continue;
			
			} else {
				output += ", " + seq[i];
			}
			
			
		}
		if(seq.length == 0) {
			output = "[]";
		}
		return output;
		
	}
	
	
}
