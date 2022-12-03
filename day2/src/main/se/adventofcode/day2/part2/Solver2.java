package se.adventofcode.day2.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver2 {

    private String fileName;

    private final String testResult = "12";

    public Solver2(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
    }

    private String solution(List<String> data) {
    	
    	return data.stream().map(row -> 
    		new RockPaperSissors(Enemy.valueOf(row.split(" ")[0]), Result.valueOf(row.split(" ")[1])))
    			.map(RockPaperSissors::getPoints).reduce(0, Integer::sum).toString();
    	
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
    
    private record RockPaperSissors(Enemy e, Result r) {
    	public int getPoints() {
    		int points = r.ordinal() * 3;
    		
    		if (r == Result.X) {
    			points += mod(e.ordinal() -1, 3);
    		} else if (r == Result.Y) {
    			points += e.ordinal();
    		} else {
    			points += mod(e.ordinal() + 1, 3);
    		}
    		return points + 1;
    	}
    	
    	private int mod(int x, int y) {
    		int result = x % y;
    		
    		if (result < 0) {
    			result += y;
    		}
    		return result;
    	}
    }
    
    private enum Enemy {
    	A,B,C;
    }
    private enum Result {
    	X,Y,Z;
    }
}