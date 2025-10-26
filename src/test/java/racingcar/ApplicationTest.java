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
import racingcar.exception.TooBigNumberException;
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
    @DisplayName("혼자 참가 테스트1")
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("혼자 참가 테스트2")
    void 기능_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : ", "최종 우승자 : pobi");
                },
                STOP
        );
    }

    @Test
    @DisplayName("공동 우승 테스트1")
    void 기능_테스트4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("공동 우승 테스트2")
    void 기능_테스트5() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP
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

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "0.1"})
    @DisplayName("시도 횟수 자연수 예외 테스트")
    void 예외_테스트_4(String count) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", count))
                        .isInstanceOf(IllegalArgumentException.class)
                        .isInstanceOf(NotNaturalNumberException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 int 한계를 넘을때 테스트")
    void 예외_테스트_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .isInstanceOf(TooBigNumberException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
