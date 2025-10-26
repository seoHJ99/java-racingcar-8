package racingcar.repository;

import racingcar.domain.car.Car;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LocationRepository {
    private final Map<Car, Integer> locationRepository = new HashMap<>();
    private static LocationRepository locationRepo;

    private LocationRepository() {
    }

    public static LocationRepository getInstance() {
        if (locationRepo == null)
            locationRepo = new LocationRepository();
        return locationRepo;
    }

    public void saveLocation(Car car, int location) {
        locationRepository.put(car, location);
    }

    public int getLocation(Car car) {
        return locationRepository.get(car);
    }

    public Map<Car, Integer> getAll() {
        return Collections.unmodifiableMap(locationRepository);
    }

    public void clearAll(){
        locationRepository.clear();
    }
}
