package racingcar.exception;

public class DuplicateNameException extends IllegalArgumentException{
    public DuplicateNameException(){
        super("이름은 중복될 수 없습니다.");
    }
}
