package core.service;

import java.util.List;
import java.util.Map;

public class ChancePlayYatzy implements Yatzy {

    @Override
    public int getScore(List<Integer> dices, Map<String,Integer> params) {
        return dices
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
