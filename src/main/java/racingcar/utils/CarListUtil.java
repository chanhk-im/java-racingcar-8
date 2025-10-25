package racingcar.utils;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;

public class CarListUtil {
    private CarListUtil() {
    }

    public static String carListToString(List<Car> cars) {
        StringJoiner joiner = new StringJoiner(", ");

        for (Car car : cars) {
            joiner.add(car.getName());
        }

        return joiner.toString();
    }
}
