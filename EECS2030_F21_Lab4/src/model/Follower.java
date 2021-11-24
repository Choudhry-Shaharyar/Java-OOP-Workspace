package model;

public class Follower {

	private	String name;
	protected Channel[] followedChannels;
	protected int maxNOF; // max number of followed channels
	protected int numChannelFollowing;

	/// for subcriber
	protected int maxNORV; // max number of recommend videos
	protected String[] videos;
	protected int numReommendedVids;
	//

	// for monitor
	protected int views;
	protected int maxWatchTime;
	protected double avgWatchTime;
	protected int numWatchedvids;
	protected String[] monitoredChannelsStats;
	protected int numMonChannels = 0;
	protected String monitoredVideos[];
	protected int numMonitoredVids = 0;
	//

	//	protected String[] monitorChannelStats;

	public Follower(String name) {
		this.name = name;
		this.numChannelFollowing = 0;
	}
	public void addReommendedVids(String video) {
		this.videos[this.numReommendedVids] = video;
		this.numReommendedVids++;
	}


	public int getNumMonChannels() {
		return numMonChannels;
	}
	public void setNumMonChannels() {
		this.numMonChannels = numMonChannels + 1;
	}
	public void addNumWatchedVids() {
		this.numWatchedvids = this.numWatchedvids + 1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFollowedChannels() {
		String s = "";
		if(this.numChannelFollowing==0) {
			return s;
		}
		for(int i = 0; i < this.numChannelFollowing; i++) {
			if(i == this.numChannelFollowing -1) {
				s = s + this.followedChannels[i].getName();
			} else {
				s = s + this.followedChannels[i].getName() + ", ";
			}
		}
		return s;
	}

	public Channel[] getFollowedChannel1() {

		return this.followedChannels;
	}



	// we prolly dont need indexVid
	public void setWatch(String video, int time, int indexChannel, int indexVideo) {
	
		//		this.monitoredChannelsStats[this.numMonChannels] = String.format("%s {#views: %s, max watch time: %s, avg watch time: %.2f}", this.followedChannels[indexChannel].getName(), this.followedChannels[indexChannel].getNov()[indexVideo], this.followedChannels[indexChannel].getMaxWatchTime(), this.followedChannels[indexChannel].getAvgWatchTime());  
		//		check if the video is one of the existing monitored videos list, if so then add stats too it.
		
		
//		for(int i =0; i < this.getNumChannelFollowing(); i++) {
//			for(int j = 0; j < this.getFollowedChannel1()[indexChannel].getNov(); j++ )
//			if(this.getFollowedChannel1()[indexChannel].getVids()[j])
//		}
//		
//		if(minotred video exists) {
//			this.followedChannels[indexChannel].numViewsArr[indexVideo] = this.followedChannels[indexChannel].getNumViewsArr()[indexVideo] + 1;
//			this.monitoredChannelsStats[this.numMonChannels] = String.format("%s {#views: %s, max watch time: %s, avg watch time: %.2f}", this.followedChannels[indexChannel].getName(), this.followedChannels[indexChannel].getNumViewsArr()[indexVideo], this.followedChannels[indexChannel].getMaxWatchTime2()[indexVideo], this.followedChannels[indexChannel].getAvgWatchTime(indexVideo));  
//
//		} else {
			this.followedChannels[indexChannel].numViewsArr[indexVideo] = this.followedChannels[indexChannel].getNumViewsArr()[indexVideo] + 1;
			// this.monitoredChannelsStats[this.numMonChannels] = String.format("%s {#views: %s, max watch time: %s, avg watch time: %.2f}", this.followedChannels[indexChannel].getName(), this.followedChannels[indexChannel].getNumViewsArr()[indexVideo], this.followedChannels[indexChannel].getMaxWatchTime2()[indexVideo], this.followedChannels[indexChannel].getAvgWatchTime(indexVideo));  
			//this.monitoredVids[this.numMonVids] = video;
			 this.monitoredChannelsStats[indexChannel] = String.format("%s {#views: %s, max watch time: %s, avg watch time: %.2f}", this.followedChannels[indexChannel].getName(), this.followedChannels[indexChannel].getNumViewsArr()[indexVideo], this.followedChannels[indexChannel].getMaxWatchTime2()[indexVideo], this.followedChannels[indexChannel].getAvgWatchTime(indexVideo));  

			this.numMonChannels++;	
		//}
	}

	public String getReccomendedVideos() {
		String s = "";
		if(this.numReommendedVids==0) {
			return s;
		}
		for(int i = 0; i < this.numReommendedVids; i++) {
			if(i == this.numReommendedVids -1) {
				s = s + this.videos[i];
			} else {
				s = s + this.videos[i] + ", ";
			}
		}
		return s;
	}

	public void addFollowedChannel(Channel c) {
		this.followedChannels[this.numChannelFollowing] = c;
		this.numChannelFollowing++;
	}
	public void setFollowedChannels(Channel[] followedChannels) {
		this.followedChannels = followedChannels;
	}
	public int getMaxNOF() {
		return maxNOF;
	}
	public void setMaxNOF(int maxNOF) {
		this.maxNOF = maxNOF;
	}
	public int getNumChannelFollowing() {
		return numChannelFollowing;
	}
	public void setNumChannelFollowing(int numChannelFollowing) {
		this.numChannelFollowing = numChannelFollowing;
	}

	public void unfollow (Channel c) {
		// removing the channel from follower object
		int index = 0;
		for(int i =0; i < this.getNumChannelFollowing(); i++) {	
			if(this.followedChannels[i].equals(c)) {
				index = i;
			}
		}
		//Follower[] f = new Follower[f1.numChannelFollowing - 1];
		Channel[] ch = new Channel[this.getNumChannelFollowing() - 1];
		//				for(int i =0, j=0; i < f1.numChannelFollowing; i++) {
		for(int i =0, j=0; i < this.getNumChannelFollowing(); i++) {
			if(i == index) {
				this.followedChannels[i] = null;
				if(this.getNumChannelFollowing() ==1) {
					this.numChannelFollowing--;
				}
				continue;
			}
			ch[j] = this.followedChannels[i];
			j++;
			this.followedChannels[i] = null;
		} 
		for(int i =0; i < this.getNumChannelFollowing() - 1; i++) {
			this.numChannelFollowing--;
			this.followedChannels[i] = ch[i];
		}
	}



	public boolean equals (Object obj) {
		boolean output = false;
		if(this == obj) { 
			output  = true; 

		}
		if(this.getClass() == obj.getClass()) {
			output = true;
		}
		if(obj == null || this.getClass() != obj.getClass()) { 
			output =  false;
		}
		Follower other = (Follower) obj;
		//return ( this. == other.area && this.function.equals(other.function));

		return output;
	}

}

//
//	public String toString() {
//
//		return String.format("%s follows [%s] and has no recommended videos", this.getName(), this.getFollowedChannels());
//	}





