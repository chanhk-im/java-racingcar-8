package racingcar.utils;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarUtilTest {
    @Test
    @DisplayName("carInfoString은 car name, position을 string으로 반환해야 한다.")
    void carInfoString() {
        Car car = Car.of("test", 5);

        String expected = "test : -----";
        String actual = CarUtil.carInfoString(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("carListToString은 car name을 \", \"으로 구분된 string을 반환해야 한다.")
    void carListToString() {
        Car carA = Car.of("A");
        Car carB = Car.of("B");
        Car carC = Car.of("C");

        List<Car> cars = List.of(carA, carB, carC);

        String expected = "A, B, C";
        String actual = CarUtil.carListToString(cars);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("carListToString은 car list가 비어있다면 빈 문자열을 반환해야 한다.")
    void carListToStringEmpty() {
        List<Car> cars = List.of();

        String expected = "";
        String actual = CarUtil.carListToString(cars);

        Assertions.assertEquals(expected, actual);
    }
}
