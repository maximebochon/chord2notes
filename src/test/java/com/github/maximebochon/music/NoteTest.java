package com.github.maximebochon.music;

import org.junit.Test;

import static com.github.maximebochon.music.Altération.NATUREL;
import static com.github.maximebochon.music.Heptacorde.DO;
import static org.junit.Assert.assertEquals;

public class NoteTest {

    @Test
    public void test() {
        assertEquals(new Note(DO), new Note(DO, NATUREL));
    }

}