package amazonsystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.Calendar;

public class CartRegistry {
		
	private static final Map<Integer, AmazonCart> cartMap = new HashMap<>();
	
	public static void registerCart(AmazonCart cart) {
	        cartMap.put(cart.getamazonCustomer().getId(), cart);
	    }
	 
    public static void checkAndResetCarts() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        
    
        for (AmazonCart cart : cartMap.values()) {
            if (cart.getCreationDate().before(today)) {
                // Remove the expired cart and create a new one
                cartMap.remove(cart.getamazonCustomer().getId(), cart);
                AmazonCart newCart = new AmazonCart(cart.getamazonCustomer(), today);
                cartMap.put(cart.getamazonCustomer().getId(), newCart);
            }
        }
    }
}


//	    public static void checkAndResetCarts() {
//	        // ... (logic to check cart expiration and reset)
//	        for (Map.Entry<Integer, AmazonCart> entry : cartMap.entrySet()) {
//	        	AmazonCart cart = entry.getValue();
//	            if (isAmazonCartExpired(cart.getCreationDate())) {
//	                AmazonCustomer customer = ...; // Get the customer associated with the cart
//	                customer.setAmazonCart(new AmazonCart(customer, new Date()));
//	                cartMap.put(customer.getId(), customer.getAmazonCart());
//	            }
//	        }
//	    }
//	}
	
