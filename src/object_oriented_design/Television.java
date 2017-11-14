package object_oriented_design;

/**
 * Class: Fundamental Programming Practice <br />
 * 
 * @author "Jing Chen" <br />
 *         Description: Write a Java code for the given class diagram and test
 *         it by writing a driver class (Main Class). Each void method should
 *         display the information such as Power On, Volume increased & Volume
 *         decreased.<br />
 */
class Television {
	final private String MANUFACTURER;
	final private int SCREEN_SIZE;
	private boolean powerOn = false;
	private int channel = 1;
	private int volum = 10;

	public Television(String brand, int size) {

		MANUFACTURER = brand;
		SCREEN_SIZE = size;
	}

	public void setChannel(int station) {
		channel = station;

	}

	void power() {
		powerOn = true;
	}

	void increaseVolue() {
		volum++;

	}

	void decreaseVolue() {
		volum--;

	}

	public int getChannel() {
		return this.channel;
	}

	public int getVolume() {
		return this.volum;
	}

	public String getManufacture() {
		return this.MANUFACTURER;
	}

	public int getScreenSize() {
		return this.SCREEN_SIZE;
	}

	public static void main(String args[]) {

		Television tel = new Television("HAIER", 10);
		tel.power();
		tel.setChannel(5);
		tel.decreaseVolue();
		System.out.println("The ScreenSize now is " + tel.getScreenSize());
		System.out.println("The channel now is " + tel.getChannel());
		System.out.println("The volum now is " + tel.getVolume());

	}

}

/*
 * The ScreenSize now is 10
The channel now is 5
The volum now is 9

 */
