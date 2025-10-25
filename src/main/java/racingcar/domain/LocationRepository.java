package racingcar.domain;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationRepository {

    private static final Map<Car, Integer> locationRepository = new HashMap<>();

    public static void saveLocation(Car car, int location){
        locationRepository.put(car, location);
    }

    public static int getLocation(Car car){
        return locationRepository.get(car);
    }

    public Map<Car, Integer> getAll(){
        return Collections.unmodifiableMap(locationRepository);
    }
}
