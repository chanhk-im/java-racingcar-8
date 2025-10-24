package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public class RacingWinners {
    private List<Car> winners;

    private RacingWinners(List<Car> winners) {
        this.winners = winners;
    }

    public static RacingWinners of(List<Car> winners) {
        return new RacingWinners(winners);
    }

    public List<Car> getWinners() {
        return winners;
    }
}
