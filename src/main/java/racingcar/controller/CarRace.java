package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.service.RaceJudge;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRace {

    private final RaceJudge raceJudge;
    private final CarFactory carFactory;
    private final InputView inputView;
    private final OutputView outputView;

    public CarRace(RaceJudge raceJudge, CarFactory carFactory, OutputView outputView, InputView inputView) {
        this.raceJudge = raceJudge;
        this.carFactory = carFactory;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.requestNames();
        String namesInput = inputView.inputString();
        List<Car> cars = carFactory.createCars(namesInput);
        raceJudge.registerAllCars(cars);

        outputView.requestCount();
        String tryInput = inputView.inputString();

        int count = raceJudge.getTryCount(tryInput);
        List<Car> winners = runRace(count, cars);

        outputView.outputFinalResult(winners);
    }

    private List<Car> runRace(int count, List<Car> cars) {
        for (int i = 0; i < count; i++) {
            raceJudge.forwardOnce(cars);
            outputView.outputOnceTryResult(cars);
        }
        return raceJudge.getWinner();
    }
}
