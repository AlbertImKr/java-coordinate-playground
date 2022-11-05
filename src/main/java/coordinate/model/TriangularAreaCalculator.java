package coordinate.model;

import java.util.List;

class TriangularAreaCalculator {

    public static final int SIZE = 3;
    public static final String SIZE_ERROR = "좌표가 3개이여야 합니다.";

    public TriangularAreaCalculator(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints);
    }

    private void validate(List<CoordinatePoint> coordinatePoints) {
        if (coordinatePoints.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }
}
