package amazonsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

//git com

public class AmazonCard extends AmazonCredit{
	private String cardNumber;
	//private String cardExpiration;
	Date cardExpiration;
	
	private AmazonCard(String cardnumber, String cardexpiration,float amountcard) {
		super(amountcard,PaymentType.Card);
		this.cardNumber = cardnumber;
		if(checkDate(cardexpiration)) {
			this.cardExpiration = tranferStrDate(cardexpiration);			
		}
	}
	
	
	public String getCardNumber() {
		return cardNumber;
	}


	public Date getCardExpiration() {
		return cardExpiration;
	}


	public static AmazonCard createCard(String[] str) {
		// TODO Auto-generated method stub
//		AmazonCard amazoncard;
//		if ((str==null)||(str.length)!=3)
//			return null;
//		for (String s:str) {
//			if (s.isBlank()||s.isEmpty())
//				return null;
//			}
//		//input format :str = "'12345','2025-01-01','9999'"
//			String cardnumber = str[0];
//			String cardexpiration = str[1];
//			float amountcard;
//			Date cardExpiration;
//			if(!checkDate(cardexpiration)) return null;
//				else
//			cardExpiration = tranferStrDate(cardexpiration);
//			try {
//				amountcard = Float.parseFloat(str[2]);
//				return amazoncard = new AmazonCard(cardnumber,cardexpiration,amountcard); 	 
//			}catch (NumberFormatException e) {  
//		        return null;  
//		    }
		
		float amountCard;
		List<String> strArrayList = new ArrayList<>(Arrays.asList(str));
		Iterator<String> strALIterator = strArrayList.iterator();
			while (strALIterator.hasNext()) {
				if (strALIterator.next() == null) {
					strALIterator.remove();
				}
			}
			
		if ((strArrayList==null)||(strArrayList.size())!=3)
			return null;
		for (String sal: strArrayList) {
			if (sal.isBlank()||sal.isEmpty())
				return null;
			}

			String accountNumber = strArrayList.get(0);
			String cardexpiration = strArrayList.get(1);

			try {
				amountCard=Float.parseFloat(strArrayList.get(2));
				return new AmazonCard(accountNumber,cardexpiration,amountCard); 
			}catch (NumberFormatException e) {  
		        return null;  
		    }
			
	        

	}	

	private static boolean checkDate(String cardexpiration){
	Date cardExpiration;
    // defined the date patternRegex  
    String dateRegex = "^[0-9]{4}+-[0-9]{1,2}+-[0-9]{2}$";  
    Pattern datepattern = Pattern.compile(dateRegex); 
    // return input error  
    if (datepattern.matcher(cardexpiration).matches()) {  
        System.out.println("Input date is valid: " + cardexpiration);  
        cardExpiration=tranferStrDate(cardexpiration);
      if(validexpirDate(cardExpiration)) {
    	  System.out.println("The card is working: " + cardExpiration.toInstant());
    	  return true;
      }else {
        	System.out.println("The card is expired.....Please input another card ");	
        	return false;
        }
    }
    else {
        	System.out.println("Please input a format date string as \"Year-Month-Day\" ");
        	return false;
        	//continue;
        	} 	
	}
	
	private static Date tranferStrDate(String dateStr) {
//		String dateStr = dataString;//need to check month between 1-12 and days between 0-31.note: 2024-11-14
		char[] year=new char[4];
		char[] month=new char[2];
		char[] day=new char[2];
		
		dateStr.getChars(0, 4, year, 0);
		dateStr.getChars(5, 7, month, 0);
		dateStr.getChars(8, 10, day, 0);
		
		String yearString = new String(year);
		String monthString = new String(month);
		String dayString = new String(day);
		
		int yearInt = Integer.parseInt(yearString);
		int monthInt = Integer.parseInt(monthString);
		int dayInt = Integer.parseInt(dayString);
		
		ValueRange yearrange = ValueRange.of(2000, 2050);
		ValueRange monthrange = ValueRange.of(1, 12);
		ValueRange dayrange = ValueRange.of(1, 31);
		if (yearrange.isValidValue(yearInt)&&monthrange.isValidValue(monthInt)&&dayrange.isValidValue(dayInt)) {	
		// define date format;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // dateString to Date 
        Date datestr;
		try {
			datestr = dateFormat.parse(dateStr);
	        Calendar cardDate = Calendar.getInstance();  
	        cardDate.setTime(datestr); // 设置时间为解析出来的日期 
			return datestr;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		return null;  
}	
	
	
	@Override
	public String toString() {
		return "AmazonCard [cardNumber=" + cardNumber + ", cardExpiration=" + cardExpiration + ", getAmountCredit()="
				+ getAmount() + "]";
	}


	private static boolean validexpirDate(Date expirDate) {

	    if(expirDate.after(new Date())) 
	        return true;
	    else
	        return false;
		}  

}