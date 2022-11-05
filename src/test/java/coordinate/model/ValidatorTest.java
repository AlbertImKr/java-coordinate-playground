package coordinate.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {

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
    void 좌표_수량_유효성() {
        assertThatThrownBy(() -> new RectangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC))).isInstanceOf(
                IllegalArgumentException.class).hasMessage("좌표의 수가 4개이여야 한다.");

        assertThatThrownBy(() -> new RectangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC, coordinatePointD,
                        new CoordinatePoint(1, 5)))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표의 수가 4개이여야 한다.");

        assertThatCode(() -> new RectangularAreaCalculator(List.of(coordinatePointA, coordinatePointB, coordinatePointC,
                coordinatePointD))).doesNotThrowAnyException();
    }

    @Test
    void 좌표가_중복_확인한다() {
        assertThatThrownBy(() -> new RectangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointA, coordinatePointC))).isInstanceOf(
                IllegalArgumentException.class).hasMessage("중복된 좌표가 있습니다.");

        assertThatCode(() -> new RectangularAreaCalculator(List.of(coordinatePointA, coordinatePointB, coordinatePointC,
                coordinatePointD))).doesNotThrowAnyException();
    }
}
