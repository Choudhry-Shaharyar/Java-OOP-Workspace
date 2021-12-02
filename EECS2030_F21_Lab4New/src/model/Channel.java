package model;

public class Channel {
	// if u have no child class then use private on the variable because its not being shared or inherited
	private String name;
	private String[] releasedVideos;
	private int nov; //  number of released videos auxiliary counter
	protected Follower[] followers; // polymorphic array
	protected int nof;

	public Channel (String name, int maxFollowers, int maxReleasedVideos) {
		this.name = name;
		this.releasedVideos = new String[maxReleasedVideos];
		this.nov = 0;
		this.followers = new Follower[maxFollowers];
		this.nof = 0;
	}

	public String getName() {
		return name;
	}

	public String[] getReleasedVideosArray() {
		return this.releasedVideos;
	}

	public String getReleasedVideos() {
		String s = "";
		for(int i = 0; i < this.nov; i++) {
			if(i == this.nov - 1) {
				s = s + this.releasedVideos[i];
			}
			else {
				s = s + this.releasedVideos[i] + ", ";		
			}
		}
		return s;
	}

	public String getFollowers() {
		String s = "";
		for(int i = 0; i < this.nof; i++) {
			if(i == this.nof - 1) {
				s = s + this.followers[i].getName();
			}
			else {
				s = s + this.followers[i].getName() + ", ";				
			}
		}
		return s;
	}
	public int getNov() {
		return nov;
	}

	public void setNov(int nov) {
		this.nov = nov;
	}

	public int getNof() {
		return nof;
	}

	public void setNof(int nof) {
		this.nof = nof;
	}

	public String toString() {
		String output = "";
		if(this.getNof()==0 && this.getNov()==0) {
			output =  String.format("%s released no videos and has no followers.", this.getName());
		}

		else if(this.getNof() == 0 && this.getNov() !=0) {
			output =  String.format("%s released <%s> and has no followers.", this.getName(), this.getReleasedVideos());
		}

		else if(this.getNof() != 0 && this.getNov() ==0) {
			output =  String.format("%s released no videos and is followed by [%s].", this.getName(), this.getFollowers());
		}
		else if(this.getNof() != 0 && this.getNov() !=0) {
			output =  String.format("%s released <%s> and is followed by [%s].", this.getName(), this.getReleasedVideos(), this.getFollowers());
		}
		return output;
	}

	/* Update 1: video release updated on `ch1` */
	/* Update 2: video recommendation updated on all subscribers: `f1` and `f3` */
	public void releaseANewVideo(String video) {
		this.releasedVideos[this.nov] = video;	
		this.nov++;
		for(int i = 0; i < this.getNof(); i++) {	

			if(this.followers[i] instanceof Subscriber) {
				((Subscriber) this.followers[i]).addRecommendedVid(video);	
			}
		}	
	}
	public void follow(Follower f1) {
		this.followers[this.nof] = f1;
		this.nof++;
		f1.addFollowedChannel(this); 
	}

	public void unfollow(Follower f1) {
		// removing the follower from channel object
		int index = -1;
		for(int i =0; i < this.getNof(); i++) {	
			if(this.followers[i].equals(f1)) {
				index = i;
			}
		}
		if(index != -1) { // meaning the follower follows the channel
			Follower[] f = new Follower[this.getNof() - 1];
			for(int i =0, j=0; i < this.getNof(); i++) {
				if(i == index) {
					this.followers[i] = null; // remove the name from array
					if(this.getNof() ==1) { // if theres only 1 follower
						this.nof--; // decrement
					}
					continue; // go to start of for loop
				}  
				f[j] = this.followers[i];
				j++; // increment the counter for new array
				//this.followers[i] = null;
			} 
			for(int i =0; i < this.getNof() - 1; i++) {
				this.followers[i] = f[i];
			}
			if(this.getNof() != 0) {
				this.nof--;
			}
			f1.unfollow(this);
		} 	
	}
}