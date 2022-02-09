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
                .flatMap(h -> Arrays.stream(Altération.values())
                        .filter(a -> Math.abs(a.getDemiTons()) <= INTEGER_ONE)
                        .map(a -> new GammeMajeure(new Note(h, a)))
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
                .flatMap(h -> Arrays.stream(Altération.values())
                        .filter(a -> Math.abs(a.getDemiTons()) <= INTEGER_ONE)
                        .map(a -> new GammeMajeure(new Note(h, a)))
                )
                .filter(GammeMajeure::isPraticable)
                .map(GammeMajeure::getTonique)
                .flatMap(t -> Arrays.stream(NatureAccord.values())
                        .map(n -> new Accord(t, n))
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
