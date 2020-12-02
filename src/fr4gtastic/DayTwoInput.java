package fr4gtastic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DayTwoInput {
    private int min;
    private int max;
    private String character;
    private String password;
    private static final String patternString = "([0-9]+)-([0-9]+) ([a-z]): ([a-z]*)";

    public DayTwoInput(String input) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            min = Integer.parseInt(matcher.group(1));
            max = Integer.parseInt(matcher.group(2));
            character = matcher.group(3);
            password = matcher.group(4);
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordValid() {
        String sortedPassword = Arrays.stream(password.split("")).sorted().collect(Collectors.joining());
        Pattern pattern = Pattern.compile(character + "{" + min + "," + max + "}");
        Matcher matcher = pattern.matcher(sortedPassword);
        return matcher.find();
    }
}
