package fr4gtastic;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DayOne dayOne = new DayOne("inputs/day1.txt");
        DayTwo dayTwo = new DayTwo("inputs/day2.txt");

        System.out.println(dayOne.taskOne());
        System.out.println(dayOne.taskTwo());
        System.out.println(dayTwo.taskOne());
    }
}
