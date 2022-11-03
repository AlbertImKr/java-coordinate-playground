package coordinate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.Test;

public class LineDistanceCalculatorTest {

    @Test
    void calculate_two_point_distance() {
        LineDistanceCalculator lineDistanceCalculator = new LineDistanceCalculator();
        CoordinatePoint coordinatePointA = new CoordinatePoint(1, 2);
        CoordinatePoint coordinatePointB = new CoordinatePoint(3, 4);

        assertThat(lineDistanceCalculator.calculateTwoPointDistance(coordinatePointA, coordinatePointB))
                .isEqualTo(2.8284, offset(0.000099));
    }
}
