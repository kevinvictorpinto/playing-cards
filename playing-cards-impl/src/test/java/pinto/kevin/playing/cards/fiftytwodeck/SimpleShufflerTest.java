package pinto.kevin.playing.cards.fiftytwodeck;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class SimpleShufflerTest {

    private SimpleShuffler<Integer> shuffler;

    @Before
    public void setup() {
        this.shuffler = new SimpleShuffler<Integer>();
    }



    @Test
    public void testRegularUseCase() {
        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> shuffled = new ArrayList<>();
        HashSet<Integer> expected = new HashSet<>();

        //Test with even number of items
        for(int i=0; i<10; i++) {
            original.add(i);
            shuffled.add(i);
            expected.add(i);
        }

        assertEquals("Lists must match before shuffle.", original, shuffled);

        shuffler.shuffle(shuffled);

        assertEquals("Sizes must match.", original.size(), shuffled.size());

        assertNotEquals("Lists must not match after shuffle.", original, shuffled);

        System.out.println("Initial: " + Arrays.toString(original.toArray()));

        System.out.println("Shuffled: " + Arrays.toString(shuffled.toArray()));

        for(int val : shuffled) {
            assertTrue("Did not find element " + val + " in shuffled list.", expected.remove(val));
        }

        assertEquals("Some elements were missing in shuffled list: " + Arrays.toString(expected.toArray()), 0, expected.size());
    }

    @Test
    public void testEmpty() {
        ArrayList<Integer> input = new ArrayList<>();

        shuffler.shuffle(input);

        assertEquals("List is expected to be empty.", 0, input.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNull() {
        shuffler.shuffle(null);
    }

    @Test
    public void testShuffleRandomness() {
        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> firstShuffle = new ArrayList<>();
        ArrayList<Integer> secondShuffle = new ArrayList<>();

        //Test with odd number of items
        for(int i=0; i<15; i++) {
            original.add(i);
            firstShuffle.add(i);
            secondShuffle.add(i);
        }

        SimpleShuffler<Integer> firstShuffler = new SimpleShuffler<>();
        firstShuffler.shuffle(firstShuffle);

        assertNotEquals("Lists must not match after shuffle.", original, firstShuffle);

        SimpleShuffler<Integer> secondShuffler = new SimpleShuffler<>();
        secondShuffler.shuffle(secondShuffle);

        assertNotEquals("Lists must not match after shuffle.", original, secondShuffle);

        System.out.println("First shuffle: " + Arrays.toString(firstShuffle.toArray()));
        System.out.println("Second shuffle: " + Arrays.toString(secondShuffle.toArray()));
        assertNotEquals("Shuffle must not be repeatable.", firstShuffle, secondShuffle);

    }
}