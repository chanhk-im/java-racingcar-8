package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.consts.RacingConstants;
import racingcar.message.ExceptionMessage;

public class InputManager {
    private InputManager() {
    }

    public static List<String> getInputCarNames() {
        String input = Console.readLine();
//        Console.close();

        return parseInputCarNames(input);
    }

    private static List<String> parseInputCarNames(String input) {
        String[] names = input.split(",");
        checkTooManyNames(names);

        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            String cleanName = name.trim();

            checkTooLongName(cleanName);
            checkWrongCharInName(cleanName);

            carNames.add(cleanName);
        }

        return carNames;
    }

    private static void checkTooManyNames(String[] names) {
        if (names.length > RacingConstants.MAX_CARS_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_TOO_MANY_NAMES);
        }
    }

    private static void checkTooLongName(String name) {
        if (name.length() > RacingConstants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_TOO_LONG_NAME);
        }
    }

    private static void checkWrongCharInName(String name) {
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_WRONG_CHARACTER);
        }
    }

    public static int getInputRaceCount() {
        String input = Console.readLine();

        checkRaceCountNaN(input);

        int raceCount = Integer.parseInt(input);

        checkRaceCountNegative(raceCount);
        checkRaceCountTooLarge(raceCount);

        return raceCount;
    }

    private static void checkRaceCountNaN(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NOT_A_NUMBER);
        }
    }

    private static void checkRaceCountNegative(int raceCount) {
        if (raceCount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NEGATIVE);
        }
    }

    private static void checkRaceCountTooLarge(int raceCount) {
        if (raceCount > RacingConstants.MAX_RACE_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_TOO_LARGE_NUMBER);
        }
    }
}
