package pinto.kevin.playing.cards.fiftytwodeck;

import pinto.kevin.playing.cards.PlayingCard;
import pinto.kevin.playing.cards.PlayingCardType;

import static pinto.kevin.playing.cards.fiftytwodeck.ClubsCardType.CLUBS;
import static pinto.kevin.playing.cards.fiftytwodeck.DiamondsCardType.DIAMONDS;
import static pinto.kevin.playing.cards.fiftytwodeck.HeartsCardType.HEARTS;
import static pinto.kevin.playing.cards.fiftytwodeck.SpadesCardType.SPADES;

/**
 * Default playing card implementation that also
 * has default simple shuffler implementation
 * initialized.
 */
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
                this.color = "black";
                break;
            case HEARTS:
                this.color = "red";
                break;
            case CLUBS:
                this.color = "black";
                break;
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
}
