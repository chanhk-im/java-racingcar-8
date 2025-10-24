package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.dto.RacingInformation;
import racingcar.dto.RacingWinners;

public class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @Test
    @DisplayName("Racing service 정상적으로 최소 하나의 winner를 반환해야 한다.")
    void raceSuccessful() {
        Car carA = Car.of("A");
        Car carB = Car.of("B");
        Car carC = Car.of("C");

        List<Car> cars = List.of(carA, carB, carC);

        Integer raceCount = 5;
        RacingInformation racingInformation = RacingInformation.of(cars, raceCount);

        RacingWinners racingWinners = racingService.race(racingInformation);

        Assertions.assertTrue(racingWinners.getWinners().size() >= 1);
    }

    @Test
    @DisplayName("Racing service 빈 car list가 들어가면 exception이 발생해야 한다.")
    void raceEmptyCarListThrowException() {
        List<Car> cars = List.of();

        Integer raceCount = 5;
        RacingInformation racingInformation = RacingInformation.of(cars, raceCount);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingService.race(racingInformation);
        });
    }
}
