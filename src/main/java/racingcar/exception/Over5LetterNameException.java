package racingcar.exception;

public class Over5LetterNameException extends IllegalArgumentException{
    public Over5LetterNameException(){
        super(ExceptionMessage.OVER_FIVE_LETTER_NAME);
    }
}
