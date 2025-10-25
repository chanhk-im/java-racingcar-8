package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.RacingInformation;
import racingcar.dto.RacingWinners;
import racingcar.service.RacingService;
import racingcar.ui.InputManager;
import racingcar.ui.UserView;
import racingcar.utils.CarUtil;

public class RacingController {
    private RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void run() {
        UserView.showInputCarNameMessage();
        List<String> carNames = InputManager.getInputCarNames();

        UserView.showInputRaceCountMessage();
        int raceCount = InputManager.getInputRaceCount();

        List<Car> cars = CarUtil.carListFromStringArray(carNames);

        RacingInformation racingInformation = RacingInformation.of(cars, raceCount);
        RacingWinners racingWinners = racingService.race(racingInformation);

        UserView.showWinners(racingWinners.getWinners());
    }
}
