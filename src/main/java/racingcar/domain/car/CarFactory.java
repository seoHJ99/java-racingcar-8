package racingcar.domain.car;

import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public List<Car> createCars(String input){
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
