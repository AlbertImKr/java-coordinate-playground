package coordinate.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareAreaCalculatorTest {

    @Test
    void 사각형_면적_구한다(){
        SquareAreaCalculator squareAreaCalculator = new SquareAreaCalculator();
        CoordinatePoint coordinatePointA = new CoordinatePoint(10, 10);
        CoordinatePoint coordinatePointB = new CoordinatePoint(22, 10);
        CoordinatePoint coordinatePointC = new CoordinatePoint(22, 18);
        CoordinatePoint coordinatePointD = new CoordinatePoint(10, 18);
        Assertions.assertThat(squareAreaCalculator.calculate(
                        List.of(coordinatePointA, coordinatePointB, coordinatePointC, coordinatePointD)))
                .isEqualTo(96);
    }
}
