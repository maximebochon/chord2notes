package com.github.maximebochon.music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Accord {

    private static final Logger LOGGER = LoggerFactory.getLogger(Accord.class);

    private final List<Note> notes;

    public Accord(final Note tonique, final List<Intervalle> intervalles) {
        LOGGER.debug("Construction Accord : tonique={} intervalles={}", tonique, intervalles);

        final List<Note> gamme = new GammeMajeure(tonique).getNotes();
        this.notes = intervalles.stream()
                .map(intervalle -> {
                    final int index = (intervalle.getPosition() - 1) % gamme.size();
                    final Note note = gamme.get(index);
                    note.altération = Altération.byDemiTons(
                            note.altération.getDemiTons() + intervalle.getAltération().getDemiTons()
                    );
                    return note;
                }).collect(toUnmodifiableList());
    }

    public List<Note> getNotes() {
        return notes;
    }
}
