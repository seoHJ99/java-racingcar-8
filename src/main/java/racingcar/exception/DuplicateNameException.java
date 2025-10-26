package racingcar.exception;

public class DuplicateNameException extends IllegalArgumentException{
    public DuplicateNameException(){
        super(ExceptionMessage.DUPLICATE_NAME);
    }
}
