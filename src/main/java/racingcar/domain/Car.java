package racingcar.domain;

import racingcar.message.ExceptionMessage;

public class Car {
    private String name;
    private Integer position;

    private Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(name, 0);
    }

    public static Car of(String name, Integer position) {
        return new Car(name, position);
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void move() {
        if (position >= Integer.MAX_VALUE) {
            throw new ArithmeticException(ExceptionMessage.CAR_MOVE_OVERFLOW_MESSAGE.getMessage());
        }
        position++;
    }
}
