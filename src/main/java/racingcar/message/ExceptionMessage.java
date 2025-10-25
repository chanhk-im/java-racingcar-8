package racingcar.message;

public class ExceptionMessage {
    private ExceptionMessage() {
    }

    /* ------------- Car ------------- */
    public final static String CAR_MOVE_OVERFLOW_MESSAGE = "위치 값이 너무 큽니다.";

    /* ------------- WinnerSelector ------------- */
    public final static String WINNER_SELECTOR_NO_CARS = "등록된 자동차가 없습니다.";

    /* ------------- RacingService ------------- */
    public final static String RACING_SERVICE_NO_CARS = "등록된 자동차가 없습니다.";

    public final static String INPUT_TOO_MANY_NAMES = "입력받은 이름이 너무 많습니다.";
    public final static String INPUT_TOO_LONG_NAME = "이름이 너무 깁니다.";
    public final static String INPUT_WRONG_CHARACTER = "이름은 영문 또는 숫자로만 이루어져야 합니다.";
    public final static String INPUT_NEGATIVE = "양수를 입력해야 합니다.";
    public final static String INPUT_NOT_A_NUMBER = "숫자가 아닙니다.";
    public final static String INPUT_TOO_LARGE_NUMBER = "너무 큰 숫자입니다.";
}
