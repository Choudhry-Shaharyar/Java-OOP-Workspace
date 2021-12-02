package model;

public class Subscriber extends Follower {

	private String[] recommenededVideos;
	private int nov; // number of recommended videos

	public Subscriber(String name, int maxNumOfChannels, int maxNumOfRecommendedVideos) {
		super("Subscriber " + name, maxNumOfChannels);
		this.recommenededVideos = new String[maxNumOfRecommendedVideos];
		this.nov = 0;
	}
	public void addRecommendedVid(String video) {
		this.recommenededVideos[this.nov] = video;
		this.nov++;
	}

	public String getRecommenededVideos() {
		String s = "";
		if(this.nov ==0) {
			return s;
		}
		for(int i = 0; i < this.nov; i++) {
			if(i == this.nov -1) {
				s = s + this.recommenededVideos[i];
			} else {
				s = s + this.recommenededVideos[i] + ", ";
			}
		}
		return s;
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
		// find channel that contains video
		int indexChannel = 0;
		for(int i =0; i < this.noc; i++) { // going over the followed channels videos
			for(int k = 0; k < (this.followedChannels[i].getNov()); k++) { // going over the followed channel
				if(this.followedChannels[i].getReleasedVideosArray()[k].equals(video)) { // checking to see if the watched 'String video' is uploaded in a channel as a releasedvideo
					// Getting index/position of channel in the array
					indexChannel = i;
				}
			}
		}
		// going over the list of followers of the channel(that contains the watched video)
		for(int i =0; i < this.followedChannels[indexChannel].nof; i++) { // nof = number of followers
			if(this.followedChannels[indexChannel].followers[i] instanceof Monitor) { // only adding Watch stats to Monitor type followers
				// for each monitor of channel, update the statistics
				((Monitor) this.followedChannels[indexChannel].followers[i]).addWatchStats(indexChannel,time);
			}
		}
	}

	public void setRecommenededVideos(String[] recommenededVideos) {
		this.recommenededVideos = recommenededVideos;
	}

	public int getNov() {
		return nov;
	}

	public void setNov(int nov) {
		this.nov = nov;
	}

	public String toString() {
		String output = "";
		if (super.getNumChannelFollowing() == 0 && this.nov == 0 ){
			output =  String.format("%s follows no channels and has no recommended videos.", super.getName());
		} else if(super.getNumChannelFollowing() != 0 && this.nov== 0 ) {
			output = String.format("%s follows [%s] and has no recommended videos.", super.getName(), super.getFollowedChannels());
		}
		else if(super.getNumChannelFollowing() != 0 && this.nov != 0 ) {
			output = String.format("%s follows [%s] and is recommended <%s>.", super.getName(), super.getFollowedChannels(), this.getRecommenededVideos());
		} else {

		}
		return output;
	}
}