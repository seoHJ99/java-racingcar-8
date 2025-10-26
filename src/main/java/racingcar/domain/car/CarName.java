package racingcar.domain.car;

import racingcar.exception.EmptyNameException;
import racingcar.exception.Over5LetterNameException;

public class CarName {
    private final String value;

    public CarName(String value) {
        value = value.trim();

        if (value.isEmpty()) throw new EmptyNameException();
        if (value.length() > 5) throw new Over5LetterNameException();

        this.value = value;
    }

    public String getName() {
        return value;
    }
}
