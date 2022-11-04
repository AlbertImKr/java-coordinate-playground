package coordinate.controller;

import coordinate.model.CoordinateChecker;
import coordinate.model.CoordinatePoint;
import coordinate.model.CoordinateSolution;
import coordinate.model.Changer;
import coordinate.view.InputView;
import java.util.Collections;
import java.util.List;

public class CoordinateController {
    private static final InputView inputView = new InputView();
    private final CoordinateChecker coordinateChecker = new CoordinateChecker();
    private final Changer changer = new Changer();
    private final CoordinateSolution coordinateSolution = new CoordinateSolution();
    private final OutView outView = new OutView();
    public void start(){
        String requestInput = inputView.requestInput();
        List<List<String>> coordinateLists = check(requestInput);
        if (coordinateLists.equals(Collections.emptyList())){
            start();
            return;
        }
        resolve(coordinateLists);
    }

    private List<List<String>> check(String requestInput) {

        requestInput = replaceBlank(requestInput);
        if (!coordinateChecker.checkType(requestInput)) {
            System.out.println("입력 타입이 맞지 않습니다.");
            return Collections.emptyList();
        }
        List<List<String>> coordinateLists = changer.stringToList(requestInput);
        if (!coordinateLists.stream().allMatch(coordinateChecker::checkRange)){
            System.out.println("입력 범위을 넘었습니다.");
            return Collections.emptyList();
        }
        return coordinateLists;

    }

    private String replaceBlank(String requestInput) {
        return requestInput.replaceAll(" ", "");
    }

    private void resolve(List<List<String>> CoordinateLists) {
        List<CoordinatePoint> coordinatePoints = changer.stringToPoint(CoordinateLists);
        double result = coordinateSolution.judgement(coordinatePoints);
        if (result != -1) {
            outView.print(result);
        }
    }
}
