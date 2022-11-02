package Rentcar;

public class Sonata extends Car {
	private final int fuelEfficiency = 10;
	private final int distance;

	public Sonata(int distance) {
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
		return "Sonata";
	}
}
