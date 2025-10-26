package racingcar.exception;

public class Over5LetterNameException extends IllegalArgumentException{
    public Over5LetterNameException(){
        super("자동차 이름은 5자 이하여야 합니다.");
    }
}
