package pinto.kevin.playing.cards.fiftytwodeck;

import pinto.kevin.playing.cards.PlayingCard;
import pinto.kevin.playing.cards.PlayingCardType;

import java.util.Objects;

import static pinto.kevin.playing.cards.fiftytwodeck.ClubsCardType.CLUBS;
import static pinto.kevin.playing.cards.fiftytwodeck.DiamondsCardType.DIAMONDS;
import static pinto.kevin.playing.cards.fiftytwodeck.HeartsCardType.HEARTS;
import static pinto.kevin.playing.cards.fiftytwodeck.SpadesCardType.SPADES;


public class SimplePlayingCard implements PlayingCard {

    private String name;
    private PlayingCardType playingCardType;
    private String color;
    private int numericValue;

    public SimplePlayingCard(String name, PlayingCardType playingCardType, int numericValue) {
        this.name = name;
        this.playingCardType = playingCardType;
        this.numericValue = numericValue;

        switch(playingCardType.getTypeName()){
            case SPADES:
            case CLUBS:
                this.color = "black";
                break;
            case HEARTS:
            case DIAMONDS:
                this.color = "read";
                break;
            default:
                throw new IllegalArgumentException(playingCardType.getTypeName() + " color logic has not been implemented.");
        }


    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public PlayingCardType getCardType() {
        return playingCardType;
    }

    @Override
    public int getNumericValue() {
        return numericValue;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getName() + " of " + getCardType().getTypeName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplePlayingCard that = (SimplePlayingCard) o;
        return numericValue == that.numericValue &&
                Objects.equals(name, that.name) &&
                Objects.equals(playingCardType, that.playingCardType) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, playingCardType, color, numericValue);
    }
}
