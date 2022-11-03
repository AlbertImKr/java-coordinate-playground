package coordinate;

import java.util.List;

public class CoordinateChecker {
    public static final int MAX_VALUE = 24;
    public static final int MIN_VALUE = 1;
    private final String pattern = "\\([0-9]{1,2},[0-9]{1,2}\\)(-\\([0-9]{1,2},[0-9]{1,2}\\)){0,1}";

    public boolean checkType(String coordinateString) {
        return coordinateString.matches(pattern);
    }

    public boolean checkRange(List<Integer> list) {
        return list.stream()
                .allMatch(value -> value >= MIN_VALUE && value <= MAX_VALUE);
    }
}
