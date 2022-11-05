package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 삼점_인지_확인() {
        assertThatThrownBy(() -> new TriangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC, new CoordinatePoint(4, 5))))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("좌표가 3개이여야 합니다.");

        assertThatThrownBy(() -> new TriangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("좌표가 3개이여야 합니다.");

        assertThatCode(() -> new TriangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC))).doesNotThrowAnyException();

    }

    @Test
    void 중복_점_확인(){
        assertThatThrownBy(() -> new TriangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB,coordinatePointB)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("중복된 좌표가 있습니다.");

        assertThatCode(() -> new TriangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC))).doesNotThrowAnyException();
    }

    @Test
    void 삼각형_면적_구하기(){
        TriangularAreaCalculator triangularAreaCalculator = new TriangularAreaCalculator(
                List.of(coordinatePointA, coordinatePointB, coordinatePointC));
        assertThat(triangularAreaCalculator.reportResult()).isEqualTo(12.5);
    }
}
