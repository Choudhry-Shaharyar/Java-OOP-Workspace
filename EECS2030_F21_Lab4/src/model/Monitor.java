package model;

public class Monitor extends Follower {

//	private int views;
//	private int maxWatchTime;
//	private double avgWatchTime;
	
	public Monitor(String name, int MaxNOF) {
		super("Monitor " + name);
		super.maxNOF = MaxNOF;
		super.followedChannels = new Channel[MaxNOF];
		this.views = 0;
		super.monitoredChannelsStats = new String[MaxNOF];
//		super.monitoredVideos = new String[]
		super.numMonChannels = 0;
		this.avgWatchTime = 0.0;
		this.maxWatchTime = 0;
	}


	public String toString() {
		String output = "";

		if(super.getNumChannelFollowing() == 0) {
			output = String.format("%s follows no channels.", this.getName());
		} else if(super.getNumChannelFollowing() != 0 && super.getNumMonChannels()==0) {
			output = String.format("%s follows [%s].", this.getName(), super.getFollowedChannels());
		}
		else {
			if(super.getNumMonChannels() <= 3) {                                  // stats for first video
				output = String.format("%s follows [%s, %s].", this.getName(), super.monitoredChannelsStats[0], super.getFollowedChannel1()[1].getName());
			} else {
				output = String.format("%s follows [%s, %s].", this.getName(), super.monitoredChannelsStats[0], super.monitoredChannelsStats[1]);
			}
					
		}
		
		return output;
		

	}
	
	
}
