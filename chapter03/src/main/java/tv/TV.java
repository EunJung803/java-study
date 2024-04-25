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
}
