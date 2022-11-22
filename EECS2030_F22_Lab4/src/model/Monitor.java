package model;

public class Monitor extends Follower {
	
	private String status;
	
	public Monitor(String videoname, int maxChannels){
		super(videoname, maxChannels);
		
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
			this.status = String.format("Monitor %s follows %s.",
					super.getName(), list);
		}
		return status;
	}
	
}
