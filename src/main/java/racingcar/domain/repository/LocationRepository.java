package racingcar.domain.repository;

import racingcar.domain.car.Car;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LocationRepository {

    private final Map<Car, Integer> locationRepository = new HashMap<>();

    public void saveLocation(Car car, int location) {
        locationRepository.put(car, location);
    }

    public int getLocation(Car car) {
        return locationRepository.get(car);
    }

    public Map<Car, Integer> getAll() {
        return Collections.unmodifiableMap(locationRepository);
    }
}
