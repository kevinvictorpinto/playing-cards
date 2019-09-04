package pinto.kevin.playing.cards.fiftytwodeck;

import pinto.kevin.playing.cards.PlayingCardType;

import java.util.Objects;

public class ClubsCardType implements PlayingCardType {

    public static final ClubsCardType INSTANCE = new ClubsCardType();

    private ClubsCardType() {}

    static final String CLUBS = "clubs";

    @Override
    public String getTypeName() {
        return CLUBS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClubsCardType)) return false;
        ClubsCardType that = (ClubsCardType) o;
        return Objects.equals(CLUBS, that.getTypeName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(CLUBS);
    }

    @Override
    public String toString() {
        return CLUBS;
    }
}
