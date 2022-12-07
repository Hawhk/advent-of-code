package se.adventofcode.day6.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Solver2 {

    private static final Logger LOGGER = System.getLogger(Solver2.class.getName());
	private static final String TEST_RESULT = "19";

    private String fileName;

    public Solver2(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();
		long start = System.nanoTime();
		String result = solution(data);
		LOGGER.log(Level.INFO, "Took {0}ms", (System.nanoTime() - start) / 1_000_000);

		return result;
    }

    private String solution(List<String> data) {
		var row = data.get(0);

		var messageLen = 14;

		for (int i = 0; i < row.length() - messageLen; i++) {
			var sub = row.substring(i, i + messageLen).split("");

			HashSet<String> set = new HashSet<>(Arrays.asList(sub));

			if (set.size() == messageLen) {
				return String.valueOf(i + messageLen);
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
			LOGGER.log(Level.TRACE, e);
        }

        return input;
    }

    public String getTestResult() {
        return TEST_RESULT;
    }
}