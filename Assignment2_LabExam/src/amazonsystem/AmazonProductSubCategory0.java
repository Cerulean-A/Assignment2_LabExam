package amazonsystem;



public class AmazonProductSubCategory0 extends AmazonProductCategory0 {
	private String subCategoryName;
	public AmazonProductSubCategory0 (String categoryName,String subCategoryName) {
		super(categoryName);
		this.subCategoryName = subCategoryName;	
	}
	
	public AmazonProductSubCategory0 (String subCategoryName) {
		super();
		this.subCategoryName = subCategoryName;	
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getCategoryName() {
//		return getCategoryName();
		return super.getCategoryName();
	}
	
	public void setCategoryName(String CategoryName) {
		super.categoryName = CategoryName;
//		super.setCategoryName(CategoryName);
	}
	
}
