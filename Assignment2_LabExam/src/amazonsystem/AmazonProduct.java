package amazonsystem;



public class AmazonProduct {


	private int id;
	private String name;
	private static AmazonProductCategory objectAPC;
	private static AmazonProductSubCategory objectPSC;
	private String categoryName;
	private String subcategoryName;
	private String imageURL;
	private String link;
	private float rating;
	private int nRatings;
	private float discoutPrice;
	private float actualPrice;
	
	private String[] title= {"Item ID", "Product Name", "Product Category", "Product Sub Category",
			"Image URL", "Link", "Rating", "N-Rating", "Discount Price", "Actual Price"};
//	static String[] title1= {"Item ID", "Product Name", "Product Category", "Product Sub Category",
//			"Image URL", "Link", "Rating", "N-Rating", "Discount Price", "Actual Price"};	
	
	AmazonProductUtil utilityClass = new AmazonProductUtil();

	

	// Setters and getters for variables, including for the String array Title.
	public String[] getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setnRatings(int nRatings) {
		this.nRatings = nRatings;
	}

	public void setDiscoutPrice(float discoutPrice) {
		this.discoutPrice = discoutPrice;
	}

	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public void setTitle(String[] titleString) {
		this.title = titleString;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public String getLink() {
		return link;
	}

	public float getRating() {
		return rating;
	}

	public int getnRatings() {
		return nRatings;
	}

	public float getDiscoutPrice() {
		return discoutPrice;
	}

	public float getActualPrice() {
		return actualPrice;
	}
	
	public String getSubcategoryName() {
		return subcategoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	// An object of AmazonProduct created by directly passing relevant variables.
	public AmazonProduct(int id, String name, AmazonProductCategory categoryName, AmazonProductSubCategory subcategoryName,String imageURL, String link,
			float rating, int nRatings, float discoutPrice, float actualPrice) {
		this.id = id;
		this.name = name;
        this.categoryName = objectAPC.getCategoryName();  
        this.subcategoryName = objectPSC.getSubCategoryName(); 
		this.imageURL = imageURL;
		this.link = link;
		this.rating = rating;
		this.nRatings = nRatings;
		this.discoutPrice = discoutPrice;
		this.actualPrice = actualPrice;
		this.setTitle(title);
	}
	
	
	// String array instantiation of the AmazonProduct class
	public AmazonProduct(String[] productStrArray) {
		objectAPC = new AmazonProductCategory(productStrArray[2]);
		objectPSC = new AmazonProductSubCategory(objectAPC, productStrArray[3]);
		this.id = Integer.parseInt(productStrArray[0]);
		this.name = productStrArray[1];
		this.imageURL = productStrArray[4];
		this.link = productStrArray[5];
		//this.rating = utilityClass.convertStrToFloat(productStrArray[6]);
		this.rating = AmazonProductUtil.convertStrToFloat(productStrArray[6]);
		this.nRatings = Integer.parseInt(productStrArray[7]);
		//this.discoutPrice = utilityClass.convertStrToFloat(productStrArray[8]);
		//this.actualPrice = utilityClass.convertStrToFloat(productStrArray[9]);
		this.discoutPrice = AmazonProductUtil.convertStrToFloat(productStrArray[8]);
		this.actualPrice = AmazonProductUtil.convertStrToFloat(productStrArray[9]);
	}
	
	
	// A method to parse file data and reject it if it's innapropriate.
	public static AmazonProduct createAmazonProduct(String[] dataStr) {
		AmazonProduct amazonproduct;
		if ((dataStr==null)||(dataStr.length)!=10)
			return null;
		for (String s:dataStr) {
			if (s != null) {
				if (s.isBlank()||s.isEmpty())
				return null;
			}
		}
		
			try { // Secondary portion to convert String variables into appropriate data types.
				int id=Integer.parseInt(dataStr[0]);
//				AmazonProductCategory prodCat = new AmazonProductCategory(dataStr[2]);
//				AmazonProductSubCategory prodSubCat = new AmazonProductSubCategory(prodCat, dataStr[3]);
				objectAPC = new AmazonProductCategory(dataStr[2]);
				objectPSC = new AmazonProductSubCategory(objectAPC, dataStr[3]);
				float rating = AmazonProductUtil.convertStrToFloat(dataStr[6]);
				int nRatings = Integer.parseInt(dataStr[7]);
				float discoutPrice = AmazonProductUtil.convertStrToFloat(dataStr[8]);
				float actualPrice = AmazonProductUtil.convertStrToFloat(dataStr[9]);
				return amazonproduct = new AmazonProduct(id, dataStr[1], objectAPC, objectPSC, dataStr[4], dataStr[5],
						rating, nRatings, discoutPrice, actualPrice); 
			}catch (NumberFormatException e) {  
		        return null;  
		    }
	}
	

	//static String[] title1= {"id","name","main_category","sub_category","image","link","ratings","no_of_ratings","discount_price","actual_price"};
	
	// ANSI Format codes for presentation purposes for the toString function below.
	String boldT = "\033[0;1m\033[4m\u001B[33m";
	String bold = "\033[0;1m\u001B[96m";
	String boldOff = "\033[0;0m";
	
	// A toString function to print out a given product based on set titles.
	public String toString() {
	  
		 //Formatted Titles and data.
		  String s = 
			boldT + title[0] + ":		" + boldOff + this.id + "\n" +  
			bold + title[1] + ":		" + boldOff + this.name + "\n" +
			bold + title[2] + ":	" + boldOff + objectAPC.getCategoryName()+ "\n" +
			bold + title[3] + ":	" + boldOff + objectPSC.getSubCategoryName()+  "\n" +
			bold + title[4] + ":		" + boldOff + this.imageURL + "\n" + 
			bold + title[5] + ":			" + boldOff + this.link +  "\n" +
			bold + title[6] + ":			" + boldOff + this.rating + "\n" +
			bold + title[7] + ":		" + boldOff + this.getnRatings() +  "\n" + 
			bold + title[8] + ":		" + boldOff + this.getDiscoutPrice() + "\n" +
			bold + title[9] + ":		" + boldOff + this.actualPrice +  "\n\n"; 
	  return s;
	}
	
	public String simpletoString() {
		  
		 //Formatted Titles and data.
		  String s = 
			boldT + title[0] + ":		" + boldOff + this.id + "\n" +  
			bold + title[1] + ":		" + boldOff + this.name + "\n" +
			bold + title[8] + ":		" + boldOff + this.getDiscoutPrice() + "\n" +
			bold + title[9] + ":		" + boldOff + this.actualPrice +  "\n\n"; 
	  return s;
	}


	
}
