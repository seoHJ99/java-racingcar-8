package racingcar.exception;

public class EmptyNameException extends IllegalArgumentException{
    public EmptyNameException(){
        super(ExceptionMessage.EMPTY_NAME);
    }
}
