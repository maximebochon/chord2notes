package com.github.maximebochon.music;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.maximebochon.music.Altération.*;
import static com.github.maximebochon.music.Heptacorde.*;

public class GammeMajeureTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GammeMajeureTest.class);

    @Test
    public void doMajeur() {
        final Note tonique = new Note(DO);
        final GammeMajeure gamme = new GammeMajeure(tonique);
        LOGGER.debug("{}", gamme);
    }

    @Test
    public void doDièseMajeur() {
        final Note tonique = new Note(DO, DIÈSE);
        final GammeMajeure gamme = new GammeMajeure(tonique);
        LOGGER.debug("{}", gamme);
    }

    @Test
    public void solDièseMajeur() {
        final Note tonique = new Note(SOL, DIÈSE);
        final GammeMajeure gamme = new GammeMajeure(tonique);
        LOGGER.debug("{}", gamme);
    }

    @Test
    public void faMajeur() {
        final Note tonique = new Note(FA, NATUREL);
        final GammeMajeure gamme = new GammeMajeure(tonique);
        LOGGER.debug("{}", gamme);
    }

    @Test
    public void solMajeur() {
        final Note tonique = new Note(SOL, NATUREL);
        final GammeMajeure gamme = new GammeMajeure(tonique);
        LOGGER.debug("{}", gamme);
    }

    @Test
    public void laMajeur() {
        final Note tonique = new Note(LA, NATUREL);
        final GammeMajeure gamme = new GammeMajeure(tonique);
        LOGGER.debug("{}", gamme);
    }

    @Test
    public void laBémolMajeur() {
        final Note tonique = new Note(LA, BÉMOL);
        final GammeMajeure gamme = new GammeMajeure(tonique);
        LOGGER.debug("{}", gamme);
    }
}