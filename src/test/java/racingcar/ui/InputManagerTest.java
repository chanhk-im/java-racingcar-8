package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.StringJoiner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputManagerTest {

    @AfterEach
    public void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("getInputCarNames 쉼표 기준으로 구분되고, 띄어쓰기를 해도 정상 작동해야 한다.")
    void getInputCarNamesSuccessful() {
        String input = "pobi,woni, jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> actual = InputManager.getInputCarNames();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getInputCarNames 입력받은 이름이 5자 초과되면 IllegalArgumentException이 발생해야 한다.")
    void getInputCarNamesLongNameException() {
        String input = "pobi,woni, junjun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, InputManager::getInputCarNames);
    }

    @Test
    @DisplayName("getInputCarNames 입력받은 이름에 알파뱃, 숫자 외 다른 문자가 있으면 IllegalArgumentException이 발생해야 한다.")
    void getInputCarNamesWrongCharException() {
        String input = "pobi,woni, junjun@";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, InputManager::getInputCarNames);
    }

    @Test
    @DisplayName("getInputCarNames 입력받은 이름의 개수가 50개 초과되면 IllegalArgumentException이 발생해야 한다.")
    void getInputCarNamesTooManyCarsException() {
        StringJoiner inputJoiner = new StringJoiner(",");

        for (int i = 0; i < 50; i++) {
            inputJoiner.add("test");
        }
        String input = inputJoiner.toString();

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, InputManager::getInputCarNames);
    }

    @Test
    @DisplayName("getInputRaceCount 입력받은 숫자를 반환해야 한다.")
    void getInputRaceCountSuccessful() {
        String input = "5";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int expected = 5;
        int actual = InputManager.getInputRaceCount();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getInputRaceCount 입력받은 숫자가 음수면 IllegalArgumentException이 발생해야 한다.")
    void getInputRaceCountNegativeNumberException() {
        String input = "-3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, InputManager::getInputRaceCount);
    }

    @Test
    @DisplayName("getInputRaceCount 입력받은 숫자가 100 초과되면 IllegalArgumentException이 발생해야 한다.")
    void getInputRaceCountTooLargeNumberException() {
        String input = "101";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, InputManager::getInputRaceCount);
    }

    @Test
    @DisplayName("getInputRaceCount 입력받은 값이 숫자가 아니라면 IllegalArgumentException이 발생해야 한다.")
    void getInputRaceCountNaNException() {
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, InputManager::getInputRaceCount);
    }
}
