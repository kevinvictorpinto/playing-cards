package pinto.kevin.playing.cards.fiftytwodeck;

import pinto.kevin.playing.cards.PlayingCardType;

import java.util.Objects;

public class HeartsCardType implements PlayingCardType {

    public static final HeartsCardType INSTANCE = new HeartsCardType();

    private HeartsCardType() {}

    static final String HEARTS = "hearts";

    @Override
    public String getTypeName() {
        return HEARTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeartsCardType)) return false;
        HeartsCardType that = (HeartsCardType) o;
        return Objects.equals(HEARTS, that.getTypeName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(HEARTS);
    }

    @Override
    public String toString() {
        return HEARTS;
    }
}
