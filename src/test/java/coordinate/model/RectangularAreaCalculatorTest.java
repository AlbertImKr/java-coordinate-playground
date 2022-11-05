package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectangularAreaCalculatorTest {

    CoordinatePoint coordinatePointA;
    CoordinatePoint coordinatePointB;
    CoordinatePoint coordinatePointC;
    CoordinatePoint coordinatePointD;

    @BeforeEach
    void setCoordinatePoints() {
        coordinatePointA = new CoordinatePoint(10, 15);
        coordinatePointB = new CoordinatePoint(15, 15);
        coordinatePointC = new CoordinatePoint(10, 20);
        coordinatePointD = new CoordinatePoint(15, 20);
    }

    @Test
    void 직사각형인지_확인() {
        assertThatThrownBy(() -> new RectangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC, new CoordinatePoint(3, 4))))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("직사각형이 아닙니다.");
    }

    @Test
    void 직사각형_면적() {
        RectangularAreaCalculator rectangularAreaCalculator = new RectangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC, coordinatePointD));
        assertThat(rectangularAreaCalculator.reportResult()).isEqualTo(25);
    }
}
