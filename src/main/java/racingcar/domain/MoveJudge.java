package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MoveJudge {

    private final String DIGIT_REGEX = "^[1-9]\\d*$";
    private final int FORWARD_NUMBER = 5;

    private int getTryCount(String count) {
        if (isPositiveNumber(count)) {
            throw new IllegalArgumentException("시도 횟수는 양수로 입력되어야만 합니다.");
        }

        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 너무 큽니다.");
        }
    }

    private boolean isPositiveNumber(String input) {
        if (!input.matches(DIGIT_REGEX))
            return false;

        return true;
    }

    public void goForwardAll(List<Car> cars) {
        for (Car car : cars) {
            goForward(car);
        }
    }

    private void goForward(Car car) {
        if (canGo()) {
            int nowLocation = LocationRepository.locationRepository.get(car.getName());
            LocationRepository.locationRepository.put(car, nowLocation + 1);
        }
    }

    private boolean canGo() {
        return getRandomNum() >= FORWARD_NUMBER;
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
