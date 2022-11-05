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

        long countX = coordinatePoints.stream()
                .map(CoordinatePoint::getPointX)
                .distinct().count();

        long countY = coordinatePoints.stream()
                .map(CoordinatePoint::getPointY)
                .distinct().count();

        if (countX != 2 && countY != 2) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }
}
