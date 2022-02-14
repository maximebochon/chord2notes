package com.github.maximebochon.music;

import java.util.List;

import static com.github.maximebochon.music.Altération.BÉMOL;
import static com.github.maximebochon.music.Altération.DIÈSE;
import static com.github.maximebochon.music.Intervalle.I;
import static java.util.Arrays.asList;

public enum NatureAccord {
    MAJEUR("", false,
            asList(I(1), I(3), I(5))),
    MAJEUR_SEPT("Δ", false,
            asList(I(1), I(3), I(5), I(7))),
    SEPT("7", false,
            asList(I(1), I(3), I(5), I(7, BÉMOL))),

    MINEUR("−", false,
            asList(I(1), I(3, BÉMOL), I(5))),
    MINEUR_SEPT("−7", false,
            asList(I(1), I(3, BÉMOL), I(5), I(7, BÉMOL))),

    DIMINUÉ("O", true,
            asList(I(1), I(3, BÉMOL), I(5, BÉMOL))),
    SEMI_DIMINUÉ("Ø", true,
            asList(I(1), I(3, BÉMOL), I(5, BÉMOL), I(7, BÉMOL))),

    AUGMENTÉ("+", false,
            asList(I(1), I(3), I(5, DIÈSE)));

    private final String suffixe;
    private final boolean exposant;
    private final List<Intervalle> intervalles;

    NatureAccord(final String suffixe, final boolean exposant, final List<Intervalle> intervalles) {
        this.suffixe = suffixe;
        this.exposant = exposant;
        this.intervalles = intervalles;
    }

    public String getSuffixe() {
        return suffixe;
    }

    public boolean isExposant() {
        return exposant;
    }

    public List<Intervalle> getIntervalles() {
        return intervalles;
    }
}
