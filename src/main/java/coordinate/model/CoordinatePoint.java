package coordinate.model;

public class CoordinatePoint {
    private final int x;
    private final int y;

    public CoordinatePoint(int x, int y) {

        if (!validate(x, y)) {
            throw new IllegalArgumentException("좌표는 0이상 24이하여야 합니다.");
        }

        this.x = x;
        this.y = y;
    }

    private boolean validate(int x, int y) {
        return x > 0 && x <= 24 && y > 0 && y <= 24;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

        if (x != that.x) {
            return false;
        }
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
