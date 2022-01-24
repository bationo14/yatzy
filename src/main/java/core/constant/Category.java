package core.constant;

/**
 *  Category that can be used
 */
public enum Category {
    CHANCE,
    YATZY,
    ONES (1),
    TWOS(2),
    THRESS(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    PAIR,
    TWO_PAIRS,
    THREE_KIND(3),
    FOUR_KIND(4),
    SMALL_STRAIGHT(1),
    LARGE_STRAIGHT(2),
    HOUSE;

    private int number;

    Category() {
    }
    Category(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
