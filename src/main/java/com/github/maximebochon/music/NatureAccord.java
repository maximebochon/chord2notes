package com.github.maximebochon.music;

import java.util.List;

import static com.github.maximebochon.music.Altération.BÉMOL;
import static com.github.maximebochon.music.Intervalle.I;
import static java.util.Arrays.asList;

public enum NatureAccord {
    MAJEUR("", asList(I(1), I(3), I(5))),
    MAJEUR_SEPT("Δ", asList(I(1), I(3), I(5), I(7))),
    SEPT("7", asList(I(1), I(3), I(5), I(7, BÉMOL))),

    MINEUR("-", asList(I(1), I(3, BÉMOL), I(5))),
    MINEUR_SEPT("-7", asList(I(1), I(3, BÉMOL), I(5), I(7, BÉMOL))),

    DIMINUÉ("O", asList(I(1), I(3, BÉMOL), I(5, BÉMOL))),
    SEMI_DIMINUÉ("Ø", asList(I(1), I(3, BÉMOL), I(5, BÉMOL), I(7, BÉMOL)));

    private String suffixe;
    private final List<Intervalle> intervalles;

    NatureAccord(final String suffixe, final List<Intervalle> intervalles) {
        this.suffixe = suffixe;
        this.intervalles = intervalles;
    }

    public String getSuffixe() {
        return suffixe;
    }

    public List<Intervalle> getIntervalles() {
        return intervalles;
    }
}
