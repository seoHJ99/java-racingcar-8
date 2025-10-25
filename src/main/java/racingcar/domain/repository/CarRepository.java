package racingcar.domain.repository;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {

    // 순서 보장을 위해 리스트로 저장
    private static final List<Car> carRepository = new ArrayList<>();

    public static void saveCar(Car car){
        carRepository.add(car);
    }

    public static Car findByName(String name){
        return carRepository.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static List<Car> getAll(){
        return  Collections.unmodifiableList(carRepository);
    }
}
