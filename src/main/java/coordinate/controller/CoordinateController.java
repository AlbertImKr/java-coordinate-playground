package coordinate.controller;

import coordinate.model.CoordinateChecker;
import coordinate.model.CoordinatePoint;
import coordinate.model.CoordinateSolution;
import coordinate.model.Changer;
import coordinate.view.InputView;
import java.util.List;

public class CoordinateController {
    private InputView inputView = new InputView();
    private CoordinateChecker coordinateChecker = new CoordinateChecker();
    private Changer changer = new Changer();
    private CoordinateSolution coordinateSolution = new CoordinateSolution();
    private OutView outView = new OutView();
    void start(){
        String requestInput = inputView.requestInput();
        check(requestInput);
    }

    private void check(String requestInput) {
        try {
            if (!coordinateChecker.checkType(requestInput)) {
                throw new IllegalArgumentException("입력 타입이 맞지 않습니다.");
            }
            List<List<String>> CoordinateLists = changer.stringToList(requestInput);
            if (!CoordinateLists.stream().allMatch(coordinateChecker::checkRange)){
                throw new IllegalArgumentException("입력 범위을 넘었습니다.");
            }
            resolve(CoordinateLists);
        } catch (Exception e) {
            e.printStackTrace();
            start();
        }
    }

    private void resolve(List<List<String>> CoordinateLists) {
        List<CoordinatePoint> coordinatePoints = changer.stringToPoint(CoordinateLists);
        double result = coordinateSolution.judgement(coordinatePoints);
        if (result != -1) {
            outView.print(result);
        }
    }
}
