import core.constant.Category;
import core.service.StraightPlayYatzy;
import core.service.Yatzy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightPlayYatzyTest {

    private Yatzy playYatzyTest;

    @BeforeEach
    public void initYatzy() {
        playYatzyTest = new StraightPlayYatzy();
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_Small_Straight")
    public void playing_with_Small_Straight_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_Small_Straight() {

        // 1,2,3,4,5 scores 15
        // 1,3,5,4,2 scores 0

        return Stream.of(
            Arguments.of(List.of(1,2,3,4,5), Category.SMALL_STRAIGHT, 15),
            Arguments.of(List.of(1,3,5,4,2), Category.SMALL_STRAIGHT, 0)
        );
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_Large_Straight")
    public void playing_with_Large_Straight_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_Large_Straight() {

        // 2,3,4,5,6 scores 20
        // 6,4,5,3,2 scores 0

        return Stream.of(
            Arguments.of(List.of(2,3,4,5,6), Category.LARGE_STRAIGHT, 20),
            Arguments.of(List.of(6,4,5,3,2), Category.LARGE_STRAIGHT, 0)
        );
    }

}
