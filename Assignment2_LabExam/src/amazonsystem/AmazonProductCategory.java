package amazonsystem;


public class AmazonProductCategory {
	protected String categoryName;
	public AmazonProductCategory (String categoryName) {
		this.categoryName = categoryName;	
	}
	public AmazonProductCategory (AmazonProductCategory inputCat) {
		this.categoryName = inputCat.categoryName;
	}
	
	
	//Setters and getters
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}