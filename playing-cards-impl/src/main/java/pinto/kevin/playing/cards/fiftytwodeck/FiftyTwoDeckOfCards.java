package pinto.kevin.playing.cards.fiftytwodeck;

import pinto.kevin.playing.cards.DeckOfCards;
import pinto.kevin.playing.cards.DeckOfCardsEmptyException;
import pinto.kevin.playing.cards.PlayingCard;

import java.util.*;

public class FiftyTwoDeckOfCards implements DeckOfCards {

    private LinkedList<PlayingCard> cards;

    private Shuffler<PlayingCard> shuffler;


    public FiftyTwoDeckOfCards(List<PlayingCard> cards) {
        this.cards = new LinkedList<>();
        this.shuffler = new SimpleShuffler<>();

        for(PlayingCard card : cards) {
            this.cards.push(card);
        }
    }

    @Override
    public PlayingCard deal() throws DeckOfCardsEmptyException {
        if(this.cards.size() <= 0) {
            throw new DeckOfCardsEmptyException();
        }

        return this.cards.remove();
    }

    @Override
    public void shuffle() {
        this.shuffler.shuffle(cards);
    }

    @Override
    public Iterator<PlayingCard> getIterator() {
        return this.cards.iterator();
    }

    public void setShuffler(Shuffler<PlayingCard> shuffler) {
        this.shuffler = shuffler;
    }
}
