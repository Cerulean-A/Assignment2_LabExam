package amazonsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AmazonCash extends AmazonCredit{
	

	private AmazonCash(float amountcash) {
		super(amountcash,PaymentType.Cash);
	}
	
	
	




	@Override
	public String toString() {
		return "AmazonCash [getAmountCredit()=" + getAmount() + ", getType()=" + getType() + "]";
	}







	public static AmazonCash createCash(String[] str) {
		// TODO Auto-generated method stub
//		AmazonCash amazoncash;
//		float amountcash;
//		if ((str==null)||(str.length)!=1)
//			return null;
//		for (String s:str) {
//			if (s.isBlank()||s.isEmpty())
//				return null;
//			}
//		//input format :str = "'9999.01'"
//		try {
//			amountcash = Float.parseFloat(str[0]);
//	        return amazoncash = new AmazonCash(amountcash);  
//		}catch (NumberFormatException e) {  
//	        return null;  
//	    }	
		
		float amountCash;
		List<String> strArrayList = new ArrayList<>(Arrays.asList(str));
		Iterator<String> strALIterator = strArrayList.iterator();
			while (strALIterator.hasNext()) {
				if (strALIterator.next() == null) {
					strALIterator.remove();
				}
			}
			
		if ((strArrayList==null)||(strArrayList.size())!=1)
			return null;
		for (String sal: strArrayList) {
			if (sal.isBlank()||sal.isEmpty())
				return null;
			}

			try {
				amountCash=Float.parseFloat(strArrayList.get(0));
				return new AmazonCash(amountCash); 
			}catch (NumberFormatException e) {  
		        return null;  
		    }	

	}
		
}

