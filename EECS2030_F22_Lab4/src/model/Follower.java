package model;

public class Follower {
	
	protected String name; //inherited to all sub-class
	protected Channel[] channels;
	protected int noc; //number of channels


	public String getName() {
		return this.name;
	}
	
	public Follower(String name, int maxNumberOfChannels) {
		this.channels = new Channel[maxNumberOfChannels];
		this.name = name;
		this.noc = 0;
	}
	
	public void follow(Channel c) {
		this.channels[this.noc] = c;
		this.noc++;
	}
	
	public void unfollow(Channel c) {
		int index = -1;
		for(int i = 0; i < this.noc; i++) {
			if(this.channels[i].equals(c)) {
				index = i;
			}
		}
		
		if(index < 0){
			//Do nothing
		}
		else {
		//1. Assign the index array to null
		this.channels[index] = null;
		//2. for all elements at index + 1
		for(int i = 0; i < index + 1; i++) {
			this.channels[index] = this.channels[index + 1];
		}
		//3. Assign the index +1 to be null.
		this.channels[index + 1] = null;
		//4. decrement noc.
		this.noc--;
		}
	}
	
	
	public String toString() {	
		String result = "";
		

			result = String.format("Subscriber %s follows no channels and has no recommended videos.",
					this.name);
		
		return result;
	}

	
	
}


