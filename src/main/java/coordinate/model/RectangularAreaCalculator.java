package coordinate.model;

import static java.util.stream.Collectors.toList;

import java.util.List;

class RectangularAreaCalculator {

    public static final int SIZE = 4;

    public RectangularAreaCalculator(List<CoordinatePoint> coordinatePoints) {
        validate(coordinatePoints);
    }

    private void validate(List<CoordinatePoint> coordinatePoints) {
        if (coordinatePoints.size() != SIZE) {
            throw new IllegalArgumentException("좌표의 수가 4개이여야 한다.");
        }
        List<CoordinatePoint> distinctCoordinatePoints = coordinatePoints.stream()
                .distinct()
                .collect(toList());
        if (!distinctCoordinatePoints.equals(coordinatePoints)) {
            throw new IllegalArgumentException("중복된 좌표가 있습니다.");
        }
    }
}
