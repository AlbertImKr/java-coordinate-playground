package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WidthOfTriangleCalculatorTest {

    @Test
    void 삼각형면적_구하기() {
        WidthOfTriangleCalculator widthOfTriangleCalculator = new WidthOfTriangleCalculator();
        CoordinatePoint coordinatePointA = new CoordinatePoint(10, 10);
        CoordinatePoint coordinatePointB = new CoordinatePoint(14, 10);
        CoordinatePoint coordinatePointC = new CoordinatePoint(20, 8);

        assertThat(widthOfTriangleCalculator.calculate(List.of(coordinatePointA, coordinatePointB, coordinatePointC)))
                .isEqualTo(29);
    }
}
