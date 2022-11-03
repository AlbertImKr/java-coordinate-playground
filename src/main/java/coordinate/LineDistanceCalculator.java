package coordinate;

public class LineDistanceCalculator {
    public double calculateTwoPointDistance(CoordinatePoint pointA, CoordinatePoint pointB) {
        return Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
    }
}
