package pinto.kevin.playing.cards.fiftytwodeck;

import pinto.kevin.playing.cards.PlayingCardType;

import java.util.Objects;

public class DiamondsCardType implements PlayingCardType {

    public static final DiamondsCardType INSTANCE = new DiamondsCardType();

    private DiamondsCardType() {}

    static final String DIAMONDS = "diamonds";

    @Override
    public String getTypeName() {
        return DIAMONDS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiamondsCardType)) return false;
        DiamondsCardType that = (DiamondsCardType) o;
        return Objects.equals(DIAMONDS, that.getTypeName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(DIAMONDS);
    }

    @Override
    public String toString() {
        return DIAMONDS;
    }
}
