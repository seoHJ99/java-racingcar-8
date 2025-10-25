package racingcar.domain.car;

public class Car {
    private CarName name;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public String getName() {
        return name.getName();
    }
}
