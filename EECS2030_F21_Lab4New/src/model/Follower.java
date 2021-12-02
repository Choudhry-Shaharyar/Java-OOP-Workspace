package model;

public class Follower {

	// variables are protected so that they are allowed to be inherited classes Monitor and Subscriber

	protected String name; // will not be inherited to subclass if variable is private
	protected Channel[] followedChannels;
	protected int noc;
	protected int maxNOF; // max number of followed channels

	public Follower(String name, int maxNumOfChannels) {
		this.name = name;
		this.noc = 0;
		this.followedChannels = new Channel[maxNumOfChannels];	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFollowedChannels() {
		String s = "";
		if(this.noc==0) {
			return s;
		}
		for(int i = 0; i < this.noc; i++) {
			if(i == this.noc -1) {
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

	public void addFollowedChannel(Channel c) {
		this.followedChannels[this.noc] = c;
		this.noc++;
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
		return noc;
	}
	public void setNumChannelFollowing(int numChannelFollowing) {
		this.noc = numChannelFollowing;
	}

	public void unfollow (Channel c) {
		int index = 0;
		for(int i =0; i < this.getNumChannelFollowing(); i++) {	
			if(this.followedChannels[i].equals(c)) {
				index = i;
			}
		}
		Channel[] ch = new Channel[this.getNumChannelFollowing() - 1];
		for(int i =0, j=0; i < this.getNumChannelFollowing(); i++) {
			if(i == index) {
				this.followedChannels[i] = null;
				if(this.getNumChannelFollowing() ==1) {
					this.noc--;
				}
				continue;
			}
			ch[j] = this.followedChannels[i];
			j++;
			this.followedChannels[i] = null;
		} 
		for(int i =0; i < this.getNumChannelFollowing() - 1; i++) {
			this.followedChannels[i] = ch[i];
		}
		if(this.noc != 0) {
			this.noc--;
		}	
	}
}