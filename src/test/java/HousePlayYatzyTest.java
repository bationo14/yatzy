import core.constant.Category;
import core.service.HousePlayYatzy;
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

public class HousePlayYatzyTest {

    private Yatzy playYatzyTest;

    @BeforeEach
    public void initYatzy() {
        playYatzyTest = new HousePlayYatzy();
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_House")
    public void playing_with_House_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_House() {

        // 1,1,2,2,2 scores 8 (1+1+2+2+2)
        // 2,2,3,3,4 scores 0
        // 4,4,4,4,4 scores 0

        return Stream.of(
            Arguments.of(List.of(1,1,2,2,2), Category.HOUSE, 8),
            Arguments.of(List.of(2,2,3,3,4), Category.HOUSE, 0),
            Arguments.of(List.of(4,4,4,4,4), Category.HOUSE, 0)
        );
    }

}
