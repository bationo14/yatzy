import core.constant.Category;
import core.service.PairPlayYatzy;
import core.service.TwoPairPlayYatzy;
import core.service.Yatzy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairPlayYatzyTest {

    private Yatzy playYatzyTest;

    @BeforeEach
    public void initYatzy() {
        playYatzyTest = new PairPlayYatzy();
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_Pairs")
    public void playing_with_Pairs_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_Pairs() {

        // 3,3,3,4,4 scores 8 (4+4)
        // 1,1,6,2,6 scores 12 (6+6)
        // 3,3,3,4,1 scores 6 (3+3)
        // 3,3,3,3,1 scores 6 (3+3)

        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(3,4,3,4,3)), Category.PAIR, 8),
            Arguments.of(new ArrayList<>(Arrays.asList(1,1,6,2,6)), Category.PAIR, 12),
            Arguments.of(new ArrayList<>(Arrays.asList(3,3,3,4,1)), Category.PAIR, 6),
            Arguments.of(new ArrayList<>(Arrays.asList(3,3,3,3,1)), Category.PAIR, 6)
        );
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_Two_Pairs")
    public void playing_with_Two_Pairs_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());
        playYatzyTest = new TwoPairPlayYatzy();

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_Two_Pairs() {

        // 1,1,2,3,3 scores 8 (1+1+3+3)
        // 1,1,2,3,4 scores 0
        // 1,1,2,2,2 scores 6 (1+1+2+2)

        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(1,1,2,3,3)), Category.TWO_PAIRS, 8),
            Arguments.of(new ArrayList<>(Arrays.asList(1,1,2,3,4)), Category.TWO_PAIRS, 0),
            Arguments.of(new ArrayList<>(Arrays.asList(1,1,2,2,2)), Category.TWO_PAIRS, 6)
        );
    }
}
