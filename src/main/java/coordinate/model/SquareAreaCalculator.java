package coordinate.model;

import java.util.List;

public class SquareAreaCalculator {
    private static final LineDistanceCalculator lineDistanceCalculator = new LineDistanceCalculator();

    public static double calculate(List<CoordinatePoint> coordinatePoints) {
        int x1 = coordinatePoints.get(0).getX();
        int x2 = coordinatePoints.stream()
                .map(CoordinatePoint::getX)
                .filter(v -> !v.equals(x1))
                .findFirst().get();
        int y1 = coordinatePoints.get(0).getY();
        int y2 = coordinatePoints.stream()
                .map(CoordinatePoint::getY)
                .filter(v -> !v.equals(x1))
                .findFirst().get();
        CoordinatePoint pointA = new CoordinatePoint(x1, y1);
        CoordinatePoint pointB = new CoordinatePoint(x1, y2);
        CoordinatePoint pointC = new CoordinatePoint(x2, y1);
        return lineDistanceCalculator.calculateTwoPointDistance(List.of(pointA, pointB))
                * lineDistanceCalculator.calculateTwoPointDistance(List.of(pointA, pointC));
    }
}
