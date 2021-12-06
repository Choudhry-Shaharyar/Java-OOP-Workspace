package model;

public class FilterAll extends SeqEvaluator {
	private String[] concatedList;

	public FilterAll(int maxNumberOfOperations) {
		super(maxNumberOfOperations);
	}
	public void concatString() {
		String output = "";
		String[] concatedList;
		int size = 0;

		// to get size

		for(int i = 0; i < this.numberOfOperations; i++) {
			if(this.operations[i] instanceof OccursWithin) {
				size += 1;			
			} 
		}
		this.concatedList = new String[size];
		//
		for(int i = 0; i < this.numberOfOperations; i++ ) {

			if(this.operations[i] instanceof OccursWithin) {
				 output = ((OccursWithin) this.operations[i]).getResult();
				if(output.equals("occurs within")){
					this.concatedList[i] = "true";
				} else {
					this.concatedList[i] = "_";
				}

			} else {
				this.concatedList[i] = "_";
			}
		}
		this.concatedString = SequencetoString2(this.concatedList);
	}

	public String SequencetoString2(String[] concatedList) {
		String s = "";
		for(int i = 0; i < this.numberOfOperations; i++ ) {
			if(i == this.numberOfOperations-1) {
				s += this.concatedList[i];
			} else {
				s += this.concatedList[i] + ", ";
			}
		}

		return s;
	}
	public void addOperation(String operationType, int[] seq1, int[] seq2) throws IllegalOperationException  {
		if(this.numberOfOperations == maxNumberOfOperations) {
			throw new IllegalOperationException("");
		}
		if(operationType.equals("op:occursWithin")) {
			BinarySeqOperation operation = new OccursWithin(seq1, seq2);
			this.operations[this.numberOfOperations] = operation;
			this.numberOfOperations++;
		} else if(operationType.equals("op:sumsOfPrefixes") || operationType.equals("op:projection")) {
			this.numberOfIncompatibleOperations++;			
		}
		else {
			throw new IllegalOperationException("");

		}

	}

	public String toString() {
		this.concatString();

		if(this.numberOfIncompatibleOperations > 0) {
			return String.format("Filter cannot be evaluated due to %s incompatile operations.", this.numberOfIncompatibleOperations);
		} else {
			return String.format("Filter result is: %s", this.getConcatString());
			//		"Concat([1, 3, 1, 5, 3], [0, 1, 4, 9], []) = [1, 3, 1, 5, 3, 0, 1, 4, 9]"
		}



	}
}
