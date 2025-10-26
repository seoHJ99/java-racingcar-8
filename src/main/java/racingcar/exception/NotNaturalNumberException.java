package racingcar.exception;

public class NotNaturalNumberException extends IllegalArgumentException{
    public NotNaturalNumberException(){
        super(ExceptionMessage.NOT_NATURAL_NUMBER);
    }
}
