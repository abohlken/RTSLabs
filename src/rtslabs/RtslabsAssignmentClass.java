package rtslabs;

import java.util.HashMap;
import java.util.Map;

public class RtslabsAssignmentClass {

	public static void main(String[] args) {
		int[] inputList = {1, 5, 2, 1, 10};
		int comparisonValue = 5;
		
		System.out.println(aboveBelow(inputList, comparisonValue));

		String inputString = "MyString";
		int rotationAmount = 2;
		
		System.out.println(stringRotation(inputString, rotationAmount));
	}
	
	public static Map<String, Integer> aboveBelow(int[] listValues, int comparisonValue) {
		// these will store the counts that will eventually be part of the output
		int aboveCount = 0;
		int belowCount = 0;
		
		// iterate through the input list of values and do each comparison
		for(int i=0;i<listValues.length;i++) {
			// note: the design given didn't explain what to do in the case of the comparison value matching a value in the list
			// I've decided to not add that case to either count
			if(listValues[i] < comparisonValue) {
				belowCount++;
			}
			if(listValues[i] > comparisonValue) {
				aboveCount++;
			}
		}
		
		// create output map
		Map<String, Integer> outputMap = new HashMap<String, Integer>();
		outputMap.put("above", aboveCount);
		outputMap.put("below", belowCount);
		return outputMap;
	}
	
	public static String stringRotation(String originalString, int rotationAmount) {
		// adjust the input rotation in case it's larger than the size of the original string
		int adjustedRotation = rotationAmount % originalString.length();
		
		// if adjustedRotation is 0, we can just return the original string without doing more processing
		if(adjustedRotation == 0) {
			return originalString;
		}
		
		// to rotate the string, we find the index where the original string will be split
		int rotationIndex = originalString.length() - adjustedRotation;
		
		// then, we concatenate the substring from that index to the end of the string with the substring from the beginning of the string to the index
		String rotatedString = originalString.substring(rotationIndex) + originalString.substring(0, rotationIndex);
		return rotatedString;
	}

}
