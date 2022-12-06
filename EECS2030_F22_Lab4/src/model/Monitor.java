package model;

public class Monitor extends Follower {
	
	private boolean[] initialized; //initalized[i] indicates if channels[i] has been watched for at least once.
	private int[] views; //indicates how many timers channel[i] has been watched.
	private int[] total; //indicates the total watch time of channel[i].
	private int[] max; //indicates the maximum watch time of channel[i].
	private double [] avg; //avg[i] indicates the average watch time of channel[i].
	
	public Monitor(String name, int maxNumOfChannels){
		super(name, maxNumOfChannels);
		
		//Initalize all array attributes to be of length 'maxNumOfChannels'.
		initialized = new boolean[maxNumOfChannels];
		views = new int[maxNumOfChannels];
		total = new int[maxNumOfChannels];
		max = new int[maxNumOfChannels];
		avg = new double[maxNumOfChannels];
	}
	
	
	public void updateStat(String channelName, int watchTime) {
		
		/*
		 * 1. Figure out the index of the followed channel with name 'channelName' (say it's index 'i')
		 * 2. Update elements at index 'i' in views, total, max, avg arrays.
		 * 
		 * If this is the first time 'updateStat' is invoked to change channels[i], then after the updates,
		 * change 'channels[i]' to true.
		 */
		
		for(int i = 0; i < this.noc; i++) {
			if(this.channels[i].equals(channelName)) {
				
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String toString() {
		String result = "";
		
		String listOfChannels = "";
		listOfChannels += "[";
		for(int i = 0; i < this.noc; i++) {
			listOfChannels += this.channels[i].getName();
			//If initalized[i] is false, do not include statistical item.
			//If initalized[i] is true, include statistical item.
			
			if(i < this.noc-1) {
				listOfChannels += ", ";
			}
		}
		listOfChannels += "]";
		
		if(this.noc == 0) {
		result = String.format("Monitor %s follows no channels.", name);
		}
		
		else if (this.noc != 0) {
			result = String.format("Monitor %s follows %s.",
					name, listOfChannels);
		}
		
		return result;
	}
	

	
	
}
