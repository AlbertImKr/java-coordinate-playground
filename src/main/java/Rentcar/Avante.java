package Rentcar;

public class Avante extends Car {
	private final int fuelEfficiency = 15;

	private final int distance;

	public Avante(int distance) {
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
		return "Avante";
	}
}
