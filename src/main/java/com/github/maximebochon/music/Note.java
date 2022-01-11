package com.github.maximebochon.music;

import com.google.common.base.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return heptacorde == note.heptacorde && altération == note.altération;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(heptacorde, altération);
    }

    @Override
    public String toString() {
        return heptacorde.toString() + altération.getSymbole();
    }
}
