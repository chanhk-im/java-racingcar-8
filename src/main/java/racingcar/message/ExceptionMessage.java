package racingcar.message;

public class ExceptionMessage {
    private ExceptionMessage() {}

    /* ------------- Car ------------- */
    public final static String CAR_MOVE_OVERFLOW_MESSAGE = "위치 값이 너무 큽니다.";

    /* ------------- WinnerSelector ------------- */
    public final static String WINNER_SELECTOR_NO_CARS = "등록된 자동차가 없습니다.";
}
