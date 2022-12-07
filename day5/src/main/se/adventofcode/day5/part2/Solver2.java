package se.adventofcode.day5.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Solver2 {

    private static final Logger LOGGER = System.getLogger(Solver2.class.getName());
	private static final String TEST_RESULT = "MCD";

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

		var crates = getCrates(data);

		return moveCrates(crates, data).stream().map(stack -> stack.lastElement().toString())
				.collect(Collectors.joining());
	}

	private List<Stack<Character>> moveCrates(List<Stack<Character>> crates, List<String> data) {

		int startIndex = data.indexOf("") + 1;

		for (int i = startIndex; i < data.size(); i++) {
			String cmd = data.get(i);

			var tempArgs = cmd.split(" ");

			int[] args = { Integer.parseInt(tempArgs[1]), Integer.parseInt(tempArgs[3]),
					Integer.parseInt(tempArgs[5]) };

			Stack<Character> stack = new Stack<>();

			for (int j = 0; j < args[0]; j++) {
				stack.add(crates.get(args[1] - 1).pop());
			}

			for (int j = 0; j < args[0]; j++) {
				crates.get(args[2] - 1).add(stack.pop());
			}

		}

		return crates;
	}

	private List<Stack<Character>> getCrates(List<String> data) {

		List<Stack<Character>> stacks = new ArrayList<>();
		int nrOfStacks = (data.get(0).length() + 1) / 4;

		for (int i = 0; i < nrOfStacks; i++) {
			stacks.add(new Stack<>());
		}

		int startIndex = data.indexOf("") - 2;

		for (int i = startIndex; i >= 0; i--) {
			String row = data.get(i);

			if (row.equals("")) {
				break;
			}

			Pattern pattern = Pattern.compile("[A-Z]");
			Matcher matcher = pattern.matcher(row);

			matcher.results().forEach(result -> stacks.get((result.start() - 1) / 4).add(result.group().charAt(0)));
		}

		return stacks;
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