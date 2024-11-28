package amazonsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class AmazonCustomer {

	private int id;
	private String name;
	private String address;
	//	public AmazonCart amazonCartInstantiation;
	public AmazonCart amazonCart;
	private float creditAmount;
	private AmazonCredit amazoncredit;
	List<AmazonCredit> amazonCredits = new ArrayList<AmazonCredit>();
	List<AmazonProduct> productwishlist = new ArrayList<AmazonProduct>();
	ArrayList<AmazonCartItem> amazonCartItems=new ArrayList<AmazonCartItem>() ;
	Map<Integer, AmazonProduct> commentMap = new HashMap<>();
	List<AmazonComment> amazonCommentList = new ArrayList<AmazonComment>();





	private AmazonCustomer(int cid, String cname, String cadd) {
		this.id=cid;
		this.name=cname;
		this.address=cadd;
		//this.amazonCartInstantiation = new AmazonCart(this, new Date()); // Create cart during customer creation
		this.amazonCart= new AmazonCart(this, new Date());;
	}

	// A method to parse Customer String array data (a line of inputs) and create an Amazon Customer instance.
	//	public static AmazonCustomer createAmazonCustomer(String[] custDataStr) {
	//		AmazonCustomer amazonCustomer;
	//		if ((custDataStr==null)||(custDataStr.length) != 3)
	//			return null;
	//		for (String s:custDataStr) {
	//			if (s.isBlank()||s.isEmpty())
	//				return null;
	//			}
	//			try { // Secondary portion to convert String variables into appropriate data types.
	//				int cid = Integer.parseInt(custDataStr[0]);
	//				String cname = custDataStr[1];
	//				String cadd = custDataStr[2];
	//				
	//				return amazonCustomer = new AmazonCustomer(cid, cname, cadd); 
	//			
	//			}catch (NumberFormatException e) {  
	//				return null;  
	//			}
	//	
	//			try {         
	//				
	//		    }	


	// A method to parse file data and reject it if it's inappropriate.
	public static AmazonCustomer createAmazonCustomer(String[] dataStr) {
		AmazonCustomer amazoncustomer;

		if ((dataStr==null)||(dataStr.length)!=3)
			return null;
		for (String s:dataStr) {
			if (s.isBlank()||s.isEmpty())
				return null;
		}
		try { // Secondary portion to convert String variables into appropriate data types.
			int id=Integer.parseInt(dataStr[0]);
			String name=dataStr[1];
			String address=dataStr[2];
			return amazoncustomer = new AmazonCustomer(id, name, address); 
		}catch (NumberFormatException e) {  
			return null;  
		}
	}	

	public void moveFromCartToComments(ArrayList<AmazonCartItem> cartItems) {
		for (AmazonCartItem amazonCartItem : cartItems) {
			if (!commentMap.containsKey(amazonCartItem.getProduct().getId())) {
				commentMap.put(amazonCartItem.getProduct().getId(), amazonCartItem.getProduct());
			}
		}
		cartItems.clear();
	}

	public void addCredit(AmazonCredit ac) {
		amazonCredits.add(ac);
	}

	public float totalCredit() {
		float totalCreditAmount=0f;
		for (AmazonCredit ac:amazonCredits) {
			totalCreditAmount+=ac.getAmount();
		}
		return totalCreditAmount;
	}

	public void showCredit() {
		for (AmazonCredit ac:amazonCredits) {
			System.out.print(ac.toString());
		}
	}

	public void addProductInWishList(AmazonProduct ap) {
		productwishlist.add(ap);
	}
	
	public void removeProductFromWishlist(AmazonProduct ap) {
		Iterator<AmazonProduct> iterator = productwishlist.iterator();
			while (iterator.hasNext()) {
				AmazonProduct product = iterator.next();
				if (product.equals(ap)) {
					iterator.remove();
				}
			}
	}

	public boolean isProductInWishList(AmazonProduct ap) {
		// TODO Auto-generated method stub
		// IS this loop correct, or do we need to iterate to find the specific id
		// And then delete it.
		for(AmazonProduct aP: productwishlist) {
			if (aP.equals(ap))
				return true;	
		}
		return false;
	}

	public void showWishList() {
		for(AmazonProduct aP: productwishlist) {
			System.out.print(aP.toString());
		}
	}

	public void addItemInCart(AmazonCartItem amazoncartItem) {
		amazonCartItems.add(amazoncartItem);
	}

	public void setItemListInCart(ArrayList<AmazonCartItem> amazoncartItems) {
		this.amazonCartItems=amazoncartItems;

	}

	public ArrayList<AmazonCartItem> getItemList() {
		return amazonCartItems;
	}


	@SuppressWarnings("unlikely-arg-type")
	public void removeProductFromCart(AmazonProduct amazonProduct) {
		//		// TODO Auto-generated method stub
		if(amazonCartItems.contains(amazonProduct)) {
			id=amazonCartItems.indexOf(amazonProduct);
			amazonCartItems.remove(id);
		}


	}
	public void showCart() {

	}

	public void pay(AmazonCredit ac) {
		//		if(act.calcSubTotal()<totalCredit()) {
		//			// have already buy some product;
		//			//money reduce;
		//		}else {
		//			System.out.println("The total amount is not enough");
		//		}
	};

	//	public void moveFromCartToComments() {};
	public boolean hasProductToComment(AmazonProduct product) {
		for (int i=0; i < AmazonManager.amazonProducts.size();i++) {
		if (product==AmazonManager.amazonProducts.get(i)) {
			return true;
		}

	}
		
		return false;};
		
		public void addComment(AmazonComment newComment) {
			amazonCommentList.add(newComment);
		};
		
		
		public void setComment(AmazonProduct ap, String comment, float starRating) {
			AmazonComment newComment = new AmazonComment(ap);
			newComment.setComment(comment);
			newComment.setRating(starRating);
			addComment(newComment);
		};
		
		
		public void showComments() {
			for(AmazonComment comment:amazonCommentList) {
				System.out.println("The current user is :"+
						getName()+'\n'+
						comment.toString());
			}
		}


		// The required toString method
		@Override
		public String toString() {
			return "AmazonCustomer [id=" + id + ", name=" + name + ", address=" + address + "]";
		};



		////// Getters and Setters


		public int getId() {
			return this.id;
		}

		public Map<Integer, AmazonProduct> getCommentMap() {
			return commentMap;
		}

		public void setCommentMap(Map<Integer, AmazonProduct> commentMap) {
			this.commentMap = commentMap;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public AmazonCart getAmazonCartInstantiation() {
			return amazonCart;
		}

		public void setAmazonCartInstantiation(AmazonCart amazonCart) {
			this.amazonCart = amazonCart;
		}

		public float getCreditAmount() {
			return creditAmount;
		}

		public void setCreditAmount(float creditAmount) {
			this.creditAmount = creditAmount;
		}

		public AmazonCredit getAmazoncredit() {
			return amazoncredit;
		}

		public void setAmazoncredit(AmazonCredit amazoncredit) {
			this.amazoncredit = amazoncredit;
		}

		public List<AmazonCredit> getAmazonCredits() {
			return amazonCredits;
		}

		public void setAmazonCredits(List<AmazonCredit> amazonCredits) {
			this.amazonCredits = amazonCredits;
		}

		public List<AmazonProduct> getProductwishlist() {
			return productwishlist;
		}

		public void setProductwishlist(List<AmazonProduct> productwishlist) {
			this.productwishlist = productwishlist;
		};


}	

