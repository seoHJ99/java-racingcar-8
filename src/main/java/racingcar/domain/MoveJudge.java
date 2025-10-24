package racingcar.domain;

public class MoveJudge {

    private final static String DIGIT_REGEX = "^[1-9]\\d*$";

    private int getTryCount(String count) {
        if(isPositiveNumber(count)){
            throw new IllegalArgumentException("시도 횟수는 양수로 입력되어야만 합니다.");
        }

        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 너무 큽니다.");
        }
    }

    private boolean isPositiveNumber(String input) {
        if (!input.matches(DIGIT_REGEX))
            return false;

        return true;
    }

}
