package se.adventofcode.day0.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class Solver2 {

    private String fileName;

    private final String testResult = "70";

    public Solver2(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
    }

    private String solution(List<String> data) {
    	int result = 0;
    	for (int i = 0; i < data.size(); i += 3) {
    		HashMap<Character, Integer> mp = new HashMap<> ();
    		char[] a1 = noDuplicates(data.get(i)).toCharArray();
    		char[] a2 = noDuplicates(data.get(i + 1)).toCharArray();
    		char[] a3 = noDuplicates(data.get(i + 2)).toCharArray();
    		
    		for (int j = 0; j < a1.length; j++) {
    			char a = a1[j];
    			mp.putIfAbsent(a, 0);
    		}
    		for (int j = 0; j < a2.length; j++) {
    			char a = a2[j];
    			mp.computeIfPresent(a, (key, val) -> val + 1);
    		}
    		for (int j = 0; j < a3.length; j++) {
    			char a = a3[j];
    			mp.computeIfPresent(a, (key, val) -> val + 1);
    		}
    		for (Entry<Character, Integer> b : mp.entrySet()) {
    			if (b.getValue() == 2) {
    				int keyValue = b.getKey();
    				if (keyValue >= 'a') {
    					keyValue -= 'a' - 1;
    				} else if (keyValue >= 'A') {
    					keyValue -= 'A' - 27;
    				} 
    				result += keyValue;
    			}
    		}
    	}
		return String.valueOf(result);
	}

	private String noDuplicates(String str) {
		return Arrays.asList(str.split(""))
		.stream()
		.distinct()
		.collect(Collectors.joining());
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