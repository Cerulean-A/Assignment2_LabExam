package amazonsystem;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.BufferedReader;
import java.io.File;

import java.awt.*;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.temporal.ValueRange;
import java.util.List;
import java.util.regex.Pattern;


public class AmazonManager {
	//testestetstetstst FOR GITHUB--

	Scanner menuInput = new Scanner(System.in);
	FileChooser myChoice = new FileChooser();
	private static String csvFileNameSave = "D:\\Sample-Amazon-Products-v3.csv";


	//private static AmazonManagerList AML = new AmazonManagerList ();

	public static AmazonProductUtil utilityClass = new AmazonProductUtil();

	public static ArrayList<AmazonProduct>amazonProducts = new ArrayList<AmazonProduct>();
	public static ArrayList<AmazonCartItem>amazonCartItems = new ArrayList<AmazonCartItem>();
	public static ArrayList<AmazonCustomer>amazonCustomers = new ArrayList<AmazonCustomer>();
	public static ArrayList<AmazonComment>amazonComments = new ArrayList<AmazonComment>();
	//	ArrayList<AmazonCartItem> currentPaidCart;
	//List<AmazonCredit> amazonCreditArrayList = new ArrayList<AmazonCredit>();
	Map<Integer, Float> customerCreditTotalMap = new HashMap<>();
	Map<Integer, AmazonCart> customerCartMap = new HashMap<>();

	Map<Integer, Float> customerPayItemTotalMap = new HashMap<>();


	AmazonCustomer amazonCustomer;
	//	AmazonCartItem amazoncartItem;
	AmazonProduct amazonProduct;
	AmazonCart amazonCart;

	float CustomerCreditTotalInital=0;
	//ArrayList<AmazonCartItem> CustomerCartInitals=new ArrayList<AmazonCartItem>();

	float CustomerCreditTotal=0;

	public AmazonManager() {
		menuInput = new Scanner(System.in);
	}

	public static void main(String[] args) {
		AmazonManager AM = new AmazonManager();

		char charVal;
		boolean flag = true; //The flag marks correct option.
		while(flag) {
			Pattern pattern = Pattern.compile("[a-t;A-T]");
			mainMenu();
			//			AM.loadProductList();
			System.out.print("Input a char: ");
			charVal = AM.menuInput.next().charAt(0);
			char upperCaseCharVal = Character.toUpperCase(charVal);
			//				AM.menuInput.close();
			//AM.loadProductList();
			if (charVal >= 'a' && charVal <= 'e' || charVal >= 'A' && charVal <= 'E') {
				System.out.println("Choose an option: \033[92m" + charVal + "\033[0m");
			} else 
				if (charVal >= 'f' && charVal <= 'p' || charVal >= 'F' && charVal <= 'P') {
				System.out.println("Choose an option: \033[96m" + charVal + "\033[0m");
			} else 
				if (charVal == 'q' || charVal == 'Q') {
					System.out.println("Choose an option: \033[31m" + charVal + "\033[0m");
			}			
			
			
			if (pattern.matcher(String.valueOf(charVal)).matches()) {

				try {	// The start of a try catch block to catch and handle an exception that arises from putting a non-integer value in.

					switch (upperCaseCharVal) {
					case 'A' -> AM.loadProductList();//finished
					case 'B' -> AM.showProductList();//finished
					case 'C' -> AM.searchProductList();//finished
					case 'D' -> AM.addCustomer();//finished
					case 'E' -> AM.showCustomers();//finished
					case 'F' -> AM.addCreditToCustomers();
					case 'G' -> AM.showCreditFromCustomer();
					case 'H' -> AM.addProductinWishList();
					case 'I' -> AM.removeProductFromWishList();
					case 'J' -> AM.showWishList();
					case 'K' -> AM.addProductinCart();
					case 'L' -> AM.removeProductinFromCart();
					case 'M' -> AM.showProductCart();
					case 'N' -> AM.payCart();
					case 'O' -> AM.addCommentToProduct();
					case 'P' -> AM.showComments();
					case 'Q' -> AM.exit();
					//case 'S' -> AM.findCustomerById(cId);
					//case 'T' -> AM.findProductById(pId); 
					}	
				}
				catch(IllegalArgumentException e) {													// This catches the numberFormatException that occurs when you don't input an integer.
					System.err.println("Error: You did not input an integer value. Try again.\n");	// This handles the numberFormatException by printing out a line telling the user the error.
				}
			}
			else {														// If the value is NOT part of the acceptable range.
				System.out.println(" --> There is no such option, please try again.");			// Then print out that there is no option. Menu is still in loop.
			}// We're using our scanner named input to create a String named data from what is input
			// This parses an integer out of data.

		}	

	}



	public static void mainMenu() {

		String mainMenuItemBlock = """
				===========================================================================
				||\u001B[1;32m    ****    ****           ****    ****   *****\u001B[0m      ALGONQUIN COLLEGE ||
				||\u001B[1;32m   **  **  **       \u001B[0m\u001B[1;90m**\u001B[0m\u001B[1;32m    **  **  **  **  ** **\u001B[0m    COURSE: OOP/CST8132 \u001B[32m\u001B[0m||
				||\u001B[1;32m   ******  **       \u001B[0m\u001B[1;90m**\u001B[0m\u001B[1;32m    **  **  **  **  *****\u001B[0m            PROF: PAULO \u001B[32m\u001B[0m||
				||\u001B[1;32m   **  **   ****           ****    ****   **\u001B[0m         TERM: FALL / 2024 \u001B[32m\u001B[0m||
				===========================================================================
				||                      [Menu A2 - Amazon Manager]                       ||
				===========================================================================
				||                                  ||               \u001B[1;36mUSER\u001B[0m                ||
				||                                  ||\u001B[96m Credit options .................. \u001B[0m||
				|| \u001B[1;32mADMIN\u001B[0m                            || \u001B[90m[\u001B[0mF\u001B[90m]\u001B[0m Add credit to customer        ||
				||                                  || \u001B[90m[\u001B[0mG\u001B[90m]\u001B[0m Show credits from customer    ||
				|| \u001B[92mProduct options ................\u001B[0m ||\u001B[96m Wishlist options ................ \u001B[0m||
				|| \u001B[90m[\u001B[0mA\u001B[90m]\u001B[0m Load product list            || \u001B[90m[\u001B[0mH\u001B[90m]\u001B[0m Add product in wishlist       ||
				|| \u001B[90m[\u001B[0mB\u001B[90m]\u001B[0m Show product list            || \u001B[90m[\u001B[0mI\u001B[90m]\u001B[0m Remove product from wishlist  ||
				|| \u001B[90m[\u001B[0mC\u001B[90m]\u001B[0m Search products              || \u001B[90m[\u001B[0mJ\u001B[90m]\u001B[0m Show products from wishlist   ||
				||                                  ||\u001B[96m Cart options .................... \u001B[0m||
				|| \u001B[92mCustomer options ...............\u001B[0m || \u001B[90m[\u001B[0mK\u001B[90m]\u001B[0m Add product in cart           ||
				|| \u001B[90m[\u001B[0mD\u001B[90m]\u001B[0m Add customer                 || \u001B[90m[\u001B[0mL\u001B[90m]\u001B[0m Remove product from cart      ||
				|| \u001B[90m[\u001B[0mE\u001B[90m]\u001B[0m Show customers               || \u001B[90m[\u001B[0mM\u001B[90m]\u001B[0m Show products from cart       ||
				||                                  || \u001B[90m[\u001B[0mN\u001B[90m]\u001B[0m Buy products from cart        ||
				||                                  ||\u001B[96m Comment options ................. \u001B[0m||
				|| ................................ || \u001B[90m[\u001B[0mO\u001B[90m]\u001B[0m Comment products bought       ||
				||            \u001B[90m[\u001B[0m\u001B[91m\033[1mQ\u001B[90m]\u001B[0m Exit              || \u001B[90m[\u001B[0mP\u001B[90m]\u001B[0m List comments from products   ||
				===========================================================================
				""";
		System.out.print(mainMenuItemBlock + "");

	}
	
	private void loadProductList() {

		FileChooser myChoice = new FileChooser();  
		String csvFileName = myChoice.chooserMethod(); 
		System.out.println(csvFileName);

		if(csvFileName!= null && !csvFileName.trim().isEmpty()) {
			createList(csvFileName);	
		}else {
			System.out.println("File selection load failure - Attempting to load Default File.");
				createList("C:\\Knowledge\\Sample-Amazon-Products-v2.csv");        	
		}

		if(!amazonProducts.isEmpty()) {
			System.out.println("Loading has succeeded....\n");
		}else {
			System.out.println("Loading has failed....\n");
		}

	};
	
	private void showProductList(){

		for(AmazonProduct ap: amazonProducts) {
			if (ap != null) {
			System.out.println(ap.toString());
			} else {
				System.out.println("This data is unusable or not in the correct format."); }
		}
	};

	private void showSimpleProductList(){

		for(AmazonProduct ap: amazonProducts) {
			System.out.println(ap.simpletoString());
		}

	};

	private void searchProductList(){
		int searchOptionVal = -1;
		//String rangeInput = "";
		String searchOptionRangeInput = "";
		ValueRange searchOptionRange = ValueRange.of(-1, 9);		
		int correctSearchVal = -1;
		boolean flag = true; //The flag marks correct option.
		printsearchActions();
		while(flag) {
			boolean properSearchVal = false;
			while (!properSearchVal == true) {
				System.out.println("Please type the option number you wish to select: ");	
				try {
					searchOptionVal = Integer.parseInt(menuInput.nextLine());
					if (searchOptionRange.isValidValue(searchOptionVal)) {
						correctSearchVal = searchOptionVal;
						properSearchVal = true;
					}
				} catch(NumberFormatException e) {
					System.out.println("Error: You did not input an acceptable Integer value. Try again.\n");
				}
			}
			search(correctSearchVal);
			flag = false;
		}

	};


	public static void printsearchActions() {
		String textItemBlock = """
				================================
				|| Menu - Amazon Products Item:||
				================================
				0.id
				1.name
				2.main_category
				3.sub_category
				4.image
				5.link
				6.ratings
				7.no_of_ratings
				8.discount_price
				9.actual_price	
				Choose an option: """;
		System.out.println(textItemBlock + " ");
	}
	@SuppressWarnings("unlikely-arg-type")

	private ArrayList<Integer> CusIdList(ArrayList<AmazonCustomer> amazoncustomers){
		ArrayList<Integer> customerIdList = new ArrayList<Integer>();
		AmazonCustomer cs;
		Iterator<AmazonCustomer> iterator = amazoncustomers.iterator();
		if(!amazoncustomers.isEmpty()) {
			//"1", "User1", "Address"
			//System.out.println("amazoncustomers is not empty.....");
			while (iterator.hasNext()) {  
				cs = iterator.next();  
				//	            System.out.println(customer.toString());
				customerIdList.add(cs.getId());
			}
		}   
		return customerIdList;

	}
	private void addCustomer(){
		AmazonCustomer customer;
		ArrayList<Integer>customersId = new ArrayList<Integer>();
		// 获取 Iterator 对象  
		Iterator<AmazonCustomer> iterator = amazonCustomers.iterator();
		if(!amazonCustomers.isEmpty()) {
			//"1", "User1", "Address"
			System.out.println("Print out how many client in the list:");
			while (iterator.hasNext()) {  
				customer = iterator.next();  
				//	            System.out.println(customer.toString());
				customersId.add(customer.getId());
				// 可选：在遍历中删除特定元素

			} 
			System.out.println(customersId.toString());
		} 

		System.out.println("Please input a coustom information:(id,name,address) and spererate by ,");
		String dataStr = menuInput.next(); // 接收输入  

		while(!dataStr.isEmpty()) {
			// 使用 split 方法将字符串分割  
			String[] dataList = dataStr.split(","); 
			if (!customersId.contains(Integer.parseInt(dataList[0])))
			{
				customer = AmazonCustomer.createAmazonCustomer(dataList);

				amazonCustomers.add(customer);
				customerCartMap.put(customer.getId(),new AmazonCart(customer,new Date()));
				customerCreditTotalMap.put(customer.getId(),CustomerCreditTotalInital);
				System.out.println("The current customer has been added:"+customer.getId()+" , and the inital Credit Total is :"+customerCreditTotalMap.get(customer.getId()));
				break;
			}

			else
			{
				System.out.println("Please input a valid ID:");
				dataStr = menuInput.next();
			}
		}


	};



	private void showCustomers(){
		Iterator<AmazonCustomer> iterator = amazonCustomers.iterator();
		while (iterator.hasNext()) {  
			AmazonCustomer customer = iterator.next();  
			System.out.println(customer.toString());  

		}  
	};

	private boolean loginCustomerisValid(int cusIdForCredit){
		ArrayList<Integer>customersId=CusIdList(amazonCustomers);
		while(true) {
			if(!customersId.contains(cusIdForCredit)) {
				System.out.println("Please input a valid customer ID ?");
				cusIdForCredit = Integer.parseInt(menuInput.next()); // 接收输入
				continue;
			}else {
				System.out.println("Your input is valid......");
				return true;
			}	
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	private void addCreditToCustomers(){

		float customerCreditTotal = 0;
		
		AmazonCustomer customer=null;
		System.out.println("Please input the customer ID to increase credit:");

		int cusIdForCredit = Integer.parseInt(menuInput.next()); // 接收输入 
		
		if(loginCustomerisValid(cusIdForCredit)) {
			for (int i=0;i<amazonCustomers.size();i++) {
				if (cusIdForCredit==amazonCustomers.get(i).getId()) {
					customer=amazonCustomers.get(i);
					break;
				}
			}
			
			
			System.out.println("The Customer has TotalCredit is : " + customerCreditTotalMap.get(cusIdForCredit));
			customerCreditTotal = customerCreditTotalMap.get(cusIdForCredit);

			System.out.println("Please input AmazonCheck(A),AmazonCard(B) or AmazonCash(C):");
			char chooseCredit = menuInput.next().charAt(0);
			switch (chooseCredit) {
			case 'A' : 
				System.out.println("Please input the accountnumber,amountcheck to create credit:");
				String[] creditString = utilityClass.lineReader(menuInput.next()); // need to check the valid first.....
				AmazonCheck ac=AmazonCheck.createCheck(creditString);
				System.out.println(ac.toString());
                customer.addCredit(ac);
                CustomerCreditTotal=customer.totalCredit();
				//CustomerCreditTotal+=ac.getAmount();
				//System.out.println("The current user is :+"+cusIdForCredit+"and the total amountCredit is "+CustomerCreditTotal);
				break;//finished
			case 'B' : 
				System.out.println("Please input the cardnumber,cardexpire and the amountCard to create card:");
				String[] cardString = utilityClass.lineReader(menuInput.next()); // need to check the valid first.....
				AmazonCard acard=AmazonCard.createCard(cardString);
				System.out.println(acard.toString());
				customer.addCredit(acard);
				CustomerCreditTotal=customer.totalCredit();
				//System.out.println("The current user is :+"+cusIdForCredit+"and the total amountCredit is "+CustomerCreditTotal);
				break;//finished
			case 'C' : 
				System.out.println("Please input the cashamount to create card:");
				String[] cashString = utilityClass.lineReader(menuInput.next()); // need to check the valid first.....
				AmazonCash acash=AmazonCash.createCash(cashString);
				System.out.println(acash.toString());
				customer.addCredit(acash);
				//amazonCreditArrayList.add(acashCustomer);
				CustomerCreditTotal=customer.totalCredit();
				//System.out.println("The current user is : "+cusIdForCredit+" and the total amountCredit is "+CustomerCreditTotal);
				break;//finished

			} 
			System.out.println("The current user is :+"+cusIdForCredit+"and the total amountCredit is "+CustomerCreditTotal);
			customerCreditTotalMap.put(cusIdForCredit,CustomerCreditTotal);
			System.out.println("The Customer has TotalCredit changed : " + customerCreditTotalMap.get(cusIdForCredit));
		}
	}

	private void showCreditFromCustomer(){

		for (AmazonCustomer amazonCustomer:amazonCustomers) {
			System.out.println("The current user is "+amazonCustomer.getName()+" the totalCreditTotal is : "+customerCreditTotalMap.get(amazonCustomer.getId()));
		}



	};
	private void addProductinWishList(){
		System.out.println("Please input the customer ID to increase Wishlist:");
		int cusIdForWishList = Integer.parseInt(menuInput.next()); // 接收输入 
		System.out.println("Choose Product Id ? ");
		int productId = Integer.parseInt(menuInput.next()); // 接收输入
		AmazonCustomer amazonCustomer=null;
		AmazonProduct amazonProduct=null;
		boolean productExistsInWishList=false;
		boolean customerExistsInWishList=false;
		for (int i=0;i<amazonProducts.size();i++) {
			if (productId==amazonProducts.get(i).getId()) {
				amazonProduct=amazonProducts.get(i);
				productExistsInWishList = true;
				break;
			}
		}
		
		for (int i=0;i<amazonCustomers.size();i++) {
			if (cusIdForWishList==amazonCustomers.get(i).getId()) {
				amazonCustomer=amazonCustomers.get(i);
				customerExistsInWishList = true;
				break;
			}
		}
		
		if(productExistsInWishList&&customerExistsInWishList) {
			amazonCustomer.addProductInWishList(amazonProduct);
		}
		
		
	};
	
	private void removeProductFromWishList(){
		AmazonCustomer amazonCustomer=null;
		AmazonProduct amazonProduct=null;
		System.out.println("Please input the customer ID to decrease Wishlist:");
		int cusIdForWishList = Integer.parseInt(menuInput.next()); // 接收输入 
		System.out.println("Choose Product Id ? ");
		int productId = Integer.parseInt(menuInput.next()); // 接收输入
		boolean productExistsinWishList=false;
		boolean customerExists=false;

		
		for (int i=0;i<amazonCustomers.size();i++) {
			if (cusIdForWishList==amazonCustomers.get(i).getId()) {
				amazonCustomer=amazonCustomers.get(i);
				customerExists = true;
				break;
			}
		}
		
		for (int i=0;i<amazonProducts.size();i++) {
			if (productId==amazonProducts.get(i).getId()) {
				amazonProduct=amazonProducts.get(i);
				productExistsinWishList = true;
				break;
			}
		}
		
		if(amazonCustomer.isProductInWishList(amazonProduct)&&customerExists&&productExistsinWishList) {
			amazonCustomer.removeProductFromWishlist(amazonProduct);
		}
	};
	private void showWishList(){
		AmazonCustomer amazonCustomer=null;
		System.out.println("Please input the customer ID to decrease Wishlist:");
		int cusIdForWishList = Integer.parseInt(menuInput.next()); // 接收输入 
		for (int i=0;i<amazonCustomers.size();i++) {
			if (cusIdForWishList==amazonCustomers.get(i).getId()) {
				amazonCustomer=amazonCustomers.get(i);
				//customerExists = true;
				break;
			}
		}
		amazonCustomer.showWishList();
		
	};


	private void addProductinCart(){

		System.out.println("Please input the customer ID to increase credit:");
		// 		AmazonCart amazonCartPreCustomer;
		//
		//ArrayList<AmazonCartItem> amazonCartItems=new ArrayList<AmazonCartItem>() ;
		AmazonCartItem amazonCartItem;
		AmazonCart amazonCart;


		AmazonCustomer amazonCustomer=null;

		int cusIdForCart = Integer.parseInt(menuInput.next()); // 接收输入 
		//AmazonCustomer amazonCustomer=amazonustomers.get(cusIdForCredit);

		boolean customerExists = false;
		boolean productExists = false;
		for (int i=0;i<amazonCustomers.size();i++) {
			if (cusIdForCart==amazonCustomers.get(i).getId()) {
				amazonCustomer=amazonCustomers.get(i);
				customerExists = true;
				break;
			}

		}

		//for(AmazonCustomer ac:amazoncustomers) {
		//System.out.println(ac.toString());
		if(customerExists) {
//			loadProductList();
			showSimpleProductList();

			int productchooseID = -1;
			int productchooseNum = -1;
			float subtotal=0;
			AmazonProduct amazonProduct=null;
			amazonCart=new AmazonCart(amazonCustomer,new Date());

			ValueRange range = ValueRange.of(-1, 9);		
			//boolean flag = true; //The flag marks correct option.
			String response = "Y";
			while(response.equals("Y")) {
				System.out.println("Choose Product Id ? ");
				productchooseID = Integer.parseInt(menuInput.next());
				System.out.println("Choose number of Products ? ");
				productchooseNum = Integer.parseInt(menuInput.next());	
				for (int i=0;i<amazonProducts.size();i++) {
					if (productchooseID==amazonProducts.get(i).getId()) {
						amazonProduct=amazonProducts.get(i);
						productExists = true;
						break;
					}
				}
				if(productExists) {	
					if(range.isValidValue(productchooseID)&&(productchooseNum<99)) {
						subtotal = amazonProduct.getDiscoutPrice()*productchooseNum;
						//amazonCarItems(amazonProduct);
						amazonCartItem = new AmazonCartItem(amazonProduct, productchooseNum);
						amazonCustomer.addItemInCart(amazonCartItem);
						//amazonCartItems.add(amazonCartItem);
						amazonCart.addItem(amazonCartItem);


					};

				}
				System.out.println("Do you want to continue to choose item (Y/N) ? ");
				response = menuInput.next();
			}
			//System.out.println("The current itemList length is :"+amazonCustomer.getItemList().size());

		}
		amazonCart = new AmazonCart(amazonCustomer,new Date(),amazonCustomer.amazonCartItems);
		customerCartMap.put(cusIdForCart,amazonCart);
		AmazonCart addresultCart=null;
		addresultCart=customerCartMap.get(cusIdForCart);
		if (!(addresultCart==null)) {
			System.out.println("Put into map operation successful! ");
		}

		//	        for (Map.Entry<Integer, AmazonCart> entry : customerCartMap.entrySet()) {  
		//	            System.out.println("CustomerID: " + entry.getKey() + ", The current user Cart include: \n" + entry.getValue().toString());  
		//	        	} 
	}




	@SuppressWarnings("null")
	private void removeProductinFromCart(){
		System.out.println("Please input the customer ID to increase credit:");
		//AmazonCart amazonCartPreCustomer;
		//
		ArrayList<AmazonCartItem> amazonCartItems=null;
		//AmazonCartItem amazonCartItem;
		//AmazonCart amazonCart;

		int productchooseID = -1;
		//int productchooseNum = -1;



		//AmazonCustomer amazonCustomer=null;

		int cusIdForCart = Integer.parseInt(menuInput.next()); // 接收输入 
		//AmazonCustomer amazonCustomer=amazonustomers.get(cusIdForCredit);

		boolean customerExists = false;
		boolean customerCartExists = false;
		for (int i=0;i<amazonCustomers.size();i++) {
			if (cusIdForCart==amazonCustomers.get(i).getId()) {
				amazonCustomer=amazonCustomers.get(i);
				customerExists = true;
				break;
			}
			System.out.println("The result of customer is empty.... ");
		}



		if(customerExists) {
			for (Map.Entry<Integer, AmazonCart> entry : customerCartMap.entrySet()) {  
				//System.out.println("CustomerID: " + entry.getKey() + ", The current user Cart include: \n" + entry.getValue().toString());  
				if(entry.getValue().getamazonCustomer().getId()==cusIdForCart) {
					//	        		for(AmazonCartItem amazoncartItem:amazonCartItems) {
					//	        			System.out.println(amazoncartItem.toString());
					//	        		}	
					if(!(entry.getValue().getamazonCartItems().size()==0)) {
						amazonCartItems=entry.getValue().getamazonCartItems();
						customerCartExists = true;
						System.out.println("The cart of customer is loaded.... ");
						//break;
					}
					else
					{
						System.out.println("The cart of customer is empty.... ");
						break;
					}
				}
				if(customerExists&&customerCartExists) {
					String response = "Y";
					while(response.equals("Y")) {
						System.out.println("Choose Product Id ? ");
						productchooseID = Integer.parseInt(menuInput.next());

						//System.out.println("Choose number of Products ? ");
						//productchooseNum = Integer.parseInt(menuInput.next());
						outerLoop: // 标签 
							for (int i=0;i<amazonProducts.size();i++) {
								if (productchooseID==amazonProducts.get(i).getId()) {
									amazonProduct=amazonProducts.get(i);
									for (AmazonCartItem amazoncartItem:amazonCartItems) {
										if(amazoncartItem.getProduct()==amazonProduct) {
											amazonCartItems.remove(amazoncartItem);
											System.out.println("The item in the cart has been deleted.... ");
											break outerLoop; // 标签 ;		
										}
									}
									//amazonCustomer.removeProductFromCart(amazonProduct);
									break;
								}
							}
						System.out.println("Do you want to continue to choose item (Y/N) ? ");
						response = menuInput.next();
					}

				}

			}
			//System.out.println("Do you want to continue to choose item (Y/N) ? ");

		}

		//System.out.println("The result of customerExist is : "+customerExists);    
		//System.out.println("The result of customerCartExist is : "+customerCartExists);

	};    




	//	        for (AmazonCart cart : customerCartMap.values()) {

	//	                // Remove the expired cart and create a new one
	//	                cartMap.remove(cart.getAc().getId(), cart);
	//	                AmazonCart newCart = new AmazonCart(cart.getAc(), today);
	//	                cartMap.put(cart.getAc().getId(), newCart);

	//	        }





	private void showProductCart(){
		for (Map.Entry<Integer, AmazonCart> entry : customerCartMap.entrySet()) {  
			System.out.println("CustomerID: " + entry.getKey() + ", The current user Cart include: \n" + entry.getValue().toString());  
		} 
	};
	@SuppressWarnings("null")
	private void payCart(){
		System.out.println("Please input the customer ID want to bill:");
		AmazonCart amazonCartPayCustomer=null;
		AmazonCustomer amazonCustomer=null;//
		float AmazonCustomerCartTotal=0;
		float remainCredit=0;
		String response;
		ArrayList<AmazonCartItem> currentPaidCart=null;
		AmazonCartItem amazonCartitem;

		System.out.println("Please input the customer Id who wants to pay ......");
		int cusIdForPaid = Integer.parseInt(menuInput.next()); // 接收输入 
		if(loginCustomerisValid(cusIdForPaid)) {
			for (int i=0;i<amazonCustomers.size();i++) {
				if (cusIdForPaid==amazonCustomers.get(i).getId()) {
					amazonCustomer=amazonCustomers.get(i);
					break;
				}

			}
			for (Map.Entry<Integer, AmazonCart> entry : customerCartMap.entrySet()) {  
				//System.out.println("CustomerID: " + entry.getKey() + ", The current user Cart include: \n" + entry.getValue().toString());  
				if(entry.getValue().getamazonCustomer().getId()==cusIdForPaid) {
					amazonCartPayCustomer=entry.getValue();
				}
			}
			if (amazonCartPayCustomer != null) {
				for(AmazonCartItem amazoncartitem:amazonCartPayCustomer.getamazonCartItems()) {
					AmazonCustomerCartTotal=AmazonCustomerCartTotal+amazoncartitem.getQuantity()*amazoncartitem.getProduct().getActualPrice();
				}
				System.out.println("The current Credit is......"+customerCreditTotalMap.get(cusIdForPaid));
				System.out.println("And you need to pay......"+AmazonCustomerCartTotal);
				remainCredit = (customerCreditTotalMap.get(cusIdForPaid)-AmazonCustomerCartTotal);
				System.out.println("The remaining credit will be "+remainCredit);
				System.out.println("Do you want to pay the cart ?(Y/N) ......");
				response = menuInput.next();
				if(response.equals("Y")&&(remainCredit>=0)) {
					// get cart for customer from cartMap
					//AmazonCart newCart = new AmazonCart(amazonCartPayCustomer.getamazonCustomer(), new Date());
					//customerCartMap.put(amazonCartPayCustomer.getamazonCustomer().getId(), newCart);//not working.....

					customerCreditTotalMap.put(cusIdForPaid,remainCredit);
					amazonCartPayCustomer.pay(AmazonCustomerCartTotal);
					//	 			amazonCustomer.moveFromCartToComments(amazonCartPayCustomer.getamazonCartItems());

				}

			}
			// 				if(ac.getId()==cusIdForCredit) {
			// 					amazonCartPayCustomer=
			// 				};

			// 				if(CustomerCreditTotalMap.containsKey(ac.getId())) {
			// 					System.out.println("The customer map has the tatal Credit is: "+CustomerCreditTotalMap.get(ac.getId()));
			// 				}else {
			// 					System.out.println("Don't find any customer credit recoding.....");
			// 				}

		}

	};

	private void addCommentToProduct(){
		AmazonCustomer customer=null;
		//AmazonProduct productTocomment=null;
		int productId;
		String commentInput = "";
		float rating = 0.0f;
		
		System.out.println("Please input the customer ID want to comment:");
		int cusIdForComment = Integer.parseInt(menuInput.next()); // 接收输入 
		// 		boolean cusIdForCommentExists = false;
		for (int i=0;i<amazonCustomers.size();i++) {
			if (cusIdForComment==amazonCustomers.get(i).getId()) {
				customer=amazonCustomers.get(i);
				//			cusIdForCommentExists = true;
				break;
			}

		}
		if (customer != null) {
			System.out.println("\nThese are the products you have purchased and can make a comment toward:");
			for (Map.Entry<Integer, AmazonProduct> entry: customer.getCommentMap().entrySet())	 {
				Integer product_id = entry.getKey();
				AmazonProduct  product = entry.getValue();
				System.out.println("Product ID : "+ product_id + "	" + "Product : "+ product.getName());
			}
		}
		
		System.out.println("\nPlease enter a product number you want to make a comment toward:");
		productId = Integer.parseInt(menuInput.next());
		
		for (Map.Entry<Integer, AmazonProduct> entry: customer.getCommentMap().entrySet())	 {
			//Integer product_id = entry.getKey();
			if (productId==entry.getKey()) {
				AmazonProduct product = entry.getValue();
				if(customer.hasProductToComment(product)) {
					System.out.println("Commenting product :"+product.getName());
					System.out.println("Enter the comment :");
					commentInput = menuInput.next();
					System.out.println("Enter the stars :");
					rating =  Float.parseFloat(menuInput.next());
					customer.setComment(product, commentInput, rating);
				}; // Else return error and print something why.
			}; // Else return error and print something why.

		}
		
		
		
//		
//		for (int i=0;i<amazonProducts.size();i++) {
//			if (productId==amazonProducts.get(i).getId()) {
//				productTocomment=amazonProducts.get(i);
//				//			cusIdForCommentExists = true;
//				break;
//			}
//		}

		// have user enter product number
		// capture product id
		// call Customer.hasProductToComment(AmazonProduct)  - returns boolean: this will confirm product exists for customer
		// if product found, then pull up details of product
		//   let user enter comment
		//   let user enter start rating in increments of .5
		//   add comment to comment array list on customer

	} 


	private void showComments(){
		AmazonCustomer customer=null;
		System.out.println("Please input the customer ID want to comment:");
		int cusIdForComment = Integer.parseInt(menuInput.next()); // 接收输入 
		// 		boolean cusIdForCommentExists = false;
		for (int i=0;i<amazonCustomers.size();i++) {
			if (cusIdForComment==amazonCustomers.get(i).getId()) {
				customer=amazonCustomers.get(i);
				//			cusIdForCommentExists = true;
				break;
			}

		}
		customer.showComments();
	};
	private void exit(){
		
		String quitBlock = """
				Exiting the program...
				===========================================================================
				||    [End of Application \u001B[35m(Authors: Taylor Houstoun & QianJun Liu)\u001B[0m]      ||
				===========================================================================
				""";
		
		System.out.println(quitBlock);  
		menuInput.close();
		System.exit(0); 
	};
	//	private int findCustomerById(int cId){return 0;};
	//	private int findProductById(int pId){return 0;}; 

	public void createList(String csvFileName) {

		String[] LineArray;  

		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {  
			String line;  
			br.readLine();  
			AmazonProduct ap;
			while ((line = br.readLine()) != null) {   
				LineArray=utilityClass.lineReader(line);
				System.out.println(LineArray);
				ap=AmazonProduct.createAmazonProduct(LineArray);
				//				System.out.println(id+" ".repeat(6)+name+" ".repeat(6)+categoryName.toString()+" ".repeat(6)+subcategoryName.toString()+imageURL.toString()+" ".repeat(6)+link.toString()+" ".repeat(6)+rating+" ".repeat(6)+nRatings+" ".repeat(6)+discountPrice+" ".repeat(6)+actualPrice+" ".repeat(6));

				//				ap = new AmazonProduct(LineArray);

				amazonProducts.add(ap);
			}  
		} catch (IOException e) {
			System.out.println("Failure to load file.\n" + e.getMessage());
			//e.printStackTrace(); // 处理异常  
		} 
	}

	private void search(int choiceId) {
		// TODO Auto-generated method stub
		boolean resultKey = true;
		switch (choiceId) {
		case 0:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextInt()) {
				System.out.println("Please input an integer...");
				menuInput.next(); // Consume the invalid input
			}

			int schCatID = menuInput.nextInt();
			IdValue(schCatID);
			break;

		case 1:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextLine()) {
				System.out.println("Please input an string...");
				menuInput.next(); // Consume the invalid input
			}

			String schCatNAME = menuInput.next();
			nameValue(schCatNAME);
			break;


		case 2:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextLine()) {
				System.out.println("Please input an string...");
				menuInput.next(); // Consume the invalid input
			}

			String schCatCAT = menuInput.next();
			categoryValue(schCatCAT);
			break;

		case 3:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextLine()) {
				System.out.println("Please input an string...");
				menuInput.next(); // Consume the invalid input
			}

			String schCatSUBCAT = menuInput.next();
			subcategoryValue(schCatSUBCAT);
			break;

		case 4:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextLine()) {
				System.out.println("Please input an string...");
				menuInput.next(); // Consume the invalid input
			}
			String schCatIMAGE = menuInput.next();
			imageURLValue(schCatIMAGE);
			break;

		case 5:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextLine()) {
				System.out.println("Please input an string...");
				menuInput.next(); // Consume the invalid input
			}
			String schCatLINK = menuInput.next();
			linkValue(schCatLINK);
			break;

		case 6:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextFloat()) {
				System.out.println("Please input an string...");
				menuInput.next(); // Consume the invalid input
			}
			Float schCatratings = Float.parseFloat(menuInput.next());
			ratingValue(schCatratings);
			break;

		case 7:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextInt()) {
				System.out.println("Please input an string...");
				menuInput.next(); // Consume the invalid input
			}
			int schCatno_of_ratings = menuInput.nextInt();
			nRatingValue(schCatno_of_ratings);
			break;

		case 8:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextFloat()) {
				System.out.println("Please input an float...");
				menuInput.next(); // Consume the invalid input
			}
			Float schCatdiscount_price = Float.parseFloat(menuInput.next());
			discountPrice(schCatdiscount_price);
			break;

		case 9:
			System.out.println("Please type in the keyword/phrase you wish to search for\n");

			while (!menuInput.hasNextFloat()) {
				System.out.println("Please input an float...");
				menuInput.next(); // Consume the invalid input
			}
			Float schCatactual_price = Float.parseFloat(menuInput.next());
			actualPrice(schCatactual_price);
			break;
		}

	}

	// JFileCHooser implementation. Thank you to ...
	// https://docs.oracle.com/javase/8/docs/api/javax/swing/JFileChooser.html
	// https://stackoverflow.com/questions/19302029/filter-file-types-with-jfilechooser
	// And bing AI for code template


	private void IdValue(int value) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			numbers.add(ap1.getId());
		}
		if (numbers.contains(value))
			System.out.println(amazonProducts.get(numbers.indexOf(value)));
		else
			System.out.println("Do not have the item.....");
	}

	public void nameValue(String value) {
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(ap1.getName().contains(value)) {
				System.out.println(ap1.toString());
			}
		}
	}

	public void categoryValue(String value) {
		//	 ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(ap1.getCategoryName().contains(value)) {
				System.out.println(ap1.toString());
			}
		}
	}
	//public static void subcategoryValue(String value) {
	public void subcategoryValue(String value) {
		//	 ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(ap1.getSubcategoryName().contains(value)) {
				System.out.println(ap1.toString());
			}
		}
	}
	//public static void imageURLValue(String value) {
	public void imageURLValue(String value) {
		//	 ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(ap1.getImageURL().contains(value)) {
				System.out.println(ap1.toString());
			}
		}
	}
	//public static void linkValue(String value) {
	public void linkValue(String value) {
		//	 ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(ap1.getLink().contains(value)) {
				System.out.println(ap1.toString());
			}
		}
	}
	//public static void ratingValue(float value) {
	public void ratingValue(float value) {
		//	 ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(value==ap1.getRating()) {
				System.out.println(ap1.toString());
			}
		}
	}
	//public static void nRatingValue(int value) {
	public void nRatingValue(int value) {
		//	 ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(value==ap1.getnRatings()) {
				System.out.println(ap1.toString());
			}
		}
	}
	//public static void discountPrice(float value) {
	public void discountPrice(float value) {
		//	 ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(value==ap1.getDiscoutPrice()) {
				System.out.println(ap1.toString());
			}
		}
	}
	//public static void actualPrice(float value) {
	public void actualPrice(float value) {
		//	 ArrayList<Integer> numbers = new ArrayList<>();
		for (AmazonProduct ap1:amazonProducts) {
			//		numbers.add(ap1.getnRatings());
			if(value==ap1.getActualPrice()) {
				System.out.println(ap1.toString());
			}
		}
	}




	class FileChooser {
		String chooserMethod() {
			JFrame frame = new JFrame();
			frame.setAlwaysOnTop(true);
			frame.setVisible(true);

			String pathname;
			JFileChooser theChoice = new JFileChooser();
			FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Excel Documents", "xls", "xlsx", "xlsm");
			FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("Character Separated Value files", "csv");
			theChoice.setFileFilter(fileFilter);
			theChoice.setFileFilter(csvFilter);
			theChoice.setAcceptAllFileFilterUsed(false);
			int returnVal = theChoice.showOpenDialog(frame);
			theChoice.requestFocusInWindow();
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File chosenFile = theChoice.getSelectedFile();
				System.out.println("You have imported the data from file: " + theChoice.getSelectedFile().getName());
				pathname = chosenFile.getAbsolutePath(); // TODO convert file to pathname
				frame.dispose();
				return pathname;
			}
			frame.dispose();
			return null;
		}
		void saverMethod() {
			JFrame sFrame = new JFrame();
			sFrame.setAlwaysOnTop(true);
			sFrame.setVisible(true);

			JFileChooser saveFile = new JFileChooser();
			FileNameExtensionFilter excelFilter = new FileNameExtensionFilter("Excel Documents", "xls", "xlsx", "xlsm");
			FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("Character Separated Value files", "csv");
			saveFile.addChoosableFileFilter(excelFilter);
			saveFile.addChoosableFileFilter(csvFilter);
			int returnVal = saveFile.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File savedFile = saveFile.getSelectedFile();
				System.out.println("You have saved data to file: " + saveFile.getSelectedFile().getName());
				sFrame.dispose();
			}
			sFrame.dispose();

		}

	}
}

