package pinto.kevin.playing.cards;

/**
 * Playing card data structure api.
 *
 * I decided to go with an interface rather than
 * an enum since interface gives more flexibility to
 * implementation on different types of cards.
 *
 */
public interface PlayingCard {

    String getName();

    PlayingCardType getCardType();

    int getNumericValue();

    String getColor();

}
