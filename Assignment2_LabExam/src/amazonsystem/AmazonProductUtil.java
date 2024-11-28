package amazonsystem;

import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.Date;

public class AmazonProductUtil {
	public static final int NUMCOLS=10;
	public static float convertStrToFloat(String str) {

		 return Float.parseFloat(str);
	};



	
	// Method for parsing lines
	public String[] lineReader(String line) {
		String[] CSVArray = new String[10];

		int index = 0;
		int start = 0;
		int end;
		String value;
		
		line = line.trim();
		end = line.indexOf(",", start);
		

		
		while (start < line.length() && end != -1) {
			
			while (line.charAt(start) == ' ') {
				start = start + 1;
				}
			if (line.charAt(start) == '"') {
				start = start + 1;

				end = line.indexOf("\"", start);}
			else end = line.indexOf(",", start);
			


			value = line.substring(start, end);
			value = value.trim();		// gets rid of spaces

			
			if (index >= 6) {
				CSVArray[index++] = extractNumerics(value);
			}else {
				CSVArray[index++] = value;
			}

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

			CSVArray[index] = value;
			}
			 
			 return CSVArray;
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

        				result.append(sb.charAt(i));
        				}
        	}       
        return result.toString();  
    }
	

	public Date cartInstanceChecker() {
		Date currentDate = new Date();
		
		return currentDate;
	}
}
	


