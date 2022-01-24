package core.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HousePlayYatzy implements Yatzy {
    @Override
    public int getScore(List<Integer> dices, Map<String,Integer> params) {
        int twoTime = 2;
        int treeTime = 3;
        List<Integer> listTwoTime = getNumberInTime(dices, twoTime);
        List<Integer> listTreeTime = getNumberInTime(dices, treeTime);

        return listTwoTime.size() == twoTime && listTreeTime.size() == treeTime ?
            dices.stream().mapToInt(Integer::intValue).sum() :
            0;
    }

    private List<Integer> getNumberInTime(List<Integer> dices, int time){
        return dices
            .stream()
            .filter(entry -> Collections.frequency(dices, entry) == time)
            .collect(Collectors.toList());
    }
}
