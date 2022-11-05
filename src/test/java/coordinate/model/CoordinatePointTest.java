package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

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

    @Test
    void 같은_좌표를_가지면_같아야_한다() {
        assertThat(new CoordinatePoint(1, 3)).isEqualTo(new CoordinatePoint(1, 3));
        assertThat(new CoordinatePoint(2, 3)).isEqualTo(new CoordinatePoint(2, 3));
    }

    @Test
    void 다른_좌표와_직선거리_계산(){
        CoordinatePoint coordinatePointA = new CoordinatePoint(14, 15);
        CoordinatePoint coordinatePointB = new CoordinatePoint(14, 10);
        assertThat(coordinatePointA.reportStraightLength(coordinatePointB)).isEqualTo(5);

        CoordinatePoint coordinatePointC = new CoordinatePoint(10, 10);
        assertThat(coordinatePointA.reportStraightLength(coordinatePointC))
                .isEqualTo(6.403124,offset(0.00000099));
    }
}
