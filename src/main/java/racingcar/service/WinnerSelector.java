package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.message.ExceptionMessage;

public class WinnerSelector {
    private WinnerSelector() {}

    public static List<Car> selectWinner(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNER_SELECTOR_NO_CARS);
        }

        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
