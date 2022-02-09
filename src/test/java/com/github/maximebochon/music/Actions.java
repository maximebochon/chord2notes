package com.github.maximebochon.music;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toUnmodifiableList;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;

@Ignore("Actions à déclencher manuellement")
public class Actions {

    @Test
    public void afficherToutesLesGammesMajeures() throws IOException {
        final List<GammeMajeure> gammes = Arrays.stream(Heptacorde.values())
                .flatMap(heptacorde -> Arrays.stream(Altération.values())
                        .filter(altération -> Math.abs(altération.getDemiTons()) <= INTEGER_ONE)
                        .map(altération -> new GammeMajeure(new Note(heptacorde, altération)))
                )
                .collect(toUnmodifiableList());

        final String template = "gammes.mustache";
        final Mustache mustache = (new DefaultMustacheFactory()).compile(template);

        mustache.execute(
                new PrintWriter(new FileWriter("DRAFT.gammes.html")),
                Map.of("gammes", gammes)
        ).flush();
    }

    @Test
    public void afficherCertainsAccords() throws IOException {
        final List<Accord> accords = Arrays.stream(Heptacorde.values())
                .flatMap(heptacorde -> Arrays.stream(Altération.values())
                        .filter(altération -> Math.abs(altération.getDemiTons()) <= INTEGER_ONE)
                        .map(altération -> new GammeMajeure(new Note(heptacorde, altération)))
                )
                .filter(GammeMajeure::isPraticable)
                .map(GammeMajeure::getTonique)
                .flatMap(tonique -> Arrays.stream(NatureAccord.values())
                        .map(nature -> new Accord(tonique, nature))
                )
                .collect(toUnmodifiableList());

        final String template = "accords.mustache";
        final Mustache mustache = (new DefaultMustacheFactory()).compile(template);

        mustache.execute(
                new PrintWriter(new FileWriter("DRAFT.accords.html")),
                Map.of("accords", accords)
        ).flush();
    }
}
