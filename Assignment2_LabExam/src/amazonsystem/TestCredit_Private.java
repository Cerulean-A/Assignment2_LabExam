package amazonsystem;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//16-11-2024 Created
@TestMethodOrder(OrderAnnotation.class)
class TestCredit_Private {

	String[] data;
    
	@Test
    @Order(1)
	public void testCreateCheck() {
		System.out.println("[Test0.0: Creating AmazonCheck]...");
		AmazonCheck amazoncheck;
		// Creating products
		data = new String[] { "1", "" };
		amazoncheck = AmazonCheck.createCheck(data);
		assertNull(amazoncheck);
		data = new String[] { "12345","asbc"};
		amazoncheck = AmazonCheck.createCheck(data);
		assertNull(amazoncheck);
		data = new String[] {"12345","999.99"};
		amazoncheck = AmazonCheck.createCheck(data);
		assertNotNull(amazoncheck);
	}
	
	@Test
    @Order(2)    
	public void testCreateCard() {
	System.out.println("[Test0.1: Creating AmazonCard]...");
	AmazonCard amazoncard;
	// Creating products
	data = new String[] { "1", "" };
	amazoncard = AmazonCard.createCard(data);
	assertNull(amazoncard);
	data = new String[] { "12345","","9999"};
	amazoncard = AmazonCard.createCard(data);
	assertNull(amazoncard);
	data = new String[] { "12345","2024-01-01","9999"};
	amazoncard = AmazonCard.createCard(data);
	assertNull(amazoncard);
	//input format :str = "'12345','2025-01-01','9999'"
	data = new String[] {"12345","2025-01-01","9999"};
	amazoncard = AmazonCard.createCard(data);
	assertNotNull(amazoncard);
	}
	
	@Test
    @Order(3)    
	public void testcreateCash() {
		System.out.println("[Test0.2: Creating AmazonCash...");
		AmazonCash amazoncash;
		// Creating products
		data = new String[] { "" };
		amazoncash = AmazonCash.createCash(data);
		assertNull(amazoncash);
		data = new String[] { "abcd"};
		amazoncash = AmazonCash.createCash(data);
		assertNull(amazoncash);
		//input format :str = ""9999.99""
		data = new String[] { "9999.99"};
		amazoncash = AmazonCash.createCash(data);
		assertNotNull(amazoncash);


	}

}
