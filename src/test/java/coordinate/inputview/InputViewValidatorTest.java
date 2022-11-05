package coordinate.inputview;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputViewValidatorTest {

    @Test
    void point_input_type() {
        assertThatThrownBy(() -> InputViewValidator.validatePointType("(.2.3)")).isInstanceOf(
                        IllegalArgumentException.class).hasMessage("입력한 좌표타입이 맞지 않습니다. 다시 입력해주세요.");

        assertThatCode(() -> InputViewValidator.validatePointType("(2,3)")).doesNotThrowAnyException();
    }

    @Test
    void points_input_type(){
        assertThatThrownBy(() -> InputViewValidator.validatePointsType("(2,3)(4,5)")).isInstanceOf(
                IllegalArgumentException.class).hasMessage("입력한 좌표연결표시가 맞지 않습니다. 다시 입력해주세요.");


        assertThatCode(() -> InputViewValidator.validatePointsType("(2,3)-(4,5)")).doesNotThrowAnyException();

        assertThatCode(() -> InputViewValidator.validatePointsType("(2,3)-(4,5)-(5,6)")).doesNotThrowAnyException();


        assertThatCode(() -> InputViewValidator.validatePointsType("(2,3)-(4,5)-(5,6)-(7,8)")).doesNotThrowAnyException();
    }
}
