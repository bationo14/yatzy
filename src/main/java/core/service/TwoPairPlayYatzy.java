package core.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoPairPlayYatzy implements Yatzy {
    @Override
    public int getScore(List<Integer> dices, Map<String,Integer> params) {
        Set<Integer> diceStream = dices
            .stream()
            .filter(entry -> Collections.frequency(dices, entry) > 1)
            .collect(Collectors.toSet());

        return diceStream.size() > 1 ? diceStream.stream().reduce(0, (a, b) -> a + (b * 2)) : 0;
    }
}
