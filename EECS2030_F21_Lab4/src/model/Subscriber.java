package model;

public class Subscriber extends Follower {




//	int maxNOR;
	public Subscriber(String name, int maxNOF, int maxNOR) {
		super("Subscriber " + name);
		super.maxNOF = maxNOF;  // followed channels
		super.followedChannels = new Channel[maxNOF]; // followed channels
		super.maxNORV = maxNOR; // recommended videos
		super.videos = new String[maxNOR];
		super.numReommendedVids = 0;
	}



	

	public int getNumReommendedVids() {
		return numReommendedVids;
	}




	public void setNumReommendedVids(int numReommendedVids) {
		this.numReommendedVids = numReommendedVids;
	}




	public String toString() {
		String output = "";
		if (super.getNumChannelFollowing() == 0 && this.getNumReommendedVids() == 0 ){
			output =  String.format("%s follows no channels and has no recommended videos.", super.getName());
		} else if(super.getNumChannelFollowing() != 0 && this.getNumReommendedVids() == 0 ) {
			output = String.format("%s follows [%s] and has no recommended videos.", super.getName(), super.getFollowedChannels());
		}
		else if(super.getNumChannelFollowing() != 0 && this.getNumReommendedVids() != 0 ) {
			output = String.format("%s follows [%s] and is recommended <%s>.", super.getName(), super.getFollowedChannels(), super.getReccomendedVideos());
		} else {
			
		}

		return output;
	}




	/* 
	 * Subscriber `sub1` watched Jazz Piano Radio for 20 minutes. 
	 * 
	 * After a subscriber watched a recommended video of a channel, 
	 * 	the watch time is immediately used to update the statistics of all that channel's monitors (not subscribers).
	 * 
	 * Assume that the second argument of method `watch` is always an integer specifying the watch time in terms of minutes. 
	 * 
	 * Since video names across all channels are assumed to be unique, 
	 * 	the `watch` method should be able to figure out to which channel the specified video name belongs.
	 */
	public void watch(String video, int time) {
		// TODO Auto-generated method stub
		// find channel that contains video
		int indexChannel = 0;
		int indexVideo = 0;
		for(int i =0; i < this.numChannelFollowing; i++) {
			for(int k = 0; k < (this.followedChannels[i].getNov()); k++) {
				if(this.followedChannels[i].getVids()[k].equals(video)) {
					indexVideo = k;
					indexChannel = i; // i cant edit the monitor class from here so send to follower class and make changes there
					// this.followedChannels[indexChannel].addWatchtimes(time);
					this.followedChannels[indexChannel].addWatchtimesList(time, indexVideo);
				//	this.followedChannels[indexChannel].setNov(this.followedChannels[indexChannel].getNov() + 1);
					
				}
			}
		}
		
			// from this channel we need to get all the followers that are of Monitor type his.getClass() == obj.getClass()) {
			Monitor m = new Monitor("a", 10);
			for(int j = 0; j < this.followedChannels[indexChannel].getNof(); j++) {
				if(this.followedChannels[indexChannel].followers[j].getClass() == m.getClass()) { // finding all the monitors in the specific watched channel
					this.followedChannels[indexChannel].followers[j].addNumWatchedVids();
					//this.followedChannels[indexChannel].followers[j].setNumMonChannels();	
					this.followedChannels[indexChannel].followers[j].setWatch(video, time, indexChannel, indexVideo);
					
//					for(int i = 0; i < this.)
//						f[i].updateWatch();
				}
			}
				
			
			
		}
		
		

			
	
		
	}





	

