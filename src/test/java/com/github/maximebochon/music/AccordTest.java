package com.github.maximebochon.music;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.github.maximebochon.music.Altération.*;
import static com.github.maximebochon.music.Heptacorde.DO;
import static com.github.maximebochon.music.Heptacorde.LA;
import static com.github.maximebochon.music.Intervalle.I;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class AccordTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccordTest.class);

    private static final List<Intervalle> MINEUR = asList(I(1), I(3, BÉMOL), I(5));
    private static final List<Intervalle> MAJEUR = asList(I(1), I(3), I(5));
    private static final List<Intervalle> SEPT = asList(I(1), I(3), I(5), I(7, BÉMOL));
    private static final List<Intervalle> Δ = asList(I(1), I(3), I(5), I(7));
    private static final List<Intervalle> Ø = asList(I(1), I(3, BÉMOL), I(5, BÉMOL), I(7, BÉMOL));

    private void testerAccord(final Note tonique, final List<Intervalle> intervalles, String expectedAccord) {
        final Accord accord = new Accord(tonique, intervalles);
        expectedAccord = expectedAccord
                .replace("##", DOUBLE_DIÈSE.getSymbole())
                .replace("#", DIÈSE.getSymbole())
                .replace("bb", DOUBLE_BÉMOL.getSymbole())
                .replace("b", BÉMOL.getSymbole());
        assertEquals(expectedAccord, accord.getNotes().toString());
    }

    @Test
    public void accordDoMajeur() {
        testerAccord(new Note(DO), MAJEUR, "[DO, MI, SOL]");
    }

    @Test
    public void accordDoMineur() {
        testerAccord(new Note(DO), MINEUR, "[DO, MIb, SOL]");
    }

    @Test
    public void accordDoSemiDiminué() {
        testerAccord(new Note(DO), Ø, "[DO, MIb, SOLb, SIb]");
    }

    @Test
    public void accordDoSept() {
        testerAccord(new Note(DO), SEPT, "[DO, MI, SOL, SIb]");
    }

    @Test
    public void accordDoMajeurSept() {
        testerAccord(new Note(DO), Δ, "[DO, MI, SOL, SI]");
    }

    @Test
    public void accordLaMajeur() {
        testerAccord(new Note(LA), MAJEUR, "[LA, DO#, MI]");
    }

    @Test
    public void accordLaMineur() {
        testerAccord(new Note(LA), MINEUR, "[LA, DO, MI]");
    }

}
