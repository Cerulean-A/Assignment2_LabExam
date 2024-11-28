package amazonsystem;


public class AmazonComment {

	String comment = "";
	AmazonProduct product;
	float rating = 0.0f;

	/*	
	// Likely won't be needed so complicatedly. It looks like comments are ONLY on the customer account. Review the diagram.
	AmazonComment(AmazonCustomer customer1, AmazonProduct product1) { 
		this.customer = customer1;
		this.product = product1;
	}
	 */
	
	AmazonComment(String comment, AmazonProduct product, float rating) { 
		this.product = product;
		this.comment = comment;
		this.rating = rating;
	}
	
	AmazonComment(AmazonProduct product) { 
		this.product = product;
	}


//	public String toString() {
//		String formattedNumber = String.format("%.1f", rating);
//		String commentString = comment + " - rate: " + formattedNumber;
//		return commentString;
//	}

	

	// Getters and Setters
	public String getComment() {
		return comment;
	}

	@Override
	public String toString() {
		return "Comment for:\n"
				+ product + "\n" +
				"Comment: " + comment + "\n" +
				"Rating: " + rating  ;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public AmazonProduct getProduct() {
		return product;
	}

	public void setProduct(AmazonProduct product) {
		this.product = product;
	}

	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating=rating;
	}

}
