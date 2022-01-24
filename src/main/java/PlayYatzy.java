import core.constant.Category;
import core.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Play core.service.Yatzy main Action
 */
public class PlayYatzy {

    private List<Integer> dices = new ArrayList<>();
    private Category category;

    public PlayYatzy() {
    }

    /**
     * Match and get score
     * @param dices
     * @param category
     * @return scores in relation to category
     */
    public int score(List<Integer> dices, Category category) {

        if(dices.size() != 5 || category == null ){
            throw new IllegalStateException("Dices or core.constant.Category don't valid");
        }

        this.dices = dices;
        this.category = category;

        return switch (category) {
            case CHANCE -> playing(new ChancePlayYatzy());
            case YATZY -> playing(new YatzyImpl());
            case PAIR -> playing(new PairPlayYatzy());
            case TWO_PAIRS -> playing(new TwoPairPlayYatzy());
            case HOUSE -> playing(new HousePlayYatzy());
            case THREE_KIND,
                 FOUR_KIND -> playing(new KindPlayYatzy());
            case SMALL_STRAIGHT,
                 LARGE_STRAIGHT -> playing(new StraightPlayYatzy());
            case ONES,
                 TWOS,
                 THRESS,
                 FOURS,
                 FIVES,
                 SIXES -> playing(new OneToSixePlayYatzy());
        };
    }

    /**
     * get and give score with category
     * @param yatzy
     * @return scores
     */
    private int playing(Yatzy yatzy){
        Map<String,Integer> params = new HashMap<>();
        params.put("numberTime", this.category.getNumber());
        return yatzy.getScore(this.dices, params);
    }
}



