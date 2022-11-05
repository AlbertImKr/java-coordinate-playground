package coordinate.controller;

import coordinate.inputview.OutputView;
import coordinate.model.Area;
import coordinate.model.CoordinatePoint;
import coordinate.model.RectangularAreaCalculator;
import coordinate.model.StraightLengthCalculator;
import coordinate.model.TriangularAreaCalculator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoordinatePointController {
    private Map<Integer, Function<List<CoordinatePoint>, Area>> map;

    public CoordinatePointController() {
        map = new HashMap<>();
        map.put(StraightLengthCalculator.SIZE, StraightLengthCalculator::new);
        map.put(TriangularAreaCalculator.SIZE, TriangularAreaCalculator::new);
        map.put(RectangularAreaCalculator.SIZE, RectangularAreaCalculator::new);
    }

    public void print(List<String> points) {
        List<CoordinatePoint> coordinatePoints = changeToPoint(points);
        double v = map.get(coordinatePoints.size()).apply(coordinatePoints).reportResult();
        OutputView.print(v, coordinatePoints);
    }

    private List<CoordinatePoint> changeToPoint(List<String> points) {
        return points.stream()
                .map(point -> point.substring(1, point.length() - 1))
                .map(point -> point.split(","))
                .map(point -> new CoordinatePoint(Integer.valueOf(point[0]), Integer.valueOf(point[1])))
                .collect(Collectors.toList());
    }
}
