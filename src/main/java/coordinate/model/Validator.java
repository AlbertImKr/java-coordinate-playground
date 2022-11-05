package coordinate.model;

import static java.util.stream.Collectors.toList;

import java.util.List;

class Validator {
    public static final String SIZE_ERROR_FRONT = "좌표의 수가 ";
    public static final String SIZE_ERROR_END = "개이여야 한다.";
    public static final String REPEAT_ERROR = "중복된 좌표가 있습니다.";

    static void validate(List<CoordinatePoint> coordinatePoints, int size) {
        validateSize(coordinatePoints, size);
        validateRepeat(coordinatePoints);
    }

    private static void validateRepeat(List<CoordinatePoint> coordinatePoints) {
        List<CoordinatePoint> distinctCoordinatePoints = coordinatePoints.stream()
                .distinct()
                .collect(toList());
        validate(!distinctCoordinatePoints.equals(coordinatePoints), REPEAT_ERROR);
    }

    private static void validateSize(List<CoordinatePoint> coordinatePoints, int size) {
        validate(coordinatePoints.size() != size, SIZE_ERROR_FRONT + size + SIZE_ERROR_END);
    }


    static void validate(boolean coordinatePoints, String errorMessage) {
        if (coordinatePoints) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
