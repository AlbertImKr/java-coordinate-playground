package coordinate.model;

import static java.util.stream.Collectors.toList;

import java.util.List;

class RectangularAreaCalculator {

    public static final int SIZE = 4;
    public static final String SIZE_ERROR = "좌표의 수가 4개이여야 한다.";
    public static final String REPEAT_ERROR = "중복된 좌표가 있습니다.";
    public static final String TYPE_ERROR = "직사각형이 아닙니다.";
    public static final int POINT_COUNT = 2;
    public static final int START_NUMBER = 0;
    public static final int FIRST_NUMBER = 0;
    public static final int SECOND_NUMBER = 1;
    private final List<CoordinatePoint> rectangularCoordinatePoints;

    public RectangularAreaCalculator(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints);
        this.rectangularCoordinatePoints = coordinatePoints;
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

        validate(countX != POINT_COUNT && countY != POINT_COUNT, TYPE_ERROR);
    }

    private static void validate(boolean coordinatePoints, String errorMessage) {
        if (coordinatePoints) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public double reportResult() {
        CoordinatePoint coordinatePointA = rectangularCoordinatePoints.get(START_NUMBER);
        List<CoordinatePoint> otherCoordinatePoint = findAdjacentPoint(coordinatePointA);

        StraightLengthCalculator straightLengthCalculatorA = new StraightLengthCalculator(List.of(coordinatePointA,
                otherCoordinatePoint.get(FIRST_NUMBER)));
        StraightLengthCalculator straightLengthCalculatorB = new StraightLengthCalculator(List.of(coordinatePointA,
                otherCoordinatePoint.get(SECOND_NUMBER)));

        return straightLengthCalculatorA.reportResult() * straightLengthCalculatorB.reportResult();
    }

    private List<CoordinatePoint> findAdjacentPoint(CoordinatePoint coordinatePoint) {
        return rectangularCoordinatePoints.stream()
                .filter(point -> point != coordinatePoint)
                .filter(point -> point.getPointX() == coordinatePoint.getPointX() ||
                        point.getPointY() == coordinatePoint.getPointY())
                .collect(toList());
    }
}
