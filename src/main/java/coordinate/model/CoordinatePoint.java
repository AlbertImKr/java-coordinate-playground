package coordinate.model;

public class CoordinatePoint {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 24;
    public static final String Range_ERROR = "좌표는 1이상 24이하인 수여야 합니다.";
    private final int pointX;
    private final int pointY;

    public CoordinatePoint(int pointX, int pointY) {
        validate(pointX);
        validate(pointY);
        this.pointX = pointX;
        this.pointY = pointY;
    }

    private void validate(int pointSingleValue) {
        validateRange(pointSingleValue);
    }

    private static void validateRange(int pointSingleValue) {
        if (pointSingleValue < MIN_VALUE || pointSingleValue > MAX_VALUE) {
            throw new IllegalArgumentException(Range_ERROR);
        }
    }

    public double reportStraightLength(CoordinatePoint coordinatePointB) {
        return coordinatePointB.reportStraightLength(pointX,pointY);
    }

    private double reportStraightLength(int otherPointX, int otherPointY) {
        return Math.sqrt(Math.pow(pointX - otherPointX, 2) + Math.pow(pointY - otherPointY, 2));
    }

    public boolean isSameX(CoordinatePoint otherCoordinatePoint) {
        return pointX == otherCoordinatePoint.pointX;
    }


    public boolean isSameY(CoordinatePoint otherCoordinatePoint) {
        return pointY == otherCoordinatePoint.pointY;
    }


    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CoordinatePoint)) {
            return false;
        }

        CoordinatePoint that = (CoordinatePoint) o;

        if (pointX != that.pointX) {
            return false;
        }
        return pointY == that.pointY;
    }

    @Override
    public int hashCode() {
        int result = pointX;
        result = 31 * result + pointY;
        return result;
    }
}
