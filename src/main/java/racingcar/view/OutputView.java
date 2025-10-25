package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.LocationRepository;

import java.util.List;

public class OutputView {

    public void outputOnceTryResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append(outputLocation(car));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private String outputLocation(Car car) {
        StringBuilder sb = new StringBuilder();
        int location = LocationRepository.getLocation(car);
        for (int i = 0; i < location; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
