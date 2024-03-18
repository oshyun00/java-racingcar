package controller;

import java.util.List;
import java.util.function.Supplier;
import model.Cars;
import model.Racing;
import model.dto.CarState;
import model.dto.Winner;
import model.powergenerator.RandomPowerGenerator;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = repeatUntilSuccess(this::prepareCars);
        Racing racing = repeatUntilSuccess(this::prepareRacing);
        play(racing, cars);
        end(racing, cars);
    }

    private Cars prepareCars() {
        List<String> carNames = inputView.askCarNames();
        return new Cars(carNames, new RandomPowerGenerator());
    }

    private Racing prepareRacing() {
        int tryCount = inputView.askTryCount();
        return new Racing(tryCount);
    }

    private void play(Racing racing, Cars cars) {
        outputView.printPlayResult();
        while (racing.canTry()) {
            racing.doTry(cars);
            List<CarState> carStates = cars.captureCarStates();
            outputView.printCapturedCarStates(carStates);
        }
    }

    private void end(Racing racing, Cars cars) {
        List<Winner> winners = racing.determineWinner(cars);
        outputView.printFinalResult(winners);
    }

    private <T> T repeatUntilSuccess(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatUntilSuccess(supplier);
        }
    }
}
