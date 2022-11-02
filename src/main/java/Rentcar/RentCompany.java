package Rentcar;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
	private final List<Car> carList;
	private static final String NEWLINE = System.getProperty("line.separator");

	private RentCompany() {
		this.carList = new ArrayList<>();
	}

	public static RentCompany create() {
		return new RentCompany();
	}

	public void addCar(Car car) {
		carList.add(car);
	}

	public String generateReport() {
		StringBuilder answer = new StringBuilder();
		carList.stream()
			.map((s) -> s.getName() + " : " + (int)s.getChargeQuantity() + "리터" + NEWLINE)
			.forEach(answer::append);
		return answer.toString();
	}
}
