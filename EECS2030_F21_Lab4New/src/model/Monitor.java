package model;

public class Monitor extends Follower {

	private boolean[] initialized; //  initialized[i] indicates if channels[i] has been watched for atleast once 
	private int[] views; // indicates how many times channel[i] has been watched
	private int[] total; // total[i] indicates total watch time of channel[i]
	private int[] max;// indicates max watch time of channel[i]
	private double[] avg; // avg watch time of channel [i]

	public Monitor(String name, int maxNumOfChannels) {
		super("Monitor " + name, maxNumOfChannels);
		super.maxNOF = maxNumOfChannels;
		super.followedChannels = new Channel[maxNumOfChannels];

		this.views = new int[maxNumOfChannels];
		this.total = new int[maxNumOfChannels];
		this.max = new int[maxNumOfChannels];
		this.avg = new double[maxNumOfChannels];
		this.initialized = new boolean[maxNumOfChannels];
	}

	public void addWatchStats(int index, int time) {		
		this.views[index] += 1; 
		this.total[index] += time;
		if(time > this.max[index]) {
			this.max[index] = time;
		}
		this.initialized[index] = true;

		this.avg[index] = (double) this.total[index] / (double) this.views[index];


	}
	// overloaded class
	private String getFollowedChannel2() {
		String s = "";
		for(int i =0; i < this.noc; i ++) {

			if(i == 0) {
				if(this.initialized[i] == true) {
					s =  String.format("%s {#views: %s, max watch time: %s, avg watch time: %.2f}" , this.followedChannels[i].getName(),this.views[i],this.max[i], this.avg[i] );
				} else {
					s =  this.followedChannels[i].getName();
				}
			} else {
				if(this.initialized[i] == true) {
					s =  String.format("%s, %s {#views: %s, max watch time: %s, avg watch time: %.2f}" , s, this.followedChannels[i].getName(),this.views[i],this.max[i], this.avg[i] );
				} else {
					s = s + ", " + this.followedChannels[i].getName();
				}
			}
		}
		return s;
	}


	public String toString() {
		String output = "";

		if(this.noc == 0) {
			output = String.format("%s follows no channels.", this.getName());
		} else if(this.noc != 0) {
			output = String.format("%s follows [%s].", this.getName(), this.getFollowedChannel2());
		}
		return output;	
	}
}