package fr4gtastic;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class DayOne {

    private final int target = 2020;
    private final List<Integer> sortedList;

    public DayOne(String filename) throws IOException {
        List<String> inputList = readFile(filename);
        sortedList = inputList.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
    }

    public int taskOne() {
        int a;
        int b = 0;

        for (int i = 0; i < sortedList.size(); i++) {
            a = sortedList.get(i);

            for (int j = sortedList.size() - 1; j >= 0; j--) {
                b = sortedList.get(j);
                if (a + b <= target) {
                    break;
                }
            }
            if (a + b == target) {
                return a * b;
            }
        }
        return -1;
    }

    public int taskTwo() {
        int a;
        int b;
        int c;
        int sum;

        for (int i = 0; i < sortedList.size(); i++) {
            a = sortedList.get(i);
            for (int j = 1; j < sortedList.size(); j++) {
                b = sortedList.get(j);
                for (int k = 2; k < sortedList.size(); k++) {
                    c = sortedList.get(k);
                    sum = a + b + c;

                    if (sum > target) {
                        break;
                    }
                    if (sum == target) {
                        return a * b * c;
                    }
                }
            }
        }
        return -1;
    }

    private List<String> readFile(String fileName) throws IOException {
        Path filePath = new File(fileName).toPath();
        Charset charset = Charset.defaultCharset();
        return Files.readAllLines(filePath, charset);
    }
}
