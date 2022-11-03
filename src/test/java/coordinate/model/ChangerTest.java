package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ChangerTest {

    @Test
    void 문자열을_숫자_리스트로_변환() {
        Changer changer = new Changer();
        assertThat(changer.stringToList("(3,4 )"))
                .isEqualTo(List.of(List.of("3", "4")));
        assertThat(changer.stringToList("(3,4 )-(5,6)"))
                .isEqualTo(List.of(List.of("3", "4"), List.of("5", "6")));
    }


    @Test
    void 문자로된_리스트를_point_리스트로_변환() {
        Changer changer = new Changer();
        assertThat(changer.stringToPoint(List.of(List.of("3", "4"))))
                .isEqualTo(List.of(new CoordinatePoint(3, 4)));
        assertThat(changer.stringToPoint(List.of(List.of("3", "4"), List.of("5", "6"))))
                .isEqualTo(List.of(new CoordinatePoint(3, 4), new CoordinatePoint(5, 6)));
    }
}
