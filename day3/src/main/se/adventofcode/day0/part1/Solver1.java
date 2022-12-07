package se.adventofcode.day7.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solver1 {

    private String fileName;

    private final String testResult = "157";

    public Solver1(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
    }

    private String solution(List<String> data) {
		return data.stream().map(this::getChars).filter(i -> i > 0).reduce(0, Integer::sum).toString();
	}
    
    private int getChars(String row) {
    	HashMap<Character, Integer> mp = new HashMap<> ();
		int mid = row.length()/2;
		char[] arr = row.substring(0, mid).toCharArray();
		char[] arr2 = row.substring(mid).toCharArray();
		for (int i = 0; i < mid; i++) {
			char a = arr[i];
			mp.putIfAbsent(a, 0);
		}
		
		for (int i = 0; i < mid; i++) {
			char a = arr2[i];
			mp.computeIfPresent(a, (key, val) -> 1);
		}
		int result = 0;
		
		for (Entry<Character, Integer> b : mp.entrySet()) {
			if (b.getValue() > 0) {
				result = b.getKey();
				if (result >= 'a') {
					result -= 'a' - 1;
				} else if (result >= 'A') {
					result -= 'A' - 27;
				} 
			}
		}
		return result;
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
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return input;
    }

    public String getTestResult() {
        return testResult;
    }
}