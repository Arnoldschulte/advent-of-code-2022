package nl.schulte.advent.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextParser {

    public static List<String> getTextLines(String filepath) throws IOException, URISyntaxException {
        final Path path = Paths.get(ClassLoader.getSystemResource(filepath).toURI());
        return Files.readAllLines(path);
    }
}
