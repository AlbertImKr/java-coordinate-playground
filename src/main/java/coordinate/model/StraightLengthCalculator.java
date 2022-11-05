package coordinate.model;

import java.util.List;
import java.util.stream.Collectors;

class StraightLengthCalculator {
    public static final int SIZE = 2;
    private final List<CoordinatePoint> coordinatePoints;

    public StraightLengthCalculator(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints);
        this.coordinatePoints = coordinatePoints;
    }

    private void validate(List<CoordinatePoint> coordinatePoints) {
        if (coordinatePoints.size() != SIZE) {
            throw new IllegalArgumentException("좌표가 2개이여야 한다.");
        }
        List<CoordinatePoint> distinctCoordinatePoints = coordinatePoints.stream().distinct()
                .collect(Collectors.toList());
        if (!distinctCoordinatePoints.equals(coordinatePoints)) {
            throw new IllegalArgumentException("두 좌표가 서로 달아랴 한다.");
        }
    }

    public double reportResult() {
        CoordinatePoint coordinatePointA = coordinatePoints.get(0);
        CoordinatePoint coordinatePointB = coordinatePoints.get(1);
        return coordinatePointA.reportStraightLength(coordinatePointB);
    }
}
