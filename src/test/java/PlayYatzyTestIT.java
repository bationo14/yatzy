import core.constant.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayYatzyTestIT {

    private PlayYatzy playYatzyTest;

    @BeforeEach
    public void initYatzy() {
        playYatzyTest = new PlayYatzy();
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play")
    public void playing_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Act
      int actualResult = playYatzyTest.score(dices, category);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play() {

        // 1,1,3,3,6 placed on “CHANCE” scores 14
        // 1,1,2,2,2 placed on “HOUSE” scores 8
        // 2,2,2,2,5 placed on “FOUR_KIND” scores 8
        // 2,3,4,5,6 placed on “LARGE_STRAIGHT” scores 20
        // 1,1,1,1,1 placed on “YATZY” scores 50
        // 1,1,2,4,4 placed on “FOURS” scores 8
        // 1,1,2,3,3 placed on “TWO_PAIRS” scores 8

        return Stream.of(
            Arguments.of(List.of(1,1,3,3,6), Category.CHANCE, 14),
            Arguments.of(List.of(1,1,2,2,2), Category.HOUSE, 8),
            Arguments.of(List.of(2,2,2,2,5), Category.FOUR_KIND, 8),
            Arguments.of(List.of(2,3,4,5,6), Category.LARGE_STRAIGHT, 20),
            Arguments.of(List.of(1,1,1,1,1), Category.YATZY, 50),
            Arguments.of(new ArrayList<>(Arrays.asList(1,1,2,4,4)), Category.FOURS, 8),
            Arguments.of(new ArrayList<>(Arrays.asList(1,1,2,3,3)), Category.TWO_PAIRS, 8)
        );
    }
}
