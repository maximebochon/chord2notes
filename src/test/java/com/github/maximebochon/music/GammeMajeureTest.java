package com.github.maximebochon.music;

import org.junit.Test;

import static com.github.maximebochon.music.Altération.*;
import static com.github.maximebochon.music.Heptacorde.*;
import static org.junit.Assert.assertEquals;

public class GammeMajeureTest {

    private void testerGammeMajeure(final Note tonique, String expectedGamme, final boolean praticable) {
        final GammeMajeure gamme = new GammeMajeure(tonique);

        assertEquals(tonique, gamme.getTonique());

        expectedGamme = expectedGamme
                .replace("##", DOUBLE_DIÈSE.getSymbole())
                .replace("#", DIÈSE.getSymbole())
                .replace("bb", DOUBLE_BÉMOL.getSymbole())
                .replace("b", BÉMOL.getSymbole());
        assertEquals(expectedGamme, gamme.getNotes().toString());

        assertEquals(praticable, gamme.isPraticable());
    }

    @Test
    public void doBémolMajeur() {
        testerGammeMajeure(new Note(DO, BÉMOL), "[DOb, RÉb, MIb, FAb, SOLb, LAb, SIb]", true);
    }

    @Test
    public void doMajeur() {
        testerGammeMajeure(new Note(DO), "[DO, RÉ, MI, FA, SOL, LA, SI]", true);
    }

    @Test
    public void doDièseMajeur() {
        testerGammeMajeure(new Note(DO, DIÈSE), "[DO#, RÉ#, MI#, FA#, SOL#, LA#, SI#]", true);
    }

    @Test
    public void réBémolMajeur() {
        testerGammeMajeure(new Note(RÉ, BÉMOL), "[RÉb, MIb, FA, SOLb, LAb, SIb, DO]", true);
    }

    @Test
    public void réMajeur() {
        testerGammeMajeure(new Note(RÉ), "[RÉ, MI, FA#, SOL, LA, SI, DO#]", true);
    }

    @Test
    public void réDièseMajeur() {
        testerGammeMajeure(new Note(RÉ, DIÈSE), "[RÉ#, MI#, FA##, SOL#, LA#, SI#, DO##]", false);
    }

    @Test
    public void miBémolMajeur() {
        testerGammeMajeure(new Note(MI, BÉMOL), "[MIb, FA, SOL, LAb, SIb, DO, RÉ]", true);
    }

    @Test
    public void miMajeur() {
        testerGammeMajeure(new Note(MI), "[MI, FA#, SOL#, LA, SI, DO#, RÉ#]", true);
    }

    @Test
    public void miDièseMajeur() {
        testerGammeMajeure(new Note(MI, DIÈSE), "[MI#, FA##, SOL##, LA#, SI#, DO##, RÉ##]", false);
    }

    @Test
    public void faBémolMajeur() {
        testerGammeMajeure(new Note(FA, BÉMOL), "[FAb, SOLb, LAb, SIbb, DOb, RÉb, MIb]", false);
    }

    @Test
    public void faMajeur() {
        testerGammeMajeure(new Note(FA), "[FA, SOL, LA, SIb, DO, RÉ, MI]", true);
    }

    @Test
    public void faDièseMajeur() {
        testerGammeMajeure(new Note(FA, DIÈSE), "[FA#, SOL#, LA#, SI, DO#, RÉ#, MI#]", true);
    }

    @Test
    public void solBémolMajeur() {
        testerGammeMajeure(new Note(SOL, BÉMOL), "[SOLb, LAb, SIb, DOb, RÉb, MIb, FA]", true);
    }

    @Test
    public void solMajeur() {
        testerGammeMajeure(new Note(SOL), "[SOL, LA, SI, DO, RÉ, MI, FA#]", true);
    }

    @Test
    public void solDièseMajeur() {
        testerGammeMajeure(new Note(SOL, DIÈSE), "[SOL#, LA#, SI#, DO#, RÉ#, MI#, FA##]", false);
    }

    @Test
    public void laBémolMajeur() {
        testerGammeMajeure(new Note(LA, BÉMOL), "[LAb, SIb, DO, RÉb, MIb, FA, SOL]", true);
    }

    @Test
    public void laMajeur() {
        testerGammeMajeure(new Note(LA), "[LA, SI, DO#, RÉ, MI, FA#, SOL#]", true);
    }

    @Test
    public void laDièseMajeur() {
        testerGammeMajeure(new Note(LA, DIÈSE), "[LA#, SI#, DO##, RÉ#, MI#, FA##, SOL##]", false);
    }

    @Test
    public void siBémolMajeur() {
        testerGammeMajeure(new Note(SI, BÉMOL), "[SIb, DO, RÉ, MIb, FA, SOL, LA]", true);
    }

    @Test
    public void siMajeur() {
        testerGammeMajeure(new Note(SI), "[SI, DO#, RÉ#, MI, FA#, SOL#, LA#]", true);
    }

    @Test
    public void siDièseMajeur() {
        testerGammeMajeure(new Note(SI, DIÈSE), "[SI#, DO##, RÉ##, MI#, FA##, SOL##, LA##]", false);
    }
}