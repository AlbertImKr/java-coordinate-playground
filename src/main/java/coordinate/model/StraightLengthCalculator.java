package coordinate.model;

import java.util.List;
import java.util.stream.Collectors;

class StraightLengthCalculator {
    public static final int SIZE = 2;
    public static final String REPEAT_ERROR = "중복된 좌표가 있습니다.";
    public static final String SIZE_ERRO = "좌표가 2개이여야 한다.";
    private final List<CoordinatePoint> coordinatePoints;

    public StraightLengthCalculator(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints);
        this.coordinatePoints = coordinatePoints;
    }

    private void validate(List<CoordinatePoint> coordinatePoints) {
        if (coordinatePoints.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_ERRO);
        }
        List<CoordinatePoint> distinctCoordinatePoints = coordinatePoints.stream().distinct()
                .collect(Collectors.toList());
        if (!distinctCoordinatePoints.equals(coordinatePoints)) {
            throw new IllegalArgumentException(REPEAT_ERROR);
        }
    }

    public double reportResult() {
        CoordinatePoint coordinatePointA = coordinatePoints.get(0);
        CoordinatePoint coordinatePointB = coordinatePoints.get(1);
        return coordinatePointA.reportStraightLength(coordinatePointB);
    }
}
