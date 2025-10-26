package racingcar.domain.car;

import racingcar.exception.EmptyNameException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public List<Car> createCars(String input) {
        List<Car> cars = Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        if(cars.size()==0)
            throw new EmptyNameException();
        
        return cars;
    }
}
