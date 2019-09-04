package pinto.kevin.playing.cards.fiftytwodeck;

import pinto.kevin.playing.cards.DeckOfCards;
import pinto.kevin.playing.cards.PlayingCard;
import pinto.kevin.playing.cards.PlayingCardFactory;
import pinto.kevin.playing.cards.PlayingCardType;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link PlayingCardFactory} that returns
 * 52 {@link DeckOfCards}.
 */
public class FiftyTwoDeckPlayingCardFactory implements PlayingCardFactory {

    private List<PlayingCardType> cardTypes;

    public FiftyTwoDeckPlayingCardFactory() {
        this.cardTypes = new ArrayList<>();
        this.cardTypes.add(SpadesCardType.INSTANCE);
        this.cardTypes.add(ClubsCardType.INSTANCE);
        this.cardTypes.add(DiamondsCardType.INSTANCE);
        this.cardTypes.add(HeartsCardType.INSTANCE);
    }

    @Override
    public DeckOfCards getDeckOfCards() {
        List<PlayingCard> cards = new ArrayList<>();

        for(PlayingCardType cardType : this.cardTypes) {
            for(CardName cardName : CardName.values()) {
                switch (cardName) {
                    case ACE:
                        cards.add(new SimplePlayingCard(cardName.name(), cardType, 11));
                        break;
                    case KING:
                        cards.add(new SimplePlayingCard(cardName.name(), cardType, 10));
                        break;
                    case QUEEN:
                        cards.add(new SimplePlayingCard(cardName.name(), cardType, 10));
                        break;
                    case JACK:
                        cards.add(new SimplePlayingCard(cardName.name(), cardType, 10));
                        break;
                    case NUMBER:
                        for(int i=2; i<=10; i++) {
                            cards.add(new SimplePlayingCard(i+"", cardType, i));
                        }
                }
            }
        }

        return new FiftyTwoDeckOfCards(cards);
    }
}
