package racingcar.ui;

import java.util.List;
import racingcar.consts.RacingConstants;
import racingcar.domain.Car;
import racingcar.utils.CarUtil;

public class UserView {
    private UserView() {
    }

    public static void showInputCarNameMessage() {
        System.out.println(RacingConstants.USER_VIEW_INPUT_CAR_NAME_MESSAGE);
    }

    public static void showInputRaceCountMessage() {
        System.out.println(RacingConstants.USER_VIEW_INPUT_RACE_COUNT_MESSAGE);
    }

    public static void showWinners(List<Car> winners) {
        String winnerString = CarUtil.carListToString(winners);
        System.out.print(RacingConstants.USER_VIEW_WINNERS_MESSAGE);
        System.out.println(winnerString);
    }

    public static void showRaceResultMessage() {
        System.out.println(RacingConstants.USER_VIEW_RESULT_HEADER_MESSAGE);
    }

    public static void showRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(CarUtil.carInfoString(car));
        }
    }
}
