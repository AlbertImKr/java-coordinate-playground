package coordinate.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CoordinatePointTest {

    @Test
    void 좌표의_값에_대한_제한() {
        assertThatThrownBy(() -> new CoordinatePoint(25, 1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 1이상 24이하인 수여야 합니다.");
        assertThatThrownBy(() -> new CoordinatePoint(0, 24)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 1이상 24이하인 수여야 합니다.");
        assertThatCode(() -> new CoordinatePoint(1, 24)).doesNotThrowAnyException();
    }
}
