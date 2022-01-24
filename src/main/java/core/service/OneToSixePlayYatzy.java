package core.service;

import java.util.List;
import java.util.Map;

public class OneToSixePlayYatzy implements Yatzy {
    @Override
    public int getScore(List<Integer> dices, Map<String,Integer> params) {
        int numberTime = params.get("numberTime");
        return dices
            .stream()
            .filter( dice -> dice == numberTime )
            .mapToInt(Integer::intValue)
            .sum();
    }
}
