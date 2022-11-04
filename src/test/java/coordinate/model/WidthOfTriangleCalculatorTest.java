package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WidthOfTriangleCalculatorTest {

    @Test
    void 삼각형_넓이_구하기() {
        CoordinatePoint coordinatePointA = new CoordinatePoint(10, 10);
        CoordinatePoint coordinatePointB = new CoordinatePoint(15, 10);
        CoordinatePoint coordinatePointC = new CoordinatePoint(10, 15);

        assertThat(WidthOfTriangleCalculator.calculate(List.of(coordinatePointA, coordinatePointB, coordinatePointC)))
                .isEqualTo(12.5);
    }
}
