package pinto.kevin.playing.cards;

/**
 * Classic factory method to return implementation
 * of the api.
 */
public interface PlayingCardFactory {

    DeckOfCards getDeckOfCards();
}
