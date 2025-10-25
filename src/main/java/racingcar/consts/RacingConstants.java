package racingcar.consts;

public class RacingConstants {
    public final static int MAX_CARS_COUNT = 50;
    public final static int MAX_CAR_NAME_LENGTH = 5;

    public final static int MAX_RACE_COUNT = 100;

    public final static int RACE_MOVEMENT_THRESHOLD = 4;
    public final static int RACE_RANDOM_MIN_NUMBER = 0;
    public final static int RACE_RANDOM_MAX_NUMBER = 9;

    public final static String USER_VIEW_INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final static String USER_VIEW_INPUT_RACE_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public final static String USER_VIEW_RESULT_HEADER_MESSAGE = "실행 결과";
    public final static String USER_VIEW_WINNERS_MESSAGE = "최종 우승자 : ";
    public final static char USER_VIEW_CAR_POSITION_CELL = '-';

    private RacingConstants() {
    }
}
