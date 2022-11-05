package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StraightLengthCalculatorTest {

    CoordinatePoint coordinatePointA;
    CoordinatePoint coordinatePointB;
    List<CoordinatePoint> coordinatePoints = new ArrayList<>();

    @BeforeEach
    void setCoordinatePoints() {
        coordinatePointA = new CoordinatePoint(10, 10);
        coordinatePointB = new CoordinatePoint(2, 10);
        coordinatePoints.add(coordinatePointA);
        coordinatePoints.add(coordinatePointB);
    }

    @Test
    void 두좌표_사이의_직선거리를_구한다() {
        StraightLengthCalculator straightLengthCalculatorA =
                new StraightLengthCalculator(coordinatePoints);
        assertThat(straightLengthCalculatorA.reportResult()).isEqualTo(8);

        StraightLengthCalculator straightLengthCalculatorB =
                new StraightLengthCalculator(List.of(coordinatePointA, new CoordinatePoint(14, 15)));
        assertThat(straightLengthCalculatorB.reportResult()).isEqualTo(6.403124, offset(0.00000099));
    }
}
