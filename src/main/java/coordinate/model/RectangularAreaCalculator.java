package coordinate.model;

import static java.util.stream.Collectors.toList;

import java.util.List;

class RectangularAreaCalculator {

    public static final int SIZE = 4;
    public static final String SIZE_ERROR = "좌표의 수가 4개이여야 한다.";
    public static final String REPEAT_ERROR = "중복된 좌표가 있습니다.";
    public static final String TYPE_ERROR = "직사각형이 아닙니다.";

    public RectangularAreaCalculator(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints);
    }

    private void validate(List<CoordinatePoint> coordinatePoints) {
        validateSize(coordinatePoints);
        validateRepeat(coordinatePoints);
        validateType(coordinatePoints);
    }

    private static void validateRepeat(List<CoordinatePoint> coordinatePoints) {
        List<CoordinatePoint> distinctCoordinatePoints = coordinatePoints.stream()
                .distinct()
                .collect(toList());
        validate(!distinctCoordinatePoints.equals(coordinatePoints), REPEAT_ERROR);
    }

    private static void validateSize(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints.size() != SIZE, SIZE_ERROR);
    }

    private static void validateType(List<CoordinatePoint> coordinatePoints) {
        long countX = coordinatePoints.stream()
                .map(CoordinatePoint::getPointX)
                .distinct().count();

        long countY = coordinatePoints.stream()
                .map(CoordinatePoint::getPointY)
                .distinct().count();

        validate(countX != 2 && countY != 2, TYPE_ERROR);
    }

    private static void validate(boolean coordinatePoints, String errorMessage) {
        if (coordinatePoints) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
