package coordinate.model;

import java.util.List;
import java.util.stream.Collectors;

class StraightLengthCalculator {
    public StraightLengthCalculator(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints);

    }

    private void validate(List<CoordinatePoint> coordinatePoints) {
        List<CoordinatePoint> distinctCoordinatePoints = coordinatePoints.stream().distinct().collect(Collectors.toList());
        if (!distinctCoordinatePoints.equals(coordinatePoints)) {
            throw new IllegalArgumentException("두 좌표가 서로 달아랴 한다.");
        }
    }
}
