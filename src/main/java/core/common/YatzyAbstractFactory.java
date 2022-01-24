package core.common;

import core.constant.Category;
import core.service.*;

public class YatzyAbstractFactory implements AbstractFactory {
    @Override
    public Yatzy create(Category category) {
        return switch (category) {
            case CHANCE -> new ChancePlayYatzy();
            case YATZY -> new YatzyImpl();
            case PAIR -> new PairPlayYatzy();
            case TWO_PAIRS -> new TwoPairPlayYatzy();
            case HOUSE -> new HousePlayYatzy();
            case THREE_KIND,
                FOUR_KIND -> new KindPlayYatzy();
            case SMALL_STRAIGHT,
                LARGE_STRAIGHT -> new StraightPlayYatzy();
            case ONES,
                TWOS,
                THRESS,
                FOURS,
                FIVES,
                SIXES -> new OneToSixePlayYatzy();
        };
    }
}
