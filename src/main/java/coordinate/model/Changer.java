package coordinate.model;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Changer {
    public List<List<String>> stringToList(String requestInput) {
        String[] splitCoordinate = splitCoordinate(requestInput);
        return Arrays.stream(splitCoordinate)
                .map(v -> v.replaceAll(" ", ""))
                .map(v -> v.replaceAll("\\(", ""))
                .map(v -> v.replaceAll("\\)", ""))
                .map(v -> v.split(","))
                .map(arr -> Arrays.stream(arr).collect(toList()))
                .collect(toList());
    }

    private static String[] splitCoordinate(String requestInput) {
        return requestInput.split("-");
    }

    public List<CoordinatePoint> stringToPoint(List<List<String>> lists) {
        return lists.stream()
                .map(list -> new CoordinatePoint(Integer.valueOf(list.get(0)), Integer.valueOf(list.get(1))))
                .collect(toList());
    }

}
