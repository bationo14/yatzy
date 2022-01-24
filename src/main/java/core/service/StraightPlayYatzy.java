package core.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StraightPlayYatzy implements Yatzy {

    @Override
    public int getScore(List<Integer> dices, Map<String,Integer> params) {
       boolean orderAsc = dices.stream().sorted().collect(Collectors.toList()).equals(dices);
       int numberTime = params.get("numberTime");
       int scoreWin = numberTime == 1 ? 15 : 20;

        return dices.get(0) == numberTime && orderAsc ? scoreWin : 0;
    }
}
