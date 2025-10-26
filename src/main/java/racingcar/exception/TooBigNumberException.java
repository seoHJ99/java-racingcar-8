package racingcar.exception;

public class TooBigNumberException extends IllegalArgumentException{
    public TooBigNumberException(){
        super(ExceptionMessage.TOO_BIG_NUMBER);
    }
}
