package core.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class KindPlayYatzy implements Yatzy {
    @Override
    public int getScore(List<Integer> dices, Map<String,Integer> params) {
        int numberTime = params.get("numberTime");
        int dice = dices
            .stream()
            .filter(entry -> Collections.frequency(dices, entry) >= numberTime)
            .mapToInt(v -> v)
            .max()
            .orElse(0);

        return dice != 0 ? dice * numberTime : dice;
    }
}
