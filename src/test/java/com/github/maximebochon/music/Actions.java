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
import java.util.stream.Stream;

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

        renderAsHtmlPage("gammes", "gammes", Map.of("gammes", gammes));
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

        Stream.of(3, 4).forEach(taille -> {
            final List<Accord> accordsNsons = accords.stream()
                    .filter(accord -> accord.getNotes().size() == taille)
                    .collect(toUnmodifiableList());

            renderAsHtmlPage(
                    "accords", "accords" + taille + "sons",
                    Map.of("accords", accordsNsons, "taille", taille)
            );
        });
    }

    private void renderAsHtmlPage(
            final String template,
            final String page,
            final Map<String, Object> context
    ) {
        try {
            final Mustache engine = (new DefaultMustacheFactory()).compile(template + ".mustache");
            final PrintWriter output = new PrintWriter(new FileWriter("docs/" + page + ".html"));
            engine.execute(output, context).flush();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
