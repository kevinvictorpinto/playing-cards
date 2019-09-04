package pinto.kevin.playing.cards.fiftytwodeck;

import java.util.List;

/**
 * Api for shuffler so that shuffler
 * can be changed if need be.
 * @param <T>
 */
public interface Shuffler<T> {

    void shuffle(List<T> items);
}
