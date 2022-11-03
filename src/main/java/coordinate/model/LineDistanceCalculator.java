package coordinate.model;

import java.util.List;

public class LineDistanceCalculator {
    public double calculateTwoPointDistance(List<CoordinatePoint> points) {
        CoordinatePoint pointA = points.get(0);
        CoordinatePoint pointB = points.get(1);
        return Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
    }
}
