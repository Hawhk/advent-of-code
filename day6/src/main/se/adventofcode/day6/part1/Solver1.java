package se.adventofcode.day6.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;

public class Solver1 {

    private static final Logger LOGGER = System.getLogger(Solver1.class.getName());
	private static final String TEST_RESULT = "7";

    private String fileName;

    public Solver1(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
    }

    private String solution(List<String> data) {

		var row = data.get(0);
		
		for (int i = 0; i < row.length() -4; i++) {
			var sub = row.substring(i, i + 4).split("");
			
			HashSet<String> set = new HashSet<>(Arrays.asList(sub));
			
			if (set.size() == 4) {
				return String.valueOf(i + 4);
			}
		}

		return "0";
    }

    private List<String> getInput() {

        List<String> input = new ArrayList<>();

        try {
            File myObj = new File("input/" + fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            LOGGER.log(Logger.Level.TRACE, e);
        }

        return input;
    }

    public String getTestResult() {
        return TEST_RESULT;
    }
}