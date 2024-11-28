package amazonsystem;

public class AmazonCartItem {
	private AmazonProduct product;
	private int quantity;
	
	public AmazonCartItem(AmazonProduct ap, int itemQu){
		this.product=ap;
		this.quantity=itemQu;
	};
	
		

	public float calSubTotal(){
		return product.getActualPrice()*quantity;
	}

//	@Override
//	public String toString() {
//		return "AmazonCartItem [product.actualPrice=" + product.getActualPrice() + ", quantity=" + quantity + ", calSubTotal()=" + calSubTotal()
//				+ "]";
//	};
//	
	
	
	
	
	////// Getters and Setters
	
	public AmazonProduct getProduct() {
		return product;
	}


	@Override
	public String toString() {
		return "\n product is: \n " + getProduct().toString() + "Quanity is: "
				+ getQuantity()+"\n"+"Subtotal: " + calSubTotal();
	}



	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setProduct(AmazonProduct product) {
		this.product = product;
	}

	
	
}
