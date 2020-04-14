package app;

import java.util.Random;

public class Car implements Runnable {
	private String name;

	public Car() {

	}

	public Car(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int runDistance = 0;
		long startTime = System.currentTimeMillis();

		while (runDistance <= Main.DISTANCE) {
			try {
				int speed = (new Random()).nextInt(20);
				runDistance += speed;
				String log = "|";
				int percentDistance = (runDistance * 100) / Main.DISTANCE;
				for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
					if (percentDistance >= i + Main.STEP) {
						log += "=";
					} else if (percentDistance >= i && percentDistance < i + Main.STEP) {
						log += "o";
					} else {
						log += "-";
					}
				}
				log += "|";
				System.out.println(this.name + ":" + log + Math.min(Main.DISTANCE,runDistance) + "Km");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println(this.name + " finished in " + (endTime - startTime));
	}

}
