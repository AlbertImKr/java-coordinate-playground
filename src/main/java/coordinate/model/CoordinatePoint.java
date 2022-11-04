package coordinate.model;

class CoordinatePoint {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 24;
    private final int pointX;
    private final int pointY;

    public CoordinatePoint(int pointX, int pointY) {
        validate(pointX);
        validate(pointY);
        this.pointX = pointX;
        this.pointY = pointY;
    }

    private void validate(int pointSingleValue) {
        if (pointSingleValue < MIN_VALUE || pointSingleValue > MAX_VALUE) {
            throw new IllegalArgumentException("좌표는 1이상 24이하인 수여야 합니다.");
        }
    }
}
