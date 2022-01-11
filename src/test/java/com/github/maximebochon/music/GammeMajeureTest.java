package com.github.maximebochon.music;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.maximebochon.music.Altération.*;
import static com.github.maximebochon.music.Heptacorde.*;
import static org.junit.Assert.assertEquals;

public class GammeMajeureTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GammeMajeureTest.class);

    private void testerGammeMajeure(final Note tonique, String expectedGamme) {
        final GammeMajeure gamme = new GammeMajeure(tonique);
        expectedGamme = expectedGamme
                .replace("##", DOUBLE_DIÈSE.getSymbole())
                .replace("#", DIÈSE.getSymbole())
                .replace("b", BÉMOL.getSymbole())
                .replace("bb", DOUBLE_BÉMOL.getSymbole());
        assertEquals(expectedGamme, gamme.getNotes().toString());
    }

    @Test
    public void doMajeur() {
        testerGammeMajeure(new Note(DO), "[DO, RÉ, MI, FA, SOL, LA, SI]");
    }

    @Test
    public void doDièseMajeur() {
        testerGammeMajeure(new Note(DO, DIÈSE), "[DO#, RÉ#, MI#, FA#, SOL#, LA#, SI#]");
    }

    @Test
    public void réMajeur() {
        testerGammeMajeure(new Note(RÉ), "[RÉ, MI, FA#, SOL, LA, SI, DO#]");
    }

    @Test
    public void miBémolMajeur() {
        testerGammeMajeure(new Note(MI, BÉMOL), "[MIb, FA, SOL, LAb, SIb, DO, RÉ]");
    }

    @Test
    public void faMajeur() {
        testerGammeMajeure(new Note(FA), "[FA, SOL, LA, SIb, DO, RÉ, MI]");
    }

    @Test
    public void solMajeur() {
        testerGammeMajeure(new Note(SOL), "[SOL, LA, SI, DO, RÉ, MI, FA#]");
    }

    @Test
    public void solDièseMajeur() {
        testerGammeMajeure(new Note(SOL, DIÈSE), "[SOL#, LA#, SI#, DO#, RÉ#, MI#, FA##]");
    }

    @Test
    public void laBémolMajeur() {
        testerGammeMajeure(new Note(LA, BÉMOL), "[LAb, SIb, DO, RÉb, MIb, FA, SOL]");
    }

    @Test
    public void laMajeur() {
        testerGammeMajeure(new Note(LA), "[LA, SI, DO#, RÉ, MI, FA#, SOL#]");
    }

    @Test
    public void laDièseMajeur() {
        testerGammeMajeure(new Note(LA, DIÈSE), "[LA#, SI#, DO##, RÉ#, MI#, FA##, SOL##]");
    }
}