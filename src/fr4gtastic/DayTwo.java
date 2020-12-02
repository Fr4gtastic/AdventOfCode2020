package fr4gtastic;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DayTwo {
    private final List<String> inputList;

    public DayTwo(String filename) throws IOException {
        inputList = readFile(filename);
    }

    public long taskOne() {
        return inputList.stream()
                .map(DayTwoInput::new)
                .filter(DayTwoInput::isPasswordValid)
                .count();
    }

    private List<String> readFile(String fileName) throws IOException {
        Path filePath = new File(fileName).toPath();
        Charset charset = Charset.defaultCharset();
        return Files.readAllLines(filePath, charset);
    }
}
