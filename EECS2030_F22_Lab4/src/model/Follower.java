package model;

public class Follower {
	
	private String name;
	private int maxVideos;
	private Channel[] chanList;
	private String[] releasedVideos;
	private String status;
	private int noc; //number of channels 
	
	
	public Follower(String name, int maxChannels, int maxVideos){ 
		this.name = name;
		chanList = new Channel[maxChannels];
		releasedVideos = new String[maxVideos];
		
		if(this.noc == 0 ) {
			status = String.format("Subscriber %s follows no channels and has no recommended videos.",
					this.name);
		}
	}

	public Follower(String videoname, int maxChannels) {
		this.name = videoname;
		chanList = new Channel[maxChannels];
		
		if(this.noc == 0) {
			status = String.format("Monitor %s follows no channels.", videoname);
		}
	}

	public String getName() {
		return this.name;
		
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {	
		return status;
	}

	public String getFollowers() {
		String list = "";	
		return list;
		
	}
	
	public Channel[] getChannelList() {
		return this.chanList;
	}
	
	public void setChannelList(Channel[] newChanList) {
		this.chanList = newChanList;
	}
	
	public int getNumberOfChannels() {
		return this.noc;
	}
	
	public void setNumberOfChannels(int newNoc) {
		this.noc = newNoc;
	}
	
	
	public void setChannel(Channel chan) {
		chanList[this.noc] = chan;
		this.noc++;
	}
	
	public String getChannelCafe() {
		
		
		if(this.noc-1 == 0) {
			return chanList[this.noc-1].getCafe();
		}
		else {
			String list = "[";
			for(int i = 0; i < this.noc; i++) {
				list += chanList[i].getCafe();
				if(i < this.noc-1) {
					list += ", ";
				}
			}
			list += "]";
			return list;
		}
	}
	
	
	
	
}


