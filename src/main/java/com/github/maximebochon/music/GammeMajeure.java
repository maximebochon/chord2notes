package com.github.maximebochon.music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public class GammeMajeure {

    private static final Logger LOGGER = LoggerFactory.getLogger(GammeMajeure.class);

    private final Note tonique;

    private final List<Note> notes;

    public GammeMajeure(final Note tonique) {
        this.tonique = tonique;

        LOGGER.debug("Construction Gamme Majeure : tonique={}", tonique);

        final List<Note> noteList = new ArrayList<>();

        for (int k = 0; k < 7; ++k)
        {
            final Note note;

            if (k == 0)
            {
                LOGGER.trace("Tonique (k={})", k);
                note = new Note(tonique);
            }
            else
            {
                LOGGER.trace("Autre note (k={})", k);
                note = new Note(noteList.get(k - 1));
                final int écartRéel = note.heptacorde.getDemiTonsVersSuivant();
                final int écartCible = Heptacorde.values()[k - 1].getDemiTonsVersSuivant();
                final int correction = écartCible - écartRéel;
                note.altération = Altération.byDemiTons(note.altération.getDemiTons() + correction);
                note.heptacorde = note.heptacorde.getSuivant();
            }
            LOGGER.trace("Note {} : {}", k, note);

            noteList.add(note);
        }
        this.notes = unmodifiableList(noteList);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public boolean isPraticable() {
        return notes.stream()
           .filter(note -> Math.abs(note.altération.getDemiTons()) > INTEGER_ONE)
           .count() == INTEGER_ZERO;
    }

    @Override
    public String toString() {
        return "GammeMajeure{" +
               "tonique=" + tonique +
               ", notes=" + notes +
               ", praticable=" + isPraticable() +
               '}';
    }
}
