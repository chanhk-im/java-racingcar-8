package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public class RacingInformation {
    private List<Car> cars;
    private Integer raceCount;

    private RacingInformation(List<Car> cars, Integer raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public static RacingInformation of(List<Car> cars, Integer raceCount) {
        return new RacingInformation(cars, raceCount);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Integer getRaceCount() {
        return raceCount;
    }
}
