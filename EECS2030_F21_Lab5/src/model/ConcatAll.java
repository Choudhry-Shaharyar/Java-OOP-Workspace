package model;

public class ConcatAll extends SeqEvaluator {

	public ConcatAll(int maxNumberOfOperations) {
		super(maxNumberOfOperations);
	}

	public void concatString() {
		int[] concatedList;
		int size = 0;

		// to get size
		for(int i = 0; i < this.numberOfOperations; i++) {
			if(this.operations[i] instanceof Projection) {
				size += ((Projection)this.operations[i]).getProjectedSequence().length;
			} else {
				size += ((SumsOfPrefixes)this.operations[i]).getPrefixSum().length;
			}
		}
		concatedList = new int[size];
		//
		for(int i = 0, count = 0; i < this.numberOfOperations; i++ ) {
			if(this.operations[i] instanceof Projection) {
				int length = ((Projection)this.operations[i]).getProjectedSequence().length;
				for(int j = 0; j < length; j++) {
					concatedList[count] =  ((Projection)this.operations[i]).getProjectedSequence()[j];
					count++;
				}
			}
			else {
				int length = ((SumsOfPrefixes)this.operations[i]).getPrefixSum().length;
				for(int j = 0; j < length; j++) {
					concatedList[count] =  ((SumsOfPrefixes)this.operations[i]).getPrefixSum()[j];
					count++;
				}
			}

		}


		this.concatedString = SequencetoString2(concatedList);


		//		for(int i = 0; i < seq.length; i++) {
		//			if(seq.length == 0) {
		//				i = seq.length+1;
		//			}
		//			if(seq.length-1 == i) {
		//				output +=  seq[i];				
		//			} else {
		//				output +=  seq[i] + ", ";
		//			}			
		//	}
		//		this.concatedString += output;

	}
	public String toString() {
		this.concatString();

		if(this.numberOfIncompatibleOperations > 0) {
			return String.format("Concat cannot be evaluated due to %s incompatile operations.", this.numberOfIncompatibleOperations);
		} else {
			return String.format("Concat(%s) = %s", this.getListOfResults(), this.getConcatString());
			//		"Concat([1, 3, 1, 5, 3], [0, 1, 4, 9], []) = [1, 3, 1, 5, 3, 0, 1, 4, 9]"
		}
	}

}
