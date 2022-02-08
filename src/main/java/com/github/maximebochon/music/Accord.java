package com.github.maximebochon.music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Accord {

    private static final Logger LOGGER = LoggerFactory.getLogger(Accord.class);

    private final Note tonique;
    private final NatureAccord nature;
    private final List<Note> notes;

    public Accord(final Note tonique, final NatureAccord nature) {
        LOGGER.debug("Construction Accord : tonique={} nature={}", tonique, nature);

        this.tonique = tonique;
        this.nature = nature;

        final List<Note> gamme = new GammeMajeure(tonique).getNotes();

        this.notes = nature.getIntervalles().stream()
                .map(intervalle -> {
                    final int index = (intervalle.getPosition() - 1) % gamme.size();
                    final Note note = gamme.get(index);
                    note.altération = Altération.byDemiTons(
                            note.altération.getDemiTons() + intervalle.getAltération().getDemiTons()
                    );
                    return note;
                }).collect(toUnmodifiableList());
    }

    public Note getTonique() {
        return tonique;
    }

    public NatureAccord getNature() {
        return nature;
    }

    public List<Note> getNotes() {
        return notes;
    }
}
