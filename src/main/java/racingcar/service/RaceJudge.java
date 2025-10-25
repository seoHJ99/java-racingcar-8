package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.Car;
import racingcar.domain.repository.CarRepository;
import racingcar.domain.repository.LocationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceJudge {

    private final CarRepository carRepository;
    private final LocationRepository locationRepository;
    private final String DIGIT_REGEX = "^[1-9]\\d*$";
    private final int FORWARD_NUMBER = 5;

    public RaceJudge(CarRepository carRepository, LocationRepository locationRepository) {
        this.carRepository = carRepository;
        this.locationRepository = locationRepository;
    }

    private void registerCar(Car car) {
        locationRepository.saveLocation(car, 0);
        carRepository.saveCar(car);
    }

    public void registerAllCars(List<Car> cars) {
        for (Car car : cars) {
            if (alreadyExist(car)) {
                throw new IllegalArgumentException("자동차 이름은 고유해야 합니다.");
            }
            registerCar(car);
        }
    }

    public int getTryCount(String count) {
        if (!isPositiveNumber(count)) {
            throw new IllegalArgumentException("시도 횟수는 양수로 입력되어야만 합니다.");
        }

        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 너무 큽니다.");
        }
    }

    public List<Car> getWinner() {
        List<Car> winnerList = new ArrayList<>();
        int winnerLocation = getHighestLocation();

        for (Car car : carRepository.getAll()) {
            if (winnerLocation == locationRepository.getLocation(car)) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    public void forwardOnce(List<Car> cars) {
        for (Car car : cars) {
            goForward(car);
        }
    }

    private boolean alreadyExist(Car car) {
        if (carRepository.findByName(car.getName()) == null) {
            return false;
        }
        return true;
    }

    private boolean isPositiveNumber(String input) {
        if (!input.matches(DIGIT_REGEX))
            return false;

        return true;
    }

    private void goForward(Car car) {
        if (canGo()) {
            int nowLocation = locationRepository.getLocation(car);
            locationRepository.saveLocation(car, nowLocation + 1);
        }
    }

    private boolean canGo() {
        return getRandomNum() >= FORWARD_NUMBER;
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private int getHighestLocation() {
        int max = 0;
        for (Map.Entry<Car, Integer> entry : locationRepository.getAll().entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        return max;
    }

}
