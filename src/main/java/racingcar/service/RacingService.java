package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.consts.RacingConstants;
import racingcar.domain.Car;
import racingcar.dto.RacingInformation;
import racingcar.dto.RacingWinners;
import racingcar.message.ExceptionMessage;
import racingcar.ui.UserView;

public class RacingService {
    public RacingWinners race(RacingInformation racingInformation) {
        int raceCount = racingInformation.getRaceCount();
        List<Car> cars = racingInformation.getCars();

        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.RACING_SERVICE_NO_CARS.getMessage());
        }

        UserView.showRaceResultMessage();

        for (int currentCount = 0; currentCount < raceCount; currentCount++) {
            raceEachTurn(cars, raceCount);
        }

        return RacingWinners.of(WinnerSelector.selectWinner(racingInformation.getCars()));
    }

    public void raceEachTurn(List<Car> cars, int raceCount) {
        for (Car car : cars) {
            raceEachCar(car);
        }

        UserView.showRaceResult(cars);
    }

    public void raceEachCar(Car car) {
        int randomNumber = Randoms.pickNumberInRange(RacingConstants.RACE_RANDOM_MIN_NUMBER,
                RacingConstants.RACE_RANDOM_MAX_NUMBER);

        if (randomNumber >= RacingConstants.RACE_MOVEMENT_THRESHOLD) {
            car.move();
        }
    }
}
