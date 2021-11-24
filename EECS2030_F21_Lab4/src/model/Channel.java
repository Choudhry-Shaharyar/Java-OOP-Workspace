package model;

public class Channel {

	protected String name;
	protected int maxNOF;
	protected int maxNOV;
	protected Follower[] followers;
	protected String[] videos;
	protected int nov;
	protected int nof;
	protected int[] watchtimes;
	protected int numwatchtimes = 0;
	protected int maxWatchtime =0;
	
	///
	protected String names[];
	protected int numViewsArr[];
	protected int wacthTimesNumerator[];
	protected int maxWatchTime2[];
	
	
	//

// 12:15 time stamp [HD] EECS2030 F21 - Lecture 5 - Part D1 - SMS: 3rd Design - Use of extends and super
	public Channel (String name, int maxNOF, int maxNOV) {
		this.followers = new Follower[maxNOF];
		this.videos = new String[maxNOV];
		this.name = name;
		this.nov = 0;
		this.nof = 0;
		this.watchtimes = new int[maxNOV];
	
		
		//
		this.names = new String[maxNOF];
		this.numViewsArr = new int [maxNOV];
		this.wacthTimesNumerator = new int [maxNOV];
		
		this.maxWatchTime2 = new int[10];
		for(int i = 0; i < 10; i++) {
			this.maxWatchTime2[i] = 0; // setting maxWatch time for all x videos to 0 by default.
		}
		//
	}
	
	
	

	public String[] getNames() {
		return names;
	}




	public void setNames(String[] names) {
		this.names = names;
	}




	public int[] getNumViewsArr() {
		return numViewsArr;
	}




	public void setNumViewsArr(int[] numViewsArr) {
		this.numViewsArr = numViewsArr;
	}




	public int[] GetWacthTimesNumerator() {
		return wacthTimesNumerator;
	}




	public void setWacthTimesList(int[] wacthTimesList) {
		this.wacthTimesNumerator = wacthTimesList;
	}




	public int[] getWatchtimes() {
		return watchtimes;
	}

	public int getMaxWatchTime() {
		return maxWatchtime;
	}
	public void addWatchtimes(int watchtime) {
		if(watchtime > this.maxWatchtime) {
			this.maxWatchtime = watchtime;
		}
//		this.watchtimes[this.nov] = watchtime;
		this.watchtimes[this.numwatchtimes] = watchtime;
		numwatchtimes++;
	}
	
	public void addWatchtimesList(int watchtime, int indexVideo) {
		if(watchtime > this.maxWatchTime2[indexVideo]) {
			this.maxWatchTime2[indexVideo] = watchtime;
		}
//		this.watchtimes[this.nov] = watchtime;
		this.wacthTimesNumerator[indexVideo] = this.GetWacthTimesNumerator()[indexVideo] + watchtime;
	//	numwatchtimes++;
	}

	


	public int[] getMaxWatchTime2() {
		return maxWatchTime2;
	}




	public void setMaxWatchTime2(int[] maxWatchTime2) {
		this.maxWatchTime2 = maxWatchTime2;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMaxNOF() {
		return maxNOF;
	}


	public void setMaxNOF(int maxNOF) {
		this.maxNOF = maxNOF;
	}


	public int getMaxNOV() {
		return maxNOV;
	}


	public void setMaxNOV(int maxNOV) {
		this.maxNOV = maxNOV;
	}


	public boolean equals (Object obj) {
		boolean output = false;
		if(this == obj) { 
			output  = true; 
		}
		if(obj == null || this.getClass() != obj.getClass()) { 
			output =  false;
		}
		Channel other = (Channel) obj;
		//return ( this. == other.area && this.function.equals(other.function));

		return output;
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


	public void setFollowers(Follower[] followers) {
		
	}
	
	public String[] getVids() {
		return this.videos;
	}


	public String getVideos() {
		String s = "";
		for(int i = 0; i < this.nov; i++) {
			if(i == this.nov - 1) {
				s = s + this.videos[i];
			}
			else {
				s = s + this.videos[i] + ", ";
				
			}
		}
		return s;
	}


	public void setVideos(String[] videos) {
		this.videos = videos;
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
			output =  String.format("%s released <%s> and has no followers.", this.getName(), this.getVideos());
		}
		
		else if(this.getNof() != 0 && this.getNov() ==0) {
			output =  String.format("%s released no videos and is followed by [%s].", this.getName(), this.getFollowers());
		}
		else if(this.getNof() != 0 && this.getNov() !=0) {
			output =  String.format("%s released <%s> and is followed by [%s].", this.getName(), this.getVideos(), this.getFollowers());
		}
		
	//	"Cafe Music BGM released no videos and is followed by [Subscriber Alan]."
		return output;
	}

	/* Update 1: video release updated on `ch1` */
	/* Update 2: video recommendation updated on all subscribers: `f1` and `f3` */
	public void releaseANewVideo(String name) {
		this.videos[this.nov] = name;	
		this.nov++;
		
		Subscriber s = new Subscriber("a", 20, 20);
		
		for(int i = 0; i < this.getNof(); i++) {	
			if(this.followers[i].equals(s)) {
				this.followers[i].addReommendedVids(name);
			}
			
		}
		
	}

	public void follow(Follower f1) {
		this.followers[this.nof] = f1;
		this.nof++;
	
		//Channel c  = new Channel(this.getName(), this.getMaxNOF(), this.getMaxNOV()); 
		// or try this 
		//f1.addFollowedChannel(c); //
		f1.addFollowedChannel(this); ///////////////////////
		
	}
//	 * Let `f1` stop following `ch1` (which updates both the context object `ch1` and argument object `f1`).
//	 */
//	ch1.unfollow(f1);
//	
	public void unfollow(Follower f1) {
		// removing the follower from channel object
		int index = -1;
		
		for(int i =0; i < this.getNof(); i++) {	
			if(this.followers[i].equals(f1)) {
				index = i;
			}
		}
		if(index != -1) { // meaning the follower follows the channel
		//Follower[] f = new Follower[f1.numChannelFollowing - 1];
		Follower[] f = new Follower[this.getNof() - 1];
//		for(int i =0, j=0; i < f1.numChannelFollowing; i++) {
		for(int i =0, j=0; i < this.getNof(); i++) {
			if(i == index) {
				this.followers[i] = null;
				if(this.getNof() ==1) {
					this.nof--;
				}
				continue;
			}  
			f[j] = this.followers[i];
			j++;
			this.followers[i] = null;
		} 
		for(int i =0; i < this.getNof() - 1; i++) {
			this.followers[i] = f[i];
			this.nof--;
		}
		
		f1.unfollow(this);
	
		} else { // meaning the follower does not  follow the channel so dont do anything
			
		}
		
	}



//	public double getAvgWatchTime() {
//		int numerator = 0;
//		int denominator = this.getNov();
//		double answer =0.0;
//		for(int i =0; i < this.getNov(); i++) {
//			numerator = numerator + this.getWatchtimes()[i];
//		}
//		answer = (double) numerator  / (double) denominator;
//		return answer;
//	
//	}
	public double getAvgWatchTime(int indexVideo) {
		int numerator = 0;
		int denominator = this.getNumViewsArr()[indexVideo];
		double answer =0.0;
		for(int i =0; i < this.getNov(); i++) {
			numerator = numerator + this.GetWacthTimesNumerator()[i];
		}
		answer = (double) numerator  / (double) denominator;
		return answer;
	
	}

	
}
