package amazonsystem;


public class AmazonProduct_H {


	private int id;
	private String name;
	private AmazonProductCategory0 objectPC;
	private AmazonProductSubCategory0 objectPSC;
	private String categoryName;
	private String subcategoryName;
	private String imageURL;
	private String link;
	private float rating;
	private int nRatings;
	private float discoutPrice;
	private float actualPrice;
	
	private String[] title;
	static String[] title1= {"Item ID", "Product Name", "Product Category", "Product Sub Category",
			"Image URL", "Link", "Rating", "N-Rating", "Discount Price", "Actual Price"};	
	AmazonProductUtil utilityClass = new AmazonProductUtil();

	private AmazonProduct_H(int id, String name, AmazonProductCategory0 objectPC, AmazonProductSubCategory0 objectPSC,String imageURL, String link,
			float rating, int nRatings, float discoutPrice, float actualPrice) {
		this.id = id;
		this.name = name;
        this.categoryName = objectPC.getCategoryName();  
        this.subcategoryName = objectPSC.getSubCategoryName(); 
		this.imageURL = imageURL;
		this.link = link;
		this.rating = rating;
		this.nRatings = nRatings;
		this.discoutPrice = discoutPrice;
		this.actualPrice = actualPrice;
		this.setTitle(title1);
	}
	
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

	// String array instantiation of the AmazonProduct class
	public AmazonProduct_H(String[] productStrArray) {
		objectPC = new AmazonProductCategory0(productStrArray[2]);
		objectPSC = new AmazonProductSubCategory0(productStrArray[3]);
		this.id = Integer.parseInt(productStrArray[0]);
		this.name = productStrArray[1];
		this.imageURL = productStrArray[4];
		this.link = productStrArray[5];
		this.rating = utilityClass.convertStrToFloat(productStrArray[6]);
		this.nRatings = Integer.parseInt(productStrArray[7]);
		this.discoutPrice = utilityClass.convertStrToFloat(productStrArray[8]);
		this.actualPrice = utilityClass.convertStrToFloat(productStrArray[9]);
	}
	
	public static AmazonProduct_H createAmazonProduct(String[] dataStr) {
		AmazonProduct_H amazonproduct;
		if ((dataStr==null)||(dataStr.length)!=10)
			return null;
		for (String s:dataStr) {
			if (s.isBlank()||s.isEmpty())
				return null;
			}

		//input format :str = {"1", "Prod1", "Cat1", "Subcat1", "Img1", "URL1", "1", "10", "1.1", "10.1"};
			try {
				int id=Integer.parseInt(dataStr[0]);
				float rating = AmazonProductUtil.convertStrToFloat(dataStr[6]);
				int nRatings = Integer.parseInt(dataStr[7]);
				float discoutPrice = AmazonProductUtil.convertStrToFloat(dataStr[8]);
				float actualPrice = AmazonProductUtil.convertStrToFloat(dataStr[9]);
				String name = dataStr[1];
				String imageURL = dataStr[4];
				String link = dataStr[5];
				AmazonProductCategory0 objectPC = new AmazonProductCategory0(dataStr[2]);
				AmazonProductSubCategory0 objectPSC = new AmazonProductSubCategory0(dataStr[3]);
				return amazonproduct = new AmazonProduct_H(id, name, objectPC, objectPSC, imageURL,link,
					rating, nRatings, discoutPrice, actualPrice); 
			}catch (NumberFormatException e) {  
		        return null;  
		    }
	}
	




	public void setTitle(String[] titleString) {
		this.title = titleString;
	}
	public int getId() {
		return id;
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
			bold + title[2] + ":	" + boldOff + objectPC.getCategoryName()+ "\n" +
			bold + title[3] + ":	" + boldOff + objectPSC.getSubCategoryName()+  "\n" +
			bold + title[4] + ":		" + boldOff + this.imageURL + "\n" + 
			bold + title[5] + ":			" + boldOff + this.link +  "\n" +
			bold + title[6] + ":			" + boldOff + this.rating + "\n" +
			bold + title[7] + ":		" + boldOff + this.getnRatings() +  "\n" + 
			bold + title[8] + ":		" + boldOff + this.getDiscoutPrice() + "\n" +
			bold + title[9] + ":		" + boldOff + this.actualPrice +  "\n\n"; 
	  return s;
	}	
	
}
