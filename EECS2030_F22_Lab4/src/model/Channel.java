package model;

public class Channel {

	private Follower[] followers; //Polymorphic array
	private String[] releasedVideos;
	private String name;
	private String status;

	private int nov; //number of released videos
	private int nof; //number of followers



	public Channel(String name, int maxFollower, int maxVideo) {
		followers = new Follower[maxFollower];
		releasedVideos = new String[maxVideo];
		this.name = name;
		this.nof = 0;
		this.nov = 0;
	}

	public String getName() {
		return this.name;
	}

	public String[] getReleasedVideos() {
		return this.releasedVideos;
	}



	public void addWatchtime(int watchTime) {
		/*
		 * See Subscriber's 'watch' method
		 * 	2.2 Go over the list of followers of 'this'.
		 * 	2.3 For each monitor 'mon' of 'ch', update the statistics (e.g, initialized, max, views).
		 * 
		 * For 2.3, implement it as a helper method in Monitor, e.g., 'mon.updateStat(watchTime)'
		 */


		for(int i = 0; i < this.nof; i++) {
			Follower f = this.followers[i];
			if(f instanceof Monitor) {
//				Monitor m = (Monitor) this.followers[i];
				
			((Monitor) this.followers[i]).updateStat(name, watchTime);
			}
		}



	}

	public String toString() {
		String result = "";

		String listVideos = "";
		listVideos += "<";
		for(int i = 0; i < this.nov; i++) {
			listVideos += releasedVideos[i];
			if(i < this.nov-1) {
				listVideos+= ", ";
			}
		}
		listVideos += ">";

		String listOfFollowers = "";
		listOfFollowers += "[";
		for(int i = 0; i < this.nof; i++) {
			String type = null;
			Follower f = this.followers[i];

			if(f instanceof Subscriber) {
				type = "Subscriber";
			}
			else if(f instanceof Monitor) {
				type = "Monitor";
			}
			listOfFollowers += type + " " + this.followers[i].getName();
			if(i < this.nof-1) {
				listOfFollowers+= ", ";
			}
		}
		listOfFollowers += "]";


		//Multiple cases
		if(this.nov == 0 && this.nof == 0) {
			result  = String.format("%s released no videos and has no followers.",
					this.name);
		}
		else if (this.nov != 0 && this.nof == 0){ //this.nov > 0
			result = String.format("%s released %s and has no followers.",
					this.name,
					listVideos);
		}
		else if(this.nov == 0 && this.nof != 0) {
			result = String.format("%s released no videos and is followed by %s.",
					this.name, listOfFollowers);
		}
		else { //this.nov != 0 && this.nof != 0
			result = String.format("%s released %s and is followed by %s.",
					this.name, listVideos, listOfFollowers );
		}

		return result;
	}

	
	
	public void releaseANewVideo(String videoName) {
		releasedVideos[this.nov] = videoName;
		this.nov++;

		for(int i = 0; i < this.nof; i++)  {
			Follower f = this.followers[i];
			if(f instanceof Subscriber) {
				//Why is the cast necessary.
				((Subscriber) f).addRecommendedVideo(videoName); //Since DT of f fulfills the expectation of the cast type.
			}
		}


	}




	public void follow(Follower f) {
		//Update on the current channel.
		this.followers[this.nof] = f;
		this.nof++; 

		//Updates on parameter f.
		f.follow(this);	
	}


	public void unfollow(Follower f) {
		
		
		//Update on the current channel.
			//Refer to Lab 1 uninstall.
		int index = -1;
		for(int i = 0; i < this.nof; i++) {
			if(this.followers[i].equals(f)) {
				index = i;
			}
		}

		if(index < 0) {
			//Do Nothing
		}
		else {
			//1. Assign the index array to null
			this.followers[index] = null;
			//2. for all elements at index + 1
			for(int i = 0; i < index + 1; i++) {
				this.followers[index] = this.followers[index + 1];
			}
			//3. Assign the index +1 to be null.
			this.followers[index + 1] = null;
			//4. decrement nof
			this.nof--;
		}


		//Update on parameter f.
		f.unfollow(this);
	}


}
