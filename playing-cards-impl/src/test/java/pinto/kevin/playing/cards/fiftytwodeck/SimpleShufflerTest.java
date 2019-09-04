package pinto.kevin.playing.cards.fiftytwodeck;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleShufflerTest {

    private SimpleShuffler<Integer> shuffler;

    @Before
    public void setup() {
        this.shuffler = new SimpleShuffler();
    }

    @Test
    public void testRegularUseCase() {
        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> shuffled = new ArrayList<>();
        for(int i=0; i<10; i++) {
            original.add(i);
            shuffled.add(i);
        }

        shuffler.shuffle(shuffled);

        Assert.assertArrayEquals();

    }

    public void testEmpty() {

    }

    public void testNull() {

    }

    public void testShuffleRandomness() {

    }
}