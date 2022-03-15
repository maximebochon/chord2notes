package com.github.maximebochon.music;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.maximebochon.music.Altération.*;
import static com.github.maximebochon.music.Heptacorde.DO;
import static com.github.maximebochon.music.Heptacorde.LA;
import static com.github.maximebochon.music.NatureAccord.*;
import static org.junit.Assert.assertEquals;

public class AccordTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccordTest.class);

    private void testerAccord(final Note tonique, final NatureAccord nature, String expectedAccord) {
        final Accord accord = new Accord(tonique, nature);
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
    public void accordDoMajeurSept() {
        testerAccord(new Note(DO), MAJEUR_SEPT, "[DO, MI, SOL, SI]");
    }

    @Test
    public void accordDoSept() {
        testerAccord(new Note(DO), SEPT, "[DO, MI, SOL, SIb]");
    }

    @Test
    public void accordDoMineur() {
        testerAccord(new Note(DO), MINEUR, "[DO, MIb, SOL]");
    }

    @Test
    public void accordDoMineurSept() {
        testerAccord(new Note(DO), MINEUR_SEPT, "[DO, MIb, SOL, SIb]");
    }

    @Test
    public void accordDoMineurMajeurSept() {
        testerAccord(new Note(DO), MINEUR_MAJEUR_SEPT, "[DO, MIb, SOL, SI]");
    }

    @Test
    public void accordDoDiminué() {
        testerAccord(new Note(DO), DIMINUÉ, "[DO, MIb, SOLb]");
    }

    @Test
    public void accordDoSemiDiminué() {
        testerAccord(new Note(DO), SEMI_DIMINUÉ, "[DO, MIb, SOLb, SIb]");
    }

    @Test
    public void accordLaMajeur() {
        testerAccord(new Note(LA), MAJEUR, "[LA, DO#, MI]");
    }

    @Test
    public void accordLaMajeurSept() {
        testerAccord(new Note(LA), MAJEUR_SEPT, "[LA, DO#, MI, SOL#]");
    }

    @Test
    public void accordLaSept() {
        testerAccord(new Note(LA), SEPT, "[LA, DO#, MI, SOL]");
    }

    @Test
    public void accordLaMineur() {
        testerAccord(new Note(LA), MINEUR, "[LA, DO, MI]");
    }

    @Test
    public void accordLaMineurSept() {
        testerAccord(new Note(LA), MINEUR_SEPT, "[LA, DO, MI, SOL]");
    }

    @Test
    public void accordLaDiminué() {
        testerAccord(new Note(LA), DIMINUÉ, "[LA, DO, MIb]");
    }

    @Test
    public void accordLaSemiDiminué() {
        testerAccord(new Note(LA), SEMI_DIMINUÉ, "[LA, DO, MIb, SOL]");
    }

}
