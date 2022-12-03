package se.adventofcode.day1.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver1 {

    private String fileName;
    private String result;

    private final String testResult = "24000";
    private final String day = getDay();

    public Solver1(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return data.stream().max(Integer::compare).orElseThrow().toString();
    }

    private List<Integer> getInput() {
        List<Integer> calories = new ArrayList<>();
        calories.add(0);

        try {
            File myObj = new File("day" + day + "/input/" + fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.equals("")) {
                    calories.add(0);
                } else {
                    int calorie = calories.get(calories.size() - 1) + Integer.parseInt(data);
                    calories.set(calories.size() -1, calorie);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return calories;
    }

    private String getDay() {
        String name = Part1Day1.class.getSimpleName();
        return name.substring(name.indexOf("y") + 1);
    }

    public String getTestResult() {
        return testResult;
    }
}