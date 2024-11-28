package amazonsystem;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern; 
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
//2024-11-14 script date checking module. 

public class checkDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date expirDate;
		Scanner input = new Scanner(System.in);
		System.out.println("Please follow the format : \"Year-Month-Day\" "); 
		while(true) {		
		String dateString = input.nextLine();
        // defined the date patternRegex  
        String dateRegex = "^[0-9]{4}+-[0-9]{1,2}+-[0-9]{2}$";  
        Pattern datepattern = Pattern.compile(dateRegex); 
        // return input error  
        if (datepattern.matcher(dateString).matches()) {  
            System.out.println("Input date is valid: " + dateString);  
            expirDate=checkDate.tranferStrDate(dateString);
          if(validexpirDate(expirDate)) {
        	  	break;
          }else {
            	System.out.println("The card is expired.....Please input another card ");	
            	continue;
            }
        }
        else {
            	System.out.println("Please input a format date string as \"Year-Month-Day\" ");
            	continue;
            	} 	
		}
		System.out.println("The card is working: " + expirDate.toInstant()); 
		input.close();
	}
	private static Date tranferStrDate(String dataString) {
//		String dateStr = dataString;//need to check month between 1-12 and days between 0-31.note: 2024-11-14
//		char[] year=new char[4];
//		char[] month=new char[2];
//		char[] day=new char[2];
//		
//		dateStr.getChars(0, 4, year, 0);
//		dateStr.getChars(5, 7, month, 0);
//		dateStr.getChars(8, 10, day, 0);
		// define date format;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // dateString to Date 
        Date datestr;
		try {
			datestr = dateFormat.parse(dataString);
	        Calendar cardDate = Calendar.getInstance();  
	        cardDate.setTime(datestr); // 设置时间为解析出来的日期 
			return datestr;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;  
}	
	private static boolean validexpirDate(Date expirDate) {

	    if(expirDate.after(new Date())) 
	        return true;
	    else
	        return false;
		}  
}





