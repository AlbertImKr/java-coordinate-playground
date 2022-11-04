package coordinate.model;

import java.util.List;

public class CoordinateSolution {
    LineDistanceCalculator lineDistanceCalculator = new LineDistanceCalculator();
    public double judgement(List<CoordinatePoint> coordinateLists) {
        if (coordinateLists.size() == 2) {
            return lineDistanceCalculator.calculateTwoPointDistance(coordinateLists);
        }
        if (coordinateLists.size() == 3){
            return WidthOfTriangleCalculator.calculate(coordinateLists);
        }
        if (coordinateLists.size() == 4){
            return SquareAreaCalculator.calculate(coordinateLists);
        }
        return -1;
    }
}
