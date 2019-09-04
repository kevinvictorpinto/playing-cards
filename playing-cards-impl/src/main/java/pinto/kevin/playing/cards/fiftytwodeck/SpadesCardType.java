package pinto.kevin.playing.cards.fiftytwodeck;

import pinto.kevin.playing.cards.PlayingCardType;

import java.util.Objects;

public class SpadesCardType implements PlayingCardType {

    static final String SPADES = "spades";

    public static final SpadesCardType INSTANCE = new SpadesCardType();

    private SpadesCardType() {}


    @Override
    public String getTypeName() {
        return SPADES;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpadesCardType)) return false;
        SpadesCardType that = (SpadesCardType) o;
        return Objects.equals(SPADES, that.getTypeName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(SPADES);
    }

    @Override
    public String toString() {
        return SPADES;
    }
}
