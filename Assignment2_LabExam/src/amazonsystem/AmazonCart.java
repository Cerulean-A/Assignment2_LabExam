package amazonsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ValueRange;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;



public class AmazonCart implements AmazonPayable{

	private AmazonCustomer amazonCustomer;
	//		private Date amazonCartDate;		
	private Date creationDate;
	private float orderValue;

	private ArrayList<AmazonCartItem> amazonCartItems = new ArrayList<AmazonCartItem>();
	private List<AmazonProduct> amazonProducts = new ArrayList<AmazonProduct>();

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date currentDate = new Date();


	// A method to calculate the subtotal of items within the cart.
	public AmazonCart(AmazonCustomer amazoncustomer, Date amazonCartDate,ArrayList<AmazonCartItem> amazonCartItems){
		//test Date is localDate, and amazoncustomer instanceofType
		this.amazonCustomer=amazoncustomer;
		this.creationDate=amazonCartDate;
		this.amazonCartItems=amazonCartItems;
	}

	public AmazonCart(AmazonCustomer amazoncustomer, Date amazonCartDate){
		//test Date is localDate, and amazoncustomer instanceofType
		this.amazonCustomer=amazoncustomer;
		this.creationDate=amazonCartDate;
		//this.amazonCarItemPreCustomer=amazonCarItemCustomer;
	}

	// A method to calculate the subtotal of items within the cart.
	private float calcSubTotal() {
		float subtotal = 0.0f;
		for (AmazonCartItem listItem : amazonCartItems) {
			subtotal = subtotal + listItem.calSubTotal();
		}
		return subtotal;
	}

	// I'm unsure if this is a normal getter or a separate method
	//		public AmazonCartItem getItem(int cartId) {
	//			AmazonCartItem amazonCustomerItem=null;
	//			return null;
	//		}
	// A method which uses the boolean pay interfamazonCustomere to pay for a cart, make adjustments, and return
	// a boolean as to whether it happened or not.
	@Override
	public boolean pay(float canYouPay) {
		if (calcSubTotal() <= amazonCustomer.totalCredit()) { 
			amazonCustomer.setCreditAmount(amazonCustomer.totalCredit() - calcSubTotal()); 
			System.out.println("Your Cart has been Purchased!");
			amazonCustomer.moveFromCartToComments(this.getamazonCartItems());
			amazonCartItems.clear();
			System.out.println("Items moved to your Item/Comment List");
			return true;	
		}
		return false;
	};


	public void addItem(AmazonCartItem amazonCustomerItem) {
		// TODO Auto-generated method stub
		amazonCartItems.add(amazonCustomerItem);		
	};



	public void removeItem(AmazonProduct ap) {
		// TODO Auto-generated method stub
		AmazonCartItem amazoncartitem = null;
		for(AmazonCartItem amazonCustomeri: amazonCartItems) {
			if (amazonCustomeri.getProduct() == ap) {
				amazoncartitem = amazonCustomeri;
				amazonCartItems.remove(amazoncartitem);
			}
		}
	}	

	public String getCartDetails() {

		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();  
		//		    sb.append("AmazonCart [amazonCustomer=")  
		//		      .append(amazonCustomer)  
		//		      .append(", amazonCartDate=")  
		//		      .append(amazonCartDate)  
		//		    sb.append("List is below: \n");  

		for (AmazonCartItem amazonCartItem : amazonCartItems) {  
			//sb.append(amazonCartItem.toString()).append(", "); // 添加项的字符串表示和逗号  
			sb.append(amazonCartItem.toString()); // 添加项的字符串表示和逗号  
		}  

		// 去除最后一个逗号和空格  
		if (sb.length() > 0) {  
			sb.setLength(sb.length() - 2); // 删除最后的逗号和空格  
		}  
		sb.append("The current Total money in Cart is:\n"); // 关闭方括号  
		sb.append(calcSubTotal()); // 关闭方括号  
		return sb.toString();
	}

	public ArrayList<AmazonCartItem> getamazonCartItems() {
		return amazonCartItems;
	}


	////// Setters and Getters


	public AmazonCustomer getamazonCustomer() {
		return amazonCustomer;
	}

	public void setamazonCustomer(AmazonCustomer amazonCustomer) {
		this.amazonCustomer = amazonCustomer;
	}



	public void set(ArrayList<AmazonCartItem> amazonCartItems) {
		this.amazonCartItems = amazonCartItems;
	}

	public float getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(float orderValue) {
		this.orderValue = orderValue;
	}

	public List<AmazonProduct> getamazonProducts() {
		return amazonProducts;
	}

	public void setamazonCustomertAps(List<AmazonProduct> amazonProducts) {
		this.amazonProducts = amazonProducts;
	}


	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	} 



}
