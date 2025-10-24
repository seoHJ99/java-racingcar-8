package racingcar.domain;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationRepository {

    public static final Map<Car, Integer> locationRepository = new HashMap<>();

    public void saveLocation(Car car, int location){
        locationRepository.put(car, location);
    }

    public int getLocation(Car car){
        return locationRepository.get(car);
    }
}
