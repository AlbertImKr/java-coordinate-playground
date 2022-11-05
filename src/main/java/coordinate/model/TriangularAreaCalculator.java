package coordinate.model;

import static java.util.stream.Collectors.*;

import java.util.List;

class TriangularAreaCalculator {

    public static final int SIZE = 3;
    public static final String SIZE_ERROR = "좌표가 3개이여야 합니다.";
    public static final String REPEAT_ERROR = "중복된 좌표가 있습니다.";
    public static final int FIRST_POINT_INDEX = 0;
    public static final int SECOND_POINT_INDEX = 1;
    public static final int THIRD_POINT_INDEX = 2;
    private final List<CoordinatePoint> triangularCoordinatePoints;

    public TriangularAreaCalculator(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints);
        this.triangularCoordinatePoints = coordinatePoints;
    }

    private void validate(List<CoordinatePoint> coordinatePoints) {
        validateRange(coordinatePoints);
        validateRepeat(coordinatePoints);
    }

    private static void validateRepeat(List<CoordinatePoint> coordinatePoints) {
        List<CoordinatePoint> distinctCoordinatePoints = coordinatePoints.stream().distinct().collect(toList());
        if (!distinctCoordinatePoints.equals(coordinatePoints)){
            throw new IllegalArgumentException(REPEAT_ERROR);
        }
    }

    private static void validateRange(List<CoordinatePoint> coordinatePoints) {
        if (coordinatePoints.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    public double reportResult() {
        CoordinatePoint firstCoordinatePoint = triangularCoordinatePoints.get(FIRST_POINT_INDEX);
        CoordinatePoint secondCoordinatePoint = triangularCoordinatePoints.get(SECOND_POINT_INDEX);
        CoordinatePoint thirdCoordinatePoint = triangularCoordinatePoints.get(THIRD_POINT_INDEX);

        StraightLengthCalculator line1Calculator = new StraightLengthCalculator(
                List.of(firstCoordinatePoint, secondCoordinatePoint));
        StraightLengthCalculator line2Calculator = new StraightLengthCalculator(
                List.of(thirdCoordinatePoint, secondCoordinatePoint));
        StraightLengthCalculator line3Calculator = new StraightLengthCalculator(
                List.of(firstCoordinatePoint, thirdCoordinatePoint));

        double line1 = line1Calculator.reportResult();
        double line2 = line2Calculator.reportResult();
        double line3 = line3Calculator.reportResult();

        double halfSum = (line1 + line2 + line3) / 2;
        return Math.sqrt(halfSum * (halfSum - line1) * (halfSum - line2) * (halfSum - line3));
    }
}
