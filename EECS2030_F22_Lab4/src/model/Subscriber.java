package model;

public class Subscriber extends Follower {
	
	private String[] recommendedVideos;
	private int nov; //number of recommended videos.
	
	
	public Subscriber(String name, int maxNumOfChannels, int maxNumOfRecommendedVideos){
		super(name, maxNumOfChannels);
		//max number of channels allowed to follow
		//max number of recommended videos
		this.recommendedVideos = new String[maxNumOfRecommendedVideos];
	}
	
	public String getName() {
		return super.getName();
	}

	
	public void addRecommendedVideo(String recommendVideo) {
		this.recommendedVideos[this.nov] = recommendVideo;
		this.nov++;	
	}
	
	public void watch(String video, int watchTime) {
		//{#views: 1, max watch time: 20, avg watch time: 20.00}
		
	/*
	 * Assumption: 'video' is recommended by some channel being followed by the current subscriber.
	 * 
	 * 1. Go over all channels being followed by the current subscriber
	 * 2. For each followed channel, go over its list of released videos.
	 * 	2.1 If one of the released videos of channel 'ch' matches 'video'.
	 * 
	 * (For 2.2 and 2.3 below, consider invoking 'ch.addWatchtime(watchTime)')
	 * 	2.2 Go over the list of followers of 'ch'.
	 * 	2.3 For each monitor of 'ch', update the statistics (e.g, initialized, max, views).
	 * 
	 * 
	 */
		
		for(int i = 0; i < this.noc; i++) {
			Channel ch = this.channels[i];
			String currentVideo = ch.getReleasedVideos()[i];
			if(currentVideo.equals(video)) {
				ch.addWatchtime(watchTime);
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public String toString() {
		String result = "";
		
		String listOfChannels = "";
		listOfChannels += "[";
		for(int i = 0; i < this.noc; i++) {
			listOfChannels += this.channels[i].getName();
			if(i < this.noc-1) {
				listOfChannels += ", ";
			}
		}
		listOfChannels += "]";
		
		String listVideos = "";
		listVideos += "<";
		for(int i = 0; i < this.nov; i++) {
			listVideos += recommendedVideos[i];
			if(i < this.nov-1) {
				listVideos+= ", ";
			}
		}
		listVideos += ">";
		
		
		
		if(this.noc == 0 && this.nov == 0) {
			result = String.format("Subscriber %s follows no channels and has no recommended videos.",
					this.name);
		}
		else if (this.noc != 0 && this.nov == 0) {
			result = String.format("Subscriber %s follows %s and has no recommended videos.",
					this.name, listOfChannels);
		}
		else if(this.noc == 0 && this.nov != 0) {
			result = String.format("Subscriber %s follows no channels and recommended %s.",
					this.name, listVideos);
		}
		else if (this.noc != 0 && this.nov != 0) {
			result = String.format("Subscriber %s follows %s and is recommended %s.",
					this.name, listOfChannels, listVideos);
		}
		
		return result;
	}
	

	
	
}
