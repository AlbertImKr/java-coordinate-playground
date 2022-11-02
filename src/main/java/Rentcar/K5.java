package Rentcar;

public class K5 extends Car {
	private final int fuelEfficiency = 13;
	private final int distance;

	public K5(int distance) {
		this.distance = distance;
	}

	@Override
	double getDistancePerLiter() {
		return fuelEfficiency;
	}

	@Override
	double getTripDistance() {
		return this.distance;
	}

	@Override
	String getName() {
		return "K5";
	}
}
