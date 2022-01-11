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
                .replace("bb", DOUBLE_BÉMOL.getSymbole())
                .replace("b", BÉMOL.getSymbole());
        assertEquals(expectedGamme, gamme.getNotes().toString());
    }

    @Test
    public void doBémolMajeur() {
        testerGammeMajeure(new Note(DO, BÉMOL), "[DOb, RÉb, MIb, FAb, SOLb, LAb, SIb]");
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
    public void réBémolMajeur() {
        testerGammeMajeure(new Note(RÉ, BÉMOL), "[RÉb, MIb, FA, SOLb, LAb, SIb, DO]");
    }

    @Test
    public void réMajeur() {
        testerGammeMajeure(new Note(RÉ), "[RÉ, MI, FA#, SOL, LA, SI, DO#]");
    }

    @Test
    public void réDièseMajeur() {
        testerGammeMajeure(new Note(RÉ, DIÈSE), "[RÉ#, MI#, FA##, SOL#, LA#, SI#, DO##]");
    }

    @Test
    public void miBémolMajeur() {
        testerGammeMajeure(new Note(MI, BÉMOL), "[MIb, FA, SOL, LAb, SIb, DO, RÉ]");
    }

    @Test
    public void miMajeur() {
        testerGammeMajeure(new Note(MI), "[MI, FA#, SOL#, LA, SI, DO#, RÉ#]");
    }

    @Test
    public void miDièseMajeur() {
        testerGammeMajeure(new Note(MI, DIÈSE), "[MI#, FA##, SOL##, LA#, SI#, DO##, RÉ##]");
    }

    @Test
    public void faBémolMajeur() {
        testerGammeMajeure(new Note(FA, BÉMOL), "[FAb, SOLb, LAb, SIbb, DOb, RÉb, MIb]");
    }

    @Test
    public void faMajeur() {
        testerGammeMajeure(new Note(FA), "[FA, SOL, LA, SIb, DO, RÉ, MI]");
    }

    @Test
    public void faDièseMajeur() {
        testerGammeMajeure(new Note(FA, DIÈSE), "[FA#, SOL#, LA#, SI, DO#, RÉ#, MI#]");
    }

    @Test
    public void solBémolMajeur() {
        testerGammeMajeure(new Note(SOL, BÉMOL), "[SOLb, LAb, SIb, DOb, RÉb, MIb, FA]");
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

    @Test
    public void siBémolMajeur() {
        testerGammeMajeure(new Note(SI, BÉMOL), "[SIb, DO, RÉ, MIb, FA, SOL, LA]");
    }

    @Test
    public void siMajeur() {
        testerGammeMajeure(new Note(SI), "[SI, DO#, RÉ#, MI, FA#, SOL#, LA#]");
    }

    @Test
    public void siDièseMajeur() {
        testerGammeMajeure(new Note(SI, DIÈSE), "[SI#, DO##, RÉ##, MI#, FA##, SOL##, LA##]");
    }
}