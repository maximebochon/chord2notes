package com.github.maximebochon.music;

import org.junit.Test;

import static com.github.maximebochon.music.Altération.*;
import static org.junit.Assert.assertEquals;

public class AltérationTest {

    @Test
    public void getSymbole() {
        assertEquals("", NATUREL.getSymbole());
        assertEquals("♯", DIÈSE.getSymbole());
    }

    @Test
    public void getDemiTons() {
        assertEquals(-2, DOUBLE_BÉMOL.getDemiTons());
        assertEquals(0, NATUREL.getDemiTons());
        assertEquals(1, DIÈSE.getDemiTons());
    }

    @Test
    public void byDemiTons() {
        assertEquals(BÉMOL, Altération.byDemiTons(-1));
        assertEquals(NATUREL, Altération.byDemiTons(0));
        assertEquals(DOUBLE_DIÈSE, Altération.byDemiTons(2));
    }

    @Test
    public void values() {
        assertEquals(5, Altération.values().length);
    }

    @Test
    public void ordinal() {
        assertEquals(0, DOUBLE_BÉMOL.ordinal());
        assertEquals(4, DOUBLE_DIÈSE.ordinal());
    }

    @Test
    public void valueOf() {
        assertEquals(DOUBLE_BÉMOL, Altération.valueOf("DOUBLE_BÉMOL"));
    }
}