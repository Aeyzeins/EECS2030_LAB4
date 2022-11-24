package model;

public class Subscriber extends Follower {
	
	private String status;
	
	
	public Subscriber(String name, int maxChannels, int maxVideos){
		super(name, maxChannels, maxVideos);
		//max number of channels allowed to follow
		//max number of recommended videos
		
	}
	
	public String getName() {
		return super.getName();
	}

	public String toString() {
		
		String list = "[";
		
		
		
		if(super.getNumberOfChannels() == 0) {
			list = null;
		}
		else {
			for(int i = 0; i < super.getNumberOfChannels(); i++) {
				
				list += super.getChannelList()[i].getCafe();
				if(i < super.getNumberOfChannels()-1) {
					list += ", ";
				}
			}
			list += "]";
		}

		if(list == null) {
			this.status = String.format("Subscriber %s follows no channels and has no recommended videos.",
					super.getName());
		}
		else {
			this.status = String.format("Subscriber %s follows %s and has no recommended videos.",
					super.getName(), list);
		}
		return status;
	}
	
	public void watch(String string, int i) {
		
	}
	
	
}
