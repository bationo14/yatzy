import core.constant.Category;
import core.service.Yatzy;
import core.service.YatzyImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyPlayTest {

    private Yatzy playYatzyTest;

    @BeforeEach
    public void initYatzy() {
        playYatzyTest = new YatzyImpl();
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_Yatzy")
    public void playing_with_Yatzy_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_Yatzy() {

        // 1,1,1,1,1 placed on “yatzy” scores 50
        // 1,1,1,2,1 placed on “yatzy” scores 0

        return Stream.of(
            Arguments.of(List.of(1,1,1,1,1), Category.YATZY, 50),
            Arguments.of(List.of(1,1,1,2,1), Category.YATZY, 0)
        );
    }
}
