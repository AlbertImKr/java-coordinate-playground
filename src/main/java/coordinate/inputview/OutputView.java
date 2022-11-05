package coordinate.inputview;

import coordinate.model.CoordinatePoint;
import java.util.List;

public class OutputView {

    public static final String FOUR_BLANK = "    ";
    public static final String TWO_BLANK = "  ";
    public static final String ONE_BLANK = " ";
    public static final String POINT = ". ";
    public static final String PLUS = "+";

    public static void print(double v, List<CoordinatePoint> coordinatePoints) {
        for (int y = 24; y > 0; y--) {
            printHead(y);
            System.out.print("|");
            printPoint(coordinatePoints, y);
        }
        printFloor();
        System.out.println(v);
    }

    private static void printFloor() {
        System.out.print(FOUR_BLANK);
        System.out.print(PLUS);
        System.out.println("--".repeat(24));
        System.out.printf("%4d", 0);
        System.out.print(ONE_BLANK);
        for (int x = 1; x <= 24; x++) {
            if (x % 2 == 0) {
                System.out.printf("%2d", x);
                continue;
            }
            System.out.print(TWO_BLANK);
        }
        System.out.println();
    }

    private static void printPoint(List<CoordinatePoint> coordinatePoints, int y) {
        for (int x = 1; x <= 24; x++) {
            if (coordinatePoints.contains(new CoordinatePoint(x, y))) {
                System.out.print(POINT);
                continue;
            }
            System.out.print(TWO_BLANK);
        }
        System.out.println();
    }

    private static void printHead(int y) {
        if (y % 2 == 0) {
            System.out.printf("%4d", y);
            return;
        }
        System.out.print(FOUR_BLANK);
    }
}
