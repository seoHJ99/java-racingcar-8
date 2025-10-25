package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.repository.LocationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final LocationRepository locationRepository;
    private final String REQUEST_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String REQUEST_COUNT = "시도할 횟수는 몇 회인가요?";
    private final String FINAL_WINNER = "최종 우승자 : ";

    public OutputView(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void requestNames() {
        System.out.println(REQUEST_NAMES);
    }

    public void requestCount() {
        System.out.println(REQUEST_COUNT);
    }

    public void outputFinalResult(List<Car> winners) {
        String names = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
        System.out.println(FINAL_WINNER + names);
    }

    public void outputOnceTryResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append(outputLocation(car));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private String outputLocation(Car car) {
        StringBuilder sb = new StringBuilder();
        int location = locationRepository.getLocation(car);
        for (int i = 0; i < location; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
