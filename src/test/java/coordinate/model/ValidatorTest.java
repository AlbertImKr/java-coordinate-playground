package coordinate.model;

import static coordinate.model.Validator.REPEAT_ERROR;
import static coordinate.model.Validator.SIZE_ERROR_END;
import static coordinate.model.Validator.SIZE_ERROR_FRONT;
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
                IllegalArgumentException.class).hasMessage(SIZE_ERROR_FRONT+4+SIZE_ERROR_END);

        assertThatThrownBy(() -> new RectangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC, coordinatePointD,
                        new CoordinatePoint(1, 5)))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SIZE_ERROR_FRONT+4+SIZE_ERROR_END);

        assertThatCode(() -> new RectangularAreaCalculator(List.of(coordinatePointA, coordinatePointB, coordinatePointC,
                coordinatePointD))).doesNotThrowAnyException();
    }

    @Test
    void 좌표가_중복_확인한다() {
        assertThatThrownBy(() -> new RectangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointA, coordinatePointC))).isInstanceOf(
                IllegalArgumentException.class).hasMessage(REPEAT_ERROR);

        assertThatCode(() -> new RectangularAreaCalculator(List.of(coordinatePointA, coordinatePointB, coordinatePointC,
                coordinatePointD))).doesNotThrowAnyException();
    }
}
