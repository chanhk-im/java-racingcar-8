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
    @DisplayName("User view showInputMessage 매서드 테스트")
    void showInputMessage() {
        UserView.showInputMessage();
        Assertions.assertEquals(RacingConstants.USER_VIEW_INPUT_MESSAGE, outputStream.toString());
    }

    @Test
    @DisplayName("User view showWinners 매서드 테스트")
    void showWinners() {
        Car carA = Car.of("A", 3);
        Car carB = Car.of("B", 2);
        Car carC = Car.of("C", 1);
        List<Car> cars = List.of(carA, carB, carC);

        String expected = RacingConstants.USER_VIEW_INPUT_MESSAGE
                + "\npobi : -\n"
                + "woni : \n"
                + "jun : -\n"
                + "\n"
                + "pobi : --\n"
                + "woni : -\n"
                + "jun : --\n"
                + "\n"
                + "pobi : ---\n"
                + "woni : --\n"
                + "jun : ---\n"
                + "\n"
                + "pobi : ----\n"
                + "woni : ---\n"
                + "jun : ----\n"
                + "\n"
                + "pobi : -----\n"
                + "woni : ----\n"
                + "jun : -----\n"
                + "\n"
                + RacingConstants.USER_VIEW_WINNERS_MESSAGE
                + "pobi, jun";

        UserView.showWinners(cars);
        Assertions.assertEquals(RacingConstants.USER_VIEW_INPUT_MESSAGE, outputStream.toString());
    }
}
