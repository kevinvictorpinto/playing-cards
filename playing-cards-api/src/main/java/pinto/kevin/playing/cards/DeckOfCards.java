package pinto.kevin.playing.cards;

import java.util.Iterator;

/**
 * Api for deck of cards.
 */
public interface DeckOfCards {

    /**
     * Deal single card from top of the deck.
     *
     * @return {@link PlayingCard}
     * @throws DeckOfCardsEmptyException
     */
    PlayingCard dealOneCard() throws DeckOfCardsEmptyException;

    /**
     * Shuffle the deck of card.
     */
    void shuffle();

    /**
     * Implementation must return an iterator to view cards irrespective of
     * data structure used.
     *
     * @return
     */
    Iterator<PlayingCard> getIterator();
}
