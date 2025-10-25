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

    public CarRace(RaceJudge raceJudge, CarFactory carFactory){
        this.raceJudge = raceJudge;
        this.carFactory = carFactory;
    }


    public void start() {
        OutputView.requestNames();
        String namesInput = InputView.inputString();
        List<Car> cars = carFactory.createCars(namesInput);
        raceJudge.registerAllCars(cars);

        OutputView.requestCount();
        String tryInput = InputView.inputString();

        int count = raceJudge.getTryCount(tryInput);
        List<Car> winners= runRace(count, cars);

        OutputView.outputFinalResult(winners);
    }

    private List<Car> runRace(int count, List<Car> cars){
        for (int i = 0; i < count; i++) {
            raceJudge.forwardOnce(cars);
            OutputView.outputOnceTryResult(cars);
        }
        return raceJudge.getWinner();
    }
}
