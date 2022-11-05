package coordinate.controller;

import coordinate.model.Area;
import coordinate.model.CoordinatePoint;
import coordinate.model.StraightLengthCalculator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoordinatePointController {
    private Map<Integer, Function<List<CoordinatePoint>, Area>> map;

    public CoordinatePointController() {
        map = new HashMap<>();
        map.put(StraightLengthCalculator.SIZE, coordinatePoints -> new Area(coordinatePoints));
    }

    public void print(List<String> points) {
        List<CoordinatePoint> coordinatePoints = changeToPoint(points);

    }

    private List<CoordinatePoint> changeToPoint(List<String> points) {
        List<CoordinatePoint> collect = points.stream()
                .map(point -> point.substring(1, point.length() - 1))
                .map(point -> point.split(","))
                .map(point -> new CoordinatePoint(Integer.valueOf(point[0]), Integer.valueOf(point[1])))
                .collect(Collectors.toList());
    }
}
