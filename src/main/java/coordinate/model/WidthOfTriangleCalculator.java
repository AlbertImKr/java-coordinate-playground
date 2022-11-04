package coordinate.model;

import java.util.List;

public class WidthOfTriangleCalculator {
    public static double calculate(List<CoordinatePoint> coordinatePoints) {
        CoordinatePoint coordinatePointA = coordinatePoints.get(0);
        CoordinatePoint coordinatePointB = coordinatePoints.get(1);
        CoordinatePoint coordinatePointC = coordinatePoints.get(2);

        LineDistanceCalculator lineDistanceCalculator = new LineDistanceCalculator();
        double line1 = lineDistanceCalculator.calculateTwoPointDistance(List.of(coordinatePointA, coordinatePointB));
        double line2 = lineDistanceCalculator.calculateTwoPointDistance(List.of(coordinatePointA, coordinatePointC));
        double line3 = lineDistanceCalculator.calculateTwoPointDistance(List.of(coordinatePointB, coordinatePointC));

        double s = (line1 + line2 + line3) / 2;
        return Math.sqrt(s * (s - line1) * (s - line2) * (s - line3));

    }
}
