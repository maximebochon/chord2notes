package com.github.maximebochon.music;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public enum Heptacorde {
    DO(2, 'C'),
    RÉ(2, 'D'),
    MI(1, 'E'),
    FA(2, 'F'),
    SOL(2, 'G'),
    LA(2, 'A'),
    SI(1, 'B');

    public final static int DEMI_TONS_OCTAVE = stream(Heptacorde.values())
            .map(Heptacorde::getDemiTonsVersSuivant)
            .reduce(INTEGER_ZERO, Integer::sum);

    private final int demiTonsVersSuivant;
    private final char notation;

    Heptacorde(final int demiTonsVersSuivant, final char notation) {
        this.demiTonsVersSuivant = demiTonsVersSuivant;
        this.notation = notation;
    }

    public int getDemiTonsVersSuivant() {
        return demiTonsVersSuivant;
    }

    public char getNotation() {
        return notation;
    }

    public Heptacorde getSuivant() {
        final int indexSuivant = (this.ordinal() + 1) % Heptacorde.values().length;
        return Heptacorde.values()[indexSuivant];
    }
}
