package model;

public class SeqEvaluator {
	protected SeqOperation[] operations;
	protected int maxNumberOfOperations;
	protected int numberOfOperations;
	protected String concatedString;
	protected int position;
	protected int numberOfIncompatibleOperations;
	
	public SeqEvaluator(int maxNumberOfOperations)  {
		this.maxNumberOfOperations = maxNumberOfOperations;
		this.operations = new SeqOperation[maxNumberOfOperations];
		this.numberOfOperations = 0;
		this.concatedString = "";
		this.numberOfIncompatibleOperations = 0;
	//	this.resultsOfSequence = new int[maxNumberOfOperations];
	}

	public void addOperation(String operationType, int[] seq1, int[] seq2) throws IllegalOperationException  {
		if(this.numberOfOperations == maxNumberOfOperations) {
			throw new IllegalOperationException("");
		}
		if(operationType.equals("op:projection")) {
			BinarySeqOperation operation = new Projection(seq1, seq2);
			this.operations[this.numberOfOperations] = operation;
		   
		//	this.concatString(((Projection)this.operations[this.numberOfOperations]).getProjectedSequence());
			this.numberOfOperations++;
		} else if(operationType.equals("op:sumsOfPrefixes")) {
			SeqOperation operation = new SumsOfPrefixes(seq1);
			this.operations[this.numberOfOperations] = operation;
			
		//	this.concatString(((SumsOfPrefixes)this.operations[this.numberOfOperations]).getPrefixSum());
			this.numberOfOperations++;
		} 
		 else if(operationType.equals("op:occursWithin")){
			 this.numberOfIncompatibleOperations++;			
		} else {
			throw new IllegalOperationException("");
		}
		
	}
	//		"op:sumsOfPrefixes", seq1, null);


	
	public String getConcatString() {
		return this.concatedString;
	}
	
	public String SequencetoString2(int[] seq) {
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

	public String getListOfResults() {
		String s = "";
		for(int i = 0; i < this.numberOfOperations; i++) {
			if(this.operations[i] instanceof Projection) {
				if(i ==this.numberOfOperations-1) {
					s = s + ((Projection)this.operations[i]).SequencetoString(((Projection)this.operations[i]).getProjectedSequence());
				} else {
					s = s + ((Projection)this.operations[i]).SequencetoString(((Projection)this.operations[i]).getProjectedSequence()) +", ";
				}
			} else {
				if(i ==this.numberOfOperations-1) {
					s = s + ((SumsOfPrefixes)this.operations[i]).SequencetoString(((SumsOfPrefixes)this.operations[i]).getPrefixSum());
				} else {
					s = s + ((SumsOfPrefixes)this.operations[i]).SequencetoString(((SumsOfPrefixes)this.operations[i]).getPrefixSum()) +", ";

				}
			}
		}
		return s;
	}


	



}
