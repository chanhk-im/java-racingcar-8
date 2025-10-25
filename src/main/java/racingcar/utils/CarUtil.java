package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import racingcar.consts.RacingConstants;
import racingcar.domain.Car;

public class CarUtil {
    private CarUtil() {
    }

    public static String carInfoString(Car car) {
        StringBuilder builder = new StringBuilder();

        builder.append(car.getName());
        builder.append(" : ");
        for (int count = 0; count < car.getPosition(); count++) {
            builder.append(RacingConstants.USER_VIEW_CAR_POSITION_CELL);
        }

        return builder.toString();
    }

    public static String carListToString(List<Car> cars) {
        StringJoiner joiner = new StringJoiner(", ");

        for (Car car : cars) {
            joiner.add(car.getName());
        }

        return joiner.toString();
    }

    public static List<Car> carListFromStringArray(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.of(name));
        }

        return cars;
    }
}
