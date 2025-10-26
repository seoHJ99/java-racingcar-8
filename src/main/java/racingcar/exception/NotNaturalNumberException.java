package racingcar.exception;

public class NotNaturalNumberException extends IllegalArgumentException{
    public NotNaturalNumberException(){
        super("숫자는 자연수로만 들어와야 합니다.");
    }
}
