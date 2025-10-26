package racingcar.exception;

public class EmptyNameException extends IllegalArgumentException{
    public EmptyNameException(){
        super("이름에 빈값이 들어올수 없습니다.");
    }
}
