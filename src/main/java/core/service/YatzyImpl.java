package core.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class YatzyImpl implements Yatzy {

    @Override
    public int getScore(List<Integer> dices, Map<String,Integer> params) {
        Set<Integer> filterList = new TreeSet<>(dices);
        return filterList.size() == 1 ? 50 : 0;
    }
}
