package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.EmptyNameException;
import racingcar.exception.NotNaturalNumberException;
import racingcar.repository.CarRepository;
import racingcar.repository.LocationRepository;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        CarRepository.getInstance().clearAll();
        LocationRepository.getInstance().clearAll();
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복 이름 예외 테스트")
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .isInstanceOf(DuplicateNameException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("이름 빈값 테스트")
    @ValueSource(strings = {"", ",", " , ", "     "})
    void 예외_테스트_3(String name) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(name, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .isInstanceOf(EmptyNameException.class)
        );
    }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
