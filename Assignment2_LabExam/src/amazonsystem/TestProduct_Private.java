package amazonsystem;

import static org.junit.jupiter.api.Assertions.*;
//17-11-2024 Created
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TestProduct_Private {

	/**
	 * Create products
	 */
	@Test
    @Order(1)    
	public void test1CreateProducts() {
		// Creating products
		AmazonProduct_H ap;
		String[] data;
		System.out.println("[Test1.1: Creating products]...");
		data = new String[] {};
		ap = AmazonProduct_H.createAmazonProduct(data);
		assertNull(ap);
		data = new String[] { "Wrong data", "0" };
		ap = AmazonProduct_H.createAmazonProduct(data);
		assertNull(ap);
		data = new String[] { "1", "Prod1", "Cat1", "Subcat1", "Img1", "URL1", "1", "10", "1.1", "10.1" };
		ap = AmazonProduct_H.createAmazonProduct(data);
		assertNotNull(ap);
	}

}
