package coordinate.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class StraightLengthCalculatorTest {

    @Test
    void 두좌표가_서로_달아야_한다() {
        CoordinatePoint coordinatePointA = new CoordinatePoint(2, 3);
        assertThatThrownBy(() -> new StraightLengthCalculator(List.of(coordinatePointA, coordinatePointA)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("두 좌표가 서로 달아랴 한다.");

        CoordinatePoint coordinatePointB = new CoordinatePoint(3, 2);
        assertThatCode(() -> new StraightLengthCalculator(List.of(coordinatePointA, coordinatePointB)))
                .doesNotThrowAnyException();
    }
}
