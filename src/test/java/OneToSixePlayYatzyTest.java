import core.constant.Category;
import core.service.OneToSixePlayYatzy;
import core.service.Yatzy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneToSixePlayYatzyTest {

    private Yatzy playYatzyTest;

    @BeforeEach
    public void initYatzy() {
        playYatzyTest = new OneToSixePlayYatzy();
    }

    @ParameterizedTest(name = "{0} placed on {1} give scores {2}")
    @MethodSource("data_provider_for_Play_OneToSixe")
    public void playing_with_OneToSixe_should_return_win_or_lost(List<Integer> dices, Category category, int expectResult) {

        // Arrange
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", category.getNumber());

        // Act
        int actualResult = playYatzyTest.getScore(dices, params);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    private static Stream<Arguments> data_provider_for_Play_OneToSixe() {

        // 1,1,2,4,4 placed on “fours” scores 8 (4+4)
        // 2,3,2,5,1 placed on “twos” scores 4 (2+2)
        // 3,3,3,4,5 placed on “ones” scores 0

        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(1,1,2,4,4)), Category.FOURS, 8),
            Arguments.of(new ArrayList<>(Arrays.asList(2,3,2,5,1)), Category.TWOS, 4),
            Arguments.of(new ArrayList<>(Arrays.asList(3,3,3,4,5)), Category.ONES, 0)
        );
    }
}
