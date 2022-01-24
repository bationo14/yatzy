package core.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PairPlayYatzy implements Yatzy {
    @Override
    public int getScore(List<Integer> dices, Map<String,Integer> params) {

        int maxPair = dices
            .stream()
            .distinct()
            .filter(entry -> Collections.frequency(dices, entry) > 1)
            .sorted()
            .mapToInt(v -> v)
            .max()
            .orElse(0);

        return maxPair + maxPair;
    }
}
