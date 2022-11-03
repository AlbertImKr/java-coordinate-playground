package coordinate.model;

import java.util.List;

public class CoordinateSolution {
    LineDistanceCalculator lineDistanceCalculator = new LineDistanceCalculator();
    public double judgement(List<CoordinatePoint> coordinateLists) {
        if (coordinateLists.size() == 2) {
            double v = lineDistanceCalculator.calculateTwoPointDistance(coordinateLists);
            return v;
        }
        return -1;
    }
}
