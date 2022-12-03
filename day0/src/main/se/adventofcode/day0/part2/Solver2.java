package se.adventofcode.day0.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver2 {

    private String fileName;
    private String result;

    private final String testResult = "";
    private final String day = getDay();

    public Solver2(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return data.toString();
    }

    private List<Object> getInput() {

        List<Object> input = new ArrayList<>();
        input.add(null);

        try {
            File myObj = new File("day" + day + "/input/" + fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //code here!
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return input;
    }

    private String getDay() {
        String name = Part2Day0.class.getSimpleName();
        return name.substring(name.indexOf("y") + 1);
    }

    public String getTestResult() {
        return testResult;
    }
}