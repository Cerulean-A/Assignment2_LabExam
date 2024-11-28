package amazonsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AmazonCheck extends AmazonCredit{//cheque
	
	private String accountNumber;
	//private float amountCheck;

	
	private AmazonCheck(String accountnumber, float amountcheck) {
		super(amountcheck, PaymentType.Check);
		this.accountNumber = accountnumber;
	}

	



	@Override
	public String toString() {
		return "AmazonCheck [accountNumber=" + accountNumber + ", amountCredit=" + super.getAmount() + "]";
	}





	public String getAccountNumber() {
		return accountNumber;
	}


	public float getAmountCheck() {
		return super.getAmount();
	}


	public static AmazonCheck createCheck(String[] str) {
		float amountCheck;
		List<String> strArrayList = new ArrayList<>(Arrays.asList(str));
		Iterator<String> strALIterator = strArrayList.iterator();
			while (strALIterator.hasNext()) {
				if (strALIterator.next() == null) {
					strALIterator.remove();
				}
			}
			
		if ((strArrayList==null)||(strArrayList.size())!=2)
			return null;
		for (String sal: strArrayList) {
			if (sal.isBlank()||sal.isEmpty())
				return null;
			}

			String accountNumber = strArrayList.get(0);

			try {
				amountCheck=Float.parseFloat(strArrayList.get(1));
				return new AmazonCheck(accountNumber,amountCheck); 
			}catch (NumberFormatException e) {  
		        return null;  
		    }	
	}
	
//	public static void main(String[] str) {
//		String strings[] = {"12345","999.99"};
//		AmazonCheck check = AmazonCheck.createCheck(strings);
//		System.out.print(check.toString());
//	}
}
