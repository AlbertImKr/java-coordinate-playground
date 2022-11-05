package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangularAreaCalculatorTest {


    CoordinatePoint coordinatePointA;
    CoordinatePoint coordinatePointB;
    CoordinatePoint coordinatePointC;

    @BeforeEach
    void setCoordinatePoints() {
        coordinatePointA = new CoordinatePoint(10, 15);
        coordinatePointB = new CoordinatePoint(15, 15);
        coordinatePointC = new CoordinatePoint(10, 20);
    }

    @Test
    void 삼각형_면적_구하기() {
        TriangularAreaCalculator triangularAreaCalculator = new TriangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC));
        assertThat(triangularAreaCalculator.reportResult()).isEqualTo(12.5);
    }
}
