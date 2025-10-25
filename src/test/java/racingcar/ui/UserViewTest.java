package racingcar.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.consts.RacingConstants;
import racingcar.domain.Car;

public class UserViewTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("User view showInputCarNameMessage 매서드 테스트")
    void showInputCarNameMessage() {
        UserView.showInputCarNameMessage();
        Assertions.assertEquals(RacingConstants.USER_VIEW_INPUT_CAR_NAME_MESSAGE, outputStream.toString().trim());
    }

    @Test
    @DisplayName("User view showInputRaceCountMessage 매서드 테스트")
    void showInputRaceCountMessage() {
        UserView.showInputRaceCountMessage();
        Assertions.assertEquals(RacingConstants.USER_VIEW_INPUT_RACE_COUNT_MESSAGE, outputStream.toString().trim());
    }

    @Test
    @DisplayName("User view showRaceResultMessage 매서드 테스트")
    void showRaceResultMessage() {
        UserView.showRaceResultMessage();
        Assertions.assertEquals(RacingConstants.USER_VIEW_RESULT_HEADER_MESSAGE, outputStream.toString().trim());
    }

    @Test
    @DisplayName("User view showRaceResult 매서드 테스트")
    void showRaceResult() {
        Car carA = Car.of("A", 3);
        Car carB = Car.of("B", 3);
        Car carC = Car.of("C", 1);
        List<Car> cars = List.of(carA, carB, carC);

        String expected = """
                A : ---
                B : ---
                C : -""";

        UserView.showRaceResult(cars);
        Assertions.assertEquals(expected.replaceAll("\\R", "\n"),
                outputStream.toString().trim().replaceAll("\\R", "\n"));
    }

    @Test
    @DisplayName("User view showWinners 매서드 테스트")
    void showWinners() {
        Car carA = Car.of("A", 3);
        Car carB = Car.of("B", 3);
        List<Car> cars = List.of(carA, carB);

        String expected = RacingConstants.USER_VIEW_WINNERS_MESSAGE + "A, B";

        UserView.showWinners(cars);
        Assertions.assertEquals(expected.replaceAll("\\R", "\n"),
                outputStream.toString().trim().replaceAll("\\R", "\n"));
    }
}
