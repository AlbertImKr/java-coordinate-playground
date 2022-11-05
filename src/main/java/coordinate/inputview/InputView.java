package coordinate.inputview;

import coordinate.controller.CoordinatePointController;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String START_STRING = "좌표를 입력하세요.";

    void requestInput() {
        System.out.println(START_STRING);
        String inputs = scanner.nextLine();
        inputs = inputs.replaceAll(" ", "");
        try {
            InputViewValidator.validatePointsType(inputs);
            List<String> points = Arrays.stream(inputs.split("-")).collect(Collectors.toList());
            points.stream()
                    .forEach(InputViewValidator::validatePointType);
            CoordinatePointController coordinatePointController = new CoordinatePointController();
            coordinatePointController.print(points);
        } catch (Exception e) {
            e.printStackTrace();
            requestInput();
        }
    }
}
