package coordinate.model;

import java.util.List;

public class CoordinateChecker {
    public static final int MAX_VALUE = 24;
    public static final int MIN_VALUE = 1;
    private final String pattern = "\\([0-9]{1,2},[0-9]{1,2}\\)(-\\([0-9]{1,2},[0-9]{1,2}\\)){0,5}";

    public boolean checkType(String coordinateString) {
        return coordinateString.matches(pattern);
    }

    public boolean checkRange(List<String> list) {
        return list.stream()
                .map(Integer::valueOf)
                .allMatch(value -> value >= MIN_VALUE && value <= MAX_VALUE);
    }
}
