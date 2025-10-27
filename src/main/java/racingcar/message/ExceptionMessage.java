package racingcar.message;

public enum ExceptionMessage {
    /* ------------- Car ------------- */
    CAR_MOVE_OVERFLOW_MESSAGE("위치 값이 너무 큽니다."),

    /* ------------- WinnerSelector ------------- */
    WINNER_SELECTOR_NO_CARS("등록된 자동차가 없습니다."),

    /* ------------- RacingService ------------- */
    RACING_SERVICE_NO_CARS("등록된 자동차가 없습니다."),

    /* ------------- InputManager ------------- */
    INPUT_TOO_MANY_NAMES("입력받은 이름이 너무 많습니다."),
    INPUT_TOO_LONG_NAME("이름이 너무 깁니다."),
    INPUT_WRONG_CHARACTER("이름은 영문 또는 숫자로만 이루어져야 합니다."),
    INPUT_NEGATIVE("양수를 입력해야 합니다."),
    INPUT_NOT_A_NUMBER("숫자가 아닙니다."),
    INPUT_TOO_LARGE_NUMBER("너무 큰 숫자입니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
