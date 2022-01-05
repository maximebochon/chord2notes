package com.github.maximebochon.music;

import static com.github.maximebochon.music.Altération.NATUREL;

public class Note {
    public Heptacorde heptacorde;
    public Altération altération;

    public Note(final Note note) {
        this.heptacorde = note.heptacorde;
        this.altération = note.altération;
    }

    public Note(final Heptacorde heptacorde) {
        this(heptacorde, NATUREL);
    }

    public Note(final Heptacorde heptacorde, final Altération altération) {
        this.heptacorde = heptacorde;
        this.altération = altération;
    }

    @Override
    public String toString() {
        return heptacorde.toString() + altération.getSymbole();
    }
}
