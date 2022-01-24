import core.constant.Category;
import core.service.KindPlayYatzy;
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

public class KindPlayYatzyTest {

    private Yatzy playYatzyTest;

    @BeforeEach
    public void initYatzy() {
        playYatzyTest = new KindPlayYatzy();
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_Three_Kind")
    public void playing_with_Three_Kind_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_Three_Kind() {

        // 3,3,3,4,5 scores 9 (3+3+3)
        // 3,3,4,5,6 scores 0
        // 3,3,3,3,1 scores 9 (3+3+3)

        return Stream.of(
            Arguments.of(List.of(3,3,3,4,5), Category.THREE_KIND, 9),
            Arguments.of(List.of(3,3,4,5,6), Category.THREE_KIND, 0),
            Arguments.of(List.of(3,3,3,3,1), Category.THREE_KIND, 9)
        );
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_Four_Kind")
    public void playing_with_Four_Kind_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_Four_Kind() {

        // 2,2,2,2,5 scores 8 (2+2+2+2)
        // 2,2,2,5,5 scores 0
        // 2,2,2,2,2 scores 8 (2+2+2+2)

        return Stream.of(
            Arguments.of(List.of(2,2,2,2,5), Category.FOUR_KIND, 8),
            Arguments.of(List.of(2,2,2,5,5), Category.FOUR_KIND, 0),
            Arguments.of(List.of(2,2,2,2,2), Category.FOUR_KIND, 8)
        );
    }
}
