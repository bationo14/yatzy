package core.service;

import java.util.List;
import java.util.Map;

/**
 * Represent the class who manage the scores.
 */
public interface Yatzy {

    /**
     * cacul and give score
     * @param dices
     * @param params
     * @return scores
     */
    int getScore(List<Integer> dices, Map<String,Integer> params);
}
