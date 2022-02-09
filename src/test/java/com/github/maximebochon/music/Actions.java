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

        renderAsHtmlPage("gammes", Map.of("gammes", gammes));
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

        renderAsHtmlPage("accords", Map.of("accords", accords));
    }

    private void renderAsHtmlPage(final String name, final Map<String, Object> context) throws IOException {
        final String template = name + ".mustache";
        final Mustache engine = (new DefaultMustacheFactory()).compile(template);
        final PrintWriter output = new PrintWriter(new FileWriter("docs/" + name + ".html"));
        engine.execute(output, context).flush();
    }
}
