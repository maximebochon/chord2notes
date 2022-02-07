package com.github.maximebochon.music;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static com.github.maximebochon.music.Heptacorde.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

public class HeptacordeTest {
    /**
     * Douze demi-tons dans une octave
     */
    @Test
    public void douzeDemiTonsDansUneOctave()
    {
        final int expected = 12;
        assertEquals(expected, Heptacorde.DEMI_TONS_OCTAVE);
    }

    /**
     * Notes suivies d'un ton (do, ré, fa, sol la)
     */
    @Test
    public void notesSuiviesD1Ton() {
        final Set<Integer> actual = Stream.of(DO, RÉ, FA, SOL, LA)
                .map(Heptacorde::getDemiTonsVersSuivant)
                .collect(toSet());

        final Set<Integer> expected = Stream.of(2).collect(toSet());

        assertEquals(expected, actual);
    }

    /**
     * Notes suivies d'un demi-ton (mi, si)
     */
    @Test
    public void notesSuiviesD1DemiTon() {
        final Set<Integer> actual = Stream.of(MI, SI)
                .map(Heptacorde::getDemiTonsVersSuivant)
                .collect(toSet());

        final Set<Integer> expected = Stream.of(1).collect(toSet());

        assertEquals(expected, actual);
    }

    /**
     * Notation anglo-saxonne
     */
    @Test
    public void notations() {
        final String actual = Arrays.stream(values())
                .map(Heptacorde::getNotation)
                .map(String::valueOf)
                .collect(joining(","));

        final String expected = "C,D,E,F,G,A,B";

        assertEquals(expected, actual);
    }
}