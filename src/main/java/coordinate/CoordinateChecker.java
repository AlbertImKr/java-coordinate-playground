package coordinate;

public class CoordinateChecker {
    private final String pattern = "\\([0-9]{1,2},[0-9]{1,2}\\)(-\\([0-9]{1,2},[0-9]{1,2}\\)){0,1}";

    public boolean checkType(String coordinateString) {
        return coordinateString.matches(pattern);
    }
}
