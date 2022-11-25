package model;

public class Channel {

	private Follower[] followers;
	private String[] releasedVideos;
	private String cafe;
	private String status;

	private int nov; //number of released videos
	private int nof; //number of followers



	public Channel(String cafeMusic, int maxFollower, int maxVideo) {
		followers = new Follower[maxFollower];
		releasedVideos = new String[maxVideo];
		this.cafe = cafeMusic;

		if(nov == 0 && this.nof == 0) {
			status = String.format("%s released no videos and has no followers.", cafeMusic);
		}
	}

	public String getCafe() {
		return this.cafe;
	}




	public String toString() {
		return status;
	}

	public void releaseANewVideo(String videoName) {
		releasedVideos[this.nov] = videoName;
		this.nov++;

		String list = "";
		list += "<";
		for(int i = 0; i < this.nov; i++) {
			list += releasedVideos[i];
			if(i < this.nov-1) {
				list+= ", ";
			}
		}
		list += ">";
		this.status = String.format("%s released %s and has no followers.", this.cafe, list);
	}


	public void follow(Follower follower) {
		Follower f = follower;

		this.followers[this.nof] = follower;
		f.setChannel(this);
		this.nof++;

		if(this.nov == 0 && follower.getClass() == Subscriber.class) {
			follower.setStatus(String.format("Subscriber %s follows [%s] and has no recommended videos.",
					follower.getName(), this.cafe));
		}
		else if(this.nov == 0 && follower.getClass() == Monitor.class) {
			follower.setStatus(String.format("Monitor %s follows [%s].",
					follower.getName(), this.cafe));
		}

		status = String.format("%s released no videos and is followed by %s.",
				this.cafe, this.getStatusList());
	}

	public void unfollow(Follower follower) {
		int index = 0;
		for(int i = 0; i < this.nof; i++) {
			if(this.followers[i] == follower) {
				follower.getChannelList()[index] = follower.getChannelList()[index+1];
				follower.getChannelList()[index+1] = null;
				index = i;
				this.followers[index] = this.followers[index+1];
				this.followers[index+1] = null;
			}

		}


		this.nof--;
		follower.setNumberOfChannels(nof);
		
		
		if(this.getStatusList() != null) {
		status = String.format("%s released no videos and is followed by %s.",
				this.cafe, this.getStatusList());
		}
		else {
			status = String.format("%s released no videos and has no followers.", this.cafe);
		}
	}


	private String getStatusList() {
		String list = "[";
		boolean isSub = false;
		boolean isMonitor = false;

		if(this.nof == 0) {
			return list = null;
		}

		else {
			for(int i = 0; i < this.nof; i++) {
				//Check whether it is a Sub or a Monitor
				if(this.followers[i].getClass() == Subscriber.class) {
					if(!isSub) {
						list += "Subscriber ";
						isSub = true;
					}
					list += this.followers[i].getName();
				}

				if(this.followers[i].getClass() == Monitor.class) {
					if(!isMonitor) {
						list += "Monitor ";
						isMonitor = true;
					}
					list += this.followers[i].getName();
				}
				if(i < this.nof-1) {
					list += ", ";
				}
			}
			list += "]";
			return list;
		}
	}

}
