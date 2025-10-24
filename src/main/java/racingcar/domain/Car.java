package racingcar.domain;

public class Car {
    public CarName name;

    public Car(String name){
        this.name = new CarName(name);
    }

    public String getName(){
        return name.getName();
    }
}
