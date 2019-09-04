package pinto.kevin.playing.cards.fiftytwodeck;

import org.junit.Before;
import org.junit.Test;
import pinto.kevin.playing.cards.*;

import java.util.*;

import static org.junit.Assert.*;
import static pinto.kevin.playing.cards.fiftytwodeck.FiftyTwoDeckPlayingCardFactory.CardNameTypes.*;

public class FiftyTwoDeckOfCardsTest {

    private PlayingCardFactory factory;

    @Before
    public void setup() {
        this.factory = new FiftyTwoDeckPlayingCardFactory();
    }

    @Test
    public void test52Deck() {

        DeckOfCards deckOfCards = factory.getDeckOfCards();

        List<PlayingCard> actualCards = new ArrayList<>();

        Iterator<PlayingCard> deckOfCardsIterator = deckOfCards.getIterator();

        while(deckOfCardsIterator.hasNext()) {
            actualCards.add(deckOfCardsIterator.next());
        }

        assertEquals("Expected 52 cards in a deck", 52, actualCards.size());

        HashSet<PlayingCard> expected = new HashSet<>();
        ArrayList<PlayingCardType> cardTypes = new ArrayList<>();
        cardTypes.add(SpadesCardType.INSTANCE);
        cardTypes.add(ClubsCardType.INSTANCE);
        cardTypes.add(DiamondsCardType.INSTANCE);
        cardTypes.add(HeartsCardType.INSTANCE);
        for(PlayingCardType cardType : cardTypes) {
            expected.add(new SimplePlayingCard(ACE.name(), cardType, 11));
            expected.add(new SimplePlayingCard(KING.name(), cardType, 10));
            expected.add(new SimplePlayingCard(QUEEN.name(), cardType, 10));
            expected.add(new SimplePlayingCard(JACK.name(), cardType, 10));
            for(int i=2; i<=10; i++) {
                expected.add(new SimplePlayingCard(i+"", cardType, i));
            }
        }
        assertEquals("Expected 52 cards in auto generated expected compare deck.", 52, expected.size());


        for(PlayingCard actual: actualCards) {
            assertTrue("Unexpected card " + actual + ", " + actual.getColor() + ", " + actual.getCardType().getTypeName(), expected.remove(actual));
        }

        assertEquals("Some elements were missing in actual deck: " + Arrays.toString(expected.toArray()), 0, expected.size());
    }

    @Test
    public void testDealOneCard() throws DeckOfCardsEmptyException {
        DeckOfCards deckOfCards = factory.getDeckOfCards();

        List<PlayingCard> expectedCards = new ArrayList<>();

        Iterator<PlayingCard> deckOfCardsIterator = deckOfCards.getIterator();

        while(deckOfCardsIterator.hasNext()) {
            expectedCards.add(deckOfCardsIterator.next());
        }

        assertEquals("Expected 52 cards in a deck", 52, expectedCards.size());

        for(int i=0; i<52; i++) {
            PlayingCard dealedCard = deckOfCards.dealOneCard();
            assertEquals("Unexpected card " + dealedCard, expectedCards.get(i), dealedCard);
        }

        try {
            deckOfCards.dealOneCard();
            fail("Expected " + DeckOfCardsEmptyException.class.getSimpleName());
        }catch (DeckOfCardsEmptyException e) {
            //do nothing.
        }
    }

    @Test
    public void testShuffle() throws DeckOfCardsEmptyException {
        DeckOfCards deckOfCards = factory.getDeckOfCards();

        List<PlayingCard> expectedCards = new ArrayList<>();
        {
            Iterator<PlayingCard> deckOfCardsIterator = deckOfCards.getIterator();

            while(deckOfCardsIterator.hasNext()) {
                expectedCards.add(deckOfCardsIterator.next());
            }

            assertEquals("Expected 52 cards in a deck", 52, expectedCards.size());
        }


        deckOfCards.shuffle();

        List<PlayingCard> shuffledCards = new ArrayList<>();
        {
            Iterator<PlayingCard> deckOfCardsIterator = deckOfCards.getIterator();

            while(deckOfCardsIterator.hasNext()) {
                shuffledCards.add(deckOfCardsIterator.next());
            }

            assertEquals("Expected 52 cards in a deck", 52, shuffledCards.size());
        }

        assertNotEquals("Shuffled deck must not match.", expectedCards, shuffledCards);

        for(int i=0; i<52; i++) {
            PlayingCard dealedCard = deckOfCards.dealOneCard();
            assertEquals("Unexpected card " + dealedCard, shuffledCards.get(i), dealedCard);
        }
    }

}
