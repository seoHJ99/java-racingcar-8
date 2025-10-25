package racingcar;

import racingcar.controller.CarRace;
import racingcar.domain.car.CarFactory;
import racingcar.domain.repository.CarRepository;
import racingcar.domain.repository.LocationRepository;
import racingcar.service.RaceJudge;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceJudge raceJudge = new RaceJudge(CarRepository.getInstance(), LocationRepository.getInstance());
        CarRace carRace = new CarRace(raceJudge, new CarFactory(), new InputView(), new OutputView(LocationRepository.getInstance()));
        carRace.start();
    }
}
