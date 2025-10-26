package racingcar.exception;

public class TooBigNumberException extends IllegalArgumentException{
    public TooBigNumberException(){
        super("숫자가 너무 큽니다.");
    }
}
