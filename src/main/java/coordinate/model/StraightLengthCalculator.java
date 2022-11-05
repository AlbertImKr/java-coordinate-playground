package coordinate.model;

import java.util.List;

public class StraightLengthCalculator implements Area {
    public static final int SIZE = 2;
    private final List<CoordinatePoint> coordinatePoints;

    public StraightLengthCalculator(List<CoordinatePoint> coordinatePoints) {
        Validator.validate(coordinatePoints, SIZE);
        this.coordinatePoints = coordinatePoints;
    }

    public double reportResult() {
        CoordinatePoint coordinatePointA = coordinatePoints.get(0);
        CoordinatePoint coordinatePointB = coordinatePoints.get(1);
        return coordinatePointA.reportStraightLength(coordinatePointB);
    }
}
