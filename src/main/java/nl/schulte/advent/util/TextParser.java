package nl.schulte.advent.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextParser {

    public static List<String> getTextLines(String filepath) throws IOException {
        final Path path = Path.of(ClassLoader.getSystemResource(filepath).getPath());
        return Files.readAllLines(path);
    }
}
