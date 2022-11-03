package coordinate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CoordinateCheckerTest {

    @Test
    void 좌표_타입_검사(){
        CoordinateChecker coordinateChecker = new CoordinateChecker();
        assertThat(coordinateChecker.checkType("(3'4),(3.4)")).isFalse();
        assertThat(coordinateChecker.checkType("(3#4),(2,4)")).isFalse();

        assertThat(coordinateChecker.checkType("(3,24)-(24,3)")).isTrue();
        assertThat(coordinateChecker.checkType("(25,24)-(2,3)")).isTrue();
    }
}
