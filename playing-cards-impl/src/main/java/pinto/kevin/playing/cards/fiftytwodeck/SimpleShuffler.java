package pinto.kevin.playing.cards.fiftytwodeck;

import java.util.List;
import java.util.Random;

public class SimpleShuffler<T> implements Shuffler<T> {

    private Random random;

    public void setRandom(Random random) {
        this.random = random;
    }

    public SimpleShuffler(){
        setRandom(new Random());
    }


    @Override
    public void shuffle(List<T> items) {
        if(items  == null) {
            throw new IllegalArgumentException("Items list not set.");
        }

        for(int i=items.size(); i>0; i--) {
            int pick = random.nextInt(i);
            T item = items.remove(pick);
            items.add(item);
        }
    }
}
