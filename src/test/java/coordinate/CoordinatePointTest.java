package coordinate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CoordinatePointTest {

    @Test
    void equals() {
        CoordinatePoint coordinatePoint = new CoordinatePoint(1, 4);
        assertThat(coordinatePoint).isEqualTo(new CoordinatePoint(1, 4));
        assertThat(coordinatePoint).isNotEqualTo(new CoordinatePoint(1, 3));
    }

    @Test
    void 좌표_범위_초과시(){
        assertThatThrownBy(() -> new CoordinatePoint(0, 24)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 0이상 24이하여야 합니다.");
        assertThatThrownBy(() -> new CoordinatePoint(1, 25)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 0이상 24이하여야 합니다.");
        assertThatThrownBy(() -> new CoordinatePoint(25, 1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 0이상 24이하여야 합니다.");
        assertThatThrownBy(() -> new CoordinatePoint(25, 0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 0이상 24이하여야 합니다.");
        assertThatCode(() -> new CoordinatePoint(1, 24)).doesNotThrowAnyException();
    }
}
