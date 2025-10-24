package racingcar.domain;

public class CarName {
    private final String value;

    public CarName(String value){
        value = value.trim();

        if(value.isEmpty()) throw new IllegalArgumentException("빈값은 이름이 될 수 없습니다.");
        if(value.length() >5) throw new IllegalArgumentException("자동차 이름은 5자 이하로 제한됩니다.");

        this.value = value;
    }

    public String getName(){
        return value;
    }
}
