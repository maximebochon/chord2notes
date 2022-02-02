package com.github.maximebochon.music;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;

@Ignore("Actions à déclencher manuellement")
public class Actions {

    private static final Logger LOGGER = LoggerFactory.getLogger(Actions.class);

    @Test
    public void afficherToutesLesGammes() throws IOException {
        final List<GammeMajeure> gammes = Arrays.stream(Heptacorde.values())
                .flatMap(h -> Arrays.stream(Altération.values())
                        .filter(a -> Math.abs(a.getDemiTons()) <= INTEGER_ONE)
                        .map(a -> new GammeMajeure(new Note(h, a)))
                )
                .collect(toList());

        LOGGER.info("{}", gammes);

        final String template = "gammes.mustache";
        final Mustache mustache = (new DefaultMustacheFactory()).compile(template);

        mustache.execute(
                new PrintWriter(new FileWriter("DRAFT.html")),
                Map.of("gammes", gammes)
        ).flush();
    }
}
