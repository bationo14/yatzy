import core.constant.Category;
import core.service.ChancePlayYatzy;
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

public class ChancePlayYatzyTest {

    private Yatzy playYatzyTest;

    @BeforeEach
    public void initYatzy() {
        playYatzyTest = new ChancePlayYatzy();
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_Chance")
    public void playing_with_Chance_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
      int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_Chance() {

        // 1,1,3,3,6 placed on “chance” scores 14 (1+1+3+3+6)
        // 4,5,5,6,1 placed on “chance” scores 21 (4+5+5+6+1)

        return Stream.of(
            Arguments.of(List.of(1,1,3,3,6), Category.CHANCE, 14),
            Arguments.of(List.of(4,5,5,6,1), Category.CHANCE, 21)
        );
    }
}
