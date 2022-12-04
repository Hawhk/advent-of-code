package se.adventofcode.day4.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;

public class Solver2 {

    private static final Logger LOGGER = System.getLogger(Solver2.class.getName());
	private static final String TEST_RESULT = "4";

    private String fileName;

    public Solver2(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
    }

    private String solution(List<String> data) {

		return data.stream().map(this::solution).reduce(0, Integer::sum).toString();
	}

	private int solution(String row) {
		var ranges = Arrays.stream(row.split(",")).map(a -> a.split("-")).flatMap(Arrays::stream)
				.mapToInt(Integer::parseInt).toArray();

		LOGGER.log(Logger.Level.DEBUG, "{}, {}", ranges, row);

		for (int i = ranges[0]; i <= ranges[1]; i++) {
			for (int j = ranges[2]; j <= ranges[3]; j++) {
				if (i == j) {
					return 1;
				}
			}
		}

		return 0;
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