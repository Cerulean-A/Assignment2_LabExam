package amazonsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prelab2A_CSV {

	public static void main(String[] args) {
		
		Prelab2A_CSV prelab2 = new Prelab2A_CSV();
		//prelab2.lineReader("Fifty, \"ninety two, minus three\", fourty, sixty, x");
		//String [] currentFile = prelab2.readFile("C:\\CST8132\\Prelab 2\\customers-100.csv");
		String [] currentFile = prelab2.readFile("C:\\Sample-Amazon-Products-v2.csv");
		
		
		for(int i=0;i<currentFile.length;i++) {   //length is the property of the array  
			//System.out.println(currentFile[i]);   
			String outputLine = null;
			if (currentFile[i] != null && currentFile[i].length() != 0) {
				String[] array = prelab2.lineReader(currentFile[i]);
				int arrayLineCount = 0;
				for(int j = 0 ; j < array.length ; j++) {   //length is the property of the array  
					if (array[j] != null && array[j].length() != 0) {
						arrayLineCount++;
						outputLine = outputLine + " " + array[j];
						}
					}
				System.out.println(outputLine);
		}
		
//		int mainLineCount = prelab2.printStringList(String[] printingLines);
		}
}

// Method to read a file
	public String[] readFile(String fileName) {
		int index1 = 0;
		
		String[] inputLines = new String[9999];
		try {
			BufferedReader CSVReader = new BufferedReader(new FileReader(fileName));
//		BufferedReader CSVReader = new BufferedReader(new FileReader("C:\CST8132\Prelab 2\customers-100.csv"));
			String fileLine;
			while ((fileLine = CSVReader.readLine()) != null) {
				inputLines[index1++] = fileLine;
			}
			CSVReader.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		return inputLines;
	}

// Method for parsing lines
	public String[] lineReader(String line) {
		String[] CSVArray = new String[99999];
		int index = 0;
		int start = 0;
		int end;
		String value;
		
		line = line.trim();
		end = line.indexOf(",", start);
		
		//System.out.println("Total characters in the string: " + line.length());
		
		while (start < line.length() && end != -1) {
			
			while (line.charAt(start) == ' ') {
				start = start + 1;
				}
			if (line.charAt(start) == '"') {
				start = start + 1;
				//System.out.println("Start equals " + start);
				end = line.indexOf("\"", start);}
			else end = line.indexOf(",", start);
			
			//System.out.println("Start equals " + start + " Start Char: " + line.charAt(start));
			//System.out.println("End equals " + end + " End Char: " + line.charAt(end));

			value = line.substring(start, end);
			value = value.trim();		// gets rid of spaces
//			//System.out.println(value);
//			CSVArray[index] = value;
//			//System.out.println(index + " First index");
//			index++;
			
			if (index >= 6) {
				//str[index++] = extractNumerics(value);
				//System.out.println(value);
				CSVArray[index++] = extractNumerics(value);
			}else {
				CSVArray[index++] = value;
			}

			
			//System.out.println(end);
			if (line.charAt(end) == '"') { 
				start = end + 2;
				}
			else {
				start = end + 1; 
				}
			end = line.indexOf(",", start);
		}

		if (start < line.length() - 1) {
			value = line.substring(start, line.length());
			value = value.trim();		// gets rid of spaces
			//System.out.println(value);
			CSVArray[index] = value;
			}
			 
			 return CSVArray;
	}

// Method to count strings and print
	public int printStringList(String[] printingLines) {
		int lineCount = 0;
		for(int i = 0 ; i < printingLines.length ; i++) {   //length is the property of the array  
			if (printingLines[i] != null && printingLines[i].length() != 0) {
				lineCount++;
				System.out.println(printingLines[i]);
				}
		}
		return lineCount;
	}
	
	public static String extractNumerics(String inputString) {

        StringBuffer sb = new StringBuffer(inputString);
        StringBuffer result = new StringBuffer();

        	
        for(int i=0; i < sb.length(); i++){  
        	 int specificI = sb.codePointAt(i);

         	if (specificI == 48 || specificI == 49 || specificI == 50 
        			|| specificI == 51 || specificI == 52 || specificI == 53 || specificI == 54 
        			|| specificI == 55 || specificI == 56 || specificI == 57 
        			|| specificI == 46) 
        				{ 
        				//System.out.println("In Loop with " + specificI);
        				result.append(sb.charAt(i));
        				}
        	}       
        return result.toString();  
    }
	
}


