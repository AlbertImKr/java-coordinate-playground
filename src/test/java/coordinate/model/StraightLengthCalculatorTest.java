package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void setCoordinatePoints(){
        coordinatePointA = new CoordinatePoint(10, 10);
        coordinatePointB = new CoordinatePoint(2, 10);
        coordinatePoints.add(coordinatePointA);
        coordinatePoints.add(coordinatePointB);
    }

    @Test
    void 두좌표가_서로_달아야_한다() {
        assertThatThrownBy(() -> new StraightLengthCalculator(List.of(coordinatePointA, coordinatePointA)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("두 좌표가 서로 달아랴 한다.");

        assertThatCode(() -> new StraightLengthCalculator(coordinatePoints))
                .doesNotThrowAnyException();
    }

    @Test
    void 두좌표_사이의_직선거리를_구한다() {
        StraightLengthCalculator straightLengthCalculatorA =
                new StraightLengthCalculator(coordinatePoints);
        assertThat(straightLengthCalculatorA.reportResult()).isEqualTo(8);

        StraightLengthCalculator straightLengthCalculatorB =
                new StraightLengthCalculator(List.of(coordinatePointA,new CoordinatePoint(14,15)));
        assertThat(straightLengthCalculatorB.reportResult()).isEqualTo(6.403124,offset(0.00000099));
    }
}
