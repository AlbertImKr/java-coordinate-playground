package coordinate.model;

import java.util.List;

class TriangularAreaCalculator implements Area {

    public static final int SIZE = 3;
    public static final int FIRST_POINT_INDEX = 0;
    public static final int SECOND_POINT_INDEX = 1;
    public static final int THIRD_POINT_INDEX = 2;
    private final List<CoordinatePoint> triangularCoordinatePoints;

    public TriangularAreaCalculator(List<CoordinatePoint> coordinatePoints) {
        Validator.validate(coordinatePoints, SIZE);
        this.triangularCoordinatePoints = coordinatePoints;
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
