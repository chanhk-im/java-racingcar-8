package racingcar.service;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class WinnerSelectorTest {

    @Test
    @DisplayName("WinnerSelector selectWinner 우승자 1개 테스트")
    void selectOneWinner() {
        Car carA = Car.of("A", 3);
        Car carB = Car.of("B", 2);
        Car carC = Car.of("C", 1);

        List<Car> cars = List.of(carA, carB, carC);
        List<Car> actualWinners = WinnerSelector.selectWinner(cars);
        List<Car> expectedWinners = List.of(carA);
        int expectedListLength = expectedWinners.size();
        int actualListLength = actualWinners.size();

        Assertions.assertEquals(expectedListLength, actualListLength);
        Assertions.assertTrue(actualWinners.containsAll(expectedWinners));
    }

    @Test
    @DisplayName("WinnerSelector selectWinner 우승자 여러 개 테스트")
    void selectManyWinners() {
        Car carA = Car.of("A", 3);
        Car carB = Car.of("B", 3);
        Car carC = Car.of("C", 3);
        Car carD = Car.of("D", 1);

        List<Car> cars = List.of(carA, carB, carC);
        List<Car> actualWinners = WinnerSelector.selectWinner(cars);
        List<Car> expectedWinners = List.of(carA, carB, carC);
        int expectedListLength = expectedWinners.size();
        int actualListLength = actualWinners.size();

        Assertions.assertEquals(expectedListLength, actualListLength);
        Assertions.assertTrue(actualWinners.containsAll(expectedWinners));
    }

    @Test
    @DisplayName("WinnerSelector selectWinner 빈 배열일 경우 에러가 발생해야 한다.")
    void selectWinnerEmptyListException() {
        List<Car> cars = List.of();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WinnerSelector.selectWinner(cars);
        });
    }
}
