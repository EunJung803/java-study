package tv;

public class TV {
	private int volume;		// 0 ~ 100
	private int channel;	// 1 ~ 255
	private boolean power;	// on , off
	
	public void status() {
		if(power) {
			System.out.println("TV[power=on, channel=" + channel + "," + " volume=" + volume + "]");	
		}
		else {
			System.out.println("TV[power=off, channel=" + channel + "," + " volume=" + volume + "]");
		}
	}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public int getVolume() {
		return volume;
	}

	public int getChannel() {
		return channel;
	}

	public boolean isPower() {
		return power;
	}

	public void power(boolean power) {
		this.power = power;
	}

	public void volume(int volume) {
		if(volume > 100) {
			this.volume = 0;
		}
		else if(volume < 0) {
			this.volume = 100;
		}
	}

	public void channel(int channel) {
		if(channel > 255) {
			this.channel = 1;
		}
		else if(channel < 1) {
			this.channel = 255;
		}
	}

	public void channel(boolean b) {
		if(b) {
			this.channel += 1;
			channel(channel);
		}
		if(b==false) {
			this.channel -= 1;
			channel(channel);
		}
		
	}

	public void volume(boolean b) {
		if(b) {
			this.volume += 1;
			volume(volume);
		}
		if(b==false) {
			this.volume -= 1;
			volume(volume);
		}
	}
}
