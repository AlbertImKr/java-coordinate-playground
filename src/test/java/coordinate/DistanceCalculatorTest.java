package coordinate;

import static org.assertj.core.api.Assertions.*;

import java.awt.*;

import org.junit.jupiter.api.Test;

public class DistanceCalculatorTest {

	@Test
	void calculate_two_point_distance() {
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		Point pointA = new Point(1, 2);
		Point pointB = new Point(3, 4);

		assertThat(distanceCalculator.calculateTwoPointDistance(pointA, pointB))
			.isEqualTo(2.8284,offset(0.000099));
	}
}
