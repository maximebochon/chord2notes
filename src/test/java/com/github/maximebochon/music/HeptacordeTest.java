package com.github.maximebochon.music;

import org.junit.Test;

import java.util.Set;
import java.util.stream.Stream;

import static com.github.maximebochon.music.Heptacorde.*;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

public class HeptacordeTest {
    /**
     * Douze demi-tons dans une octave
     */
    @Test
    public void douzeDemiTonsDansUneOctave()
    {
        final int exptected = 12;
        assertEquals(exptected, Heptacorde.DEMI_TONS_OCTAVE);
    }

    @Test
    public void notesSuiviesD1Ton() {
        final Set<Integer> actual = Stream.of(DO, RÉ, FA, SOL, LA)
                .map(Heptacorde::getDemiTonsVersSuivant)
                .collect(toSet());

        final Set<Integer> expected = Stream.of(2).collect(toSet());

        assertEquals(expected, actual);
    }
}