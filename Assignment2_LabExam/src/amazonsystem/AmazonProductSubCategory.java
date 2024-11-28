 package amazonsystem;

public class AmazonProductSubCategory extends AmazonProductCategory {
	private String subCategoryName;
	public AmazonProductSubCategory (String categoryName, String subCategoryName) {
		super(categoryName);
		this.subCategoryName = subCategoryName;	
	}
	
	public AmazonProductSubCategory (AmazonProductCategory inputCat, String subCategoryName) {
		super(inputCat);
		this.subCategoryName = subCategoryName;	
	}
	

	
	// Setters and getters
	public String getSubCategoryName() {
		return subCategoryName;
	}
	
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	
	public String getCategoryName() {
		return super.getCategoryName();
	}
	
	public void setCategoryName(String CategoryName) {
		super.categoryName = CategoryName;
	}
	
}