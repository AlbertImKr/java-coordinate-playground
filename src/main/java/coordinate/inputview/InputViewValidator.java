package coordinate.inputview;

import java.util.regex.Pattern;

class InputViewValidator {
    private static final Pattern pointType = Pattern.compile("\\([0-9]{1,2},[0-9]{1,2}\\)");
    private static final Pattern pointsType = Pattern.compile(
            "\\([0-9]{1,2},[0-9]{1,2}\\)" + "(-\\([0-9]{1,2},[0-9]{1,2}\\)){0,3}");

    public static void validatePointType(String inputpoint) {
        if (!pointType.matcher(inputpoint).matches()) {
            throw new IllegalArgumentException("입력한 좌표타입이 맞지 않습니다. 다시 입력해주세요.");
        }
    }

    public static void validatePointsType(String inputs) {
        if (!pointsType.matcher(inputs).matches()) {
            throw new IllegalArgumentException("입력한 좌표연결표시가 맞지 않습니다. 다시 입력해주세요.");
        }
    }
}
