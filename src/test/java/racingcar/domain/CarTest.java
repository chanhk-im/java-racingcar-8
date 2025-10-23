package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("move() 메서드는 position을 1 더해줘야 한다.")
    void carMoveTest() {
        String name = "test";
        Car car = Car.of(name);

        car.move();
        int expected = 1;
        int actual = car.getPosition();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("move() 메서드 최대 치 초과되면 ArithmeticException 에러가 발생해야 한다.")
    void carMoveArithmeticException() {
        String name = "test";
        Car car = Car.of(name);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            car.move();
        });
    }
}
