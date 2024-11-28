package amazonsystem;
//import java.util.Scanner;
//
//
//public class main {
//
//	public static Scanner input= new Scanner(System.in);
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		main APM = new main();
//		printActions();
//		String inputString=null;
//		
//		System.out.println("");
//		printActionsend();
//		System.out.print("\033[F"); 
//		System.out.print("\033[F"); 
//		System.out.print("\033[F");
//		System.out.print("Choose an option: ");
//		if(scanner.hasNext()) {
//			inputString=scanner.next();
//		}
//		System.out.println("");
//
//		
//
//		System.out.println("The input is :"+inputString);
//		
//	}
//		public static void printActions() {
//		    String textBlock = """
//				================================
//				|| Menu - Amazon Products: A1 ||
//				================================
//				0. Exit
//				1. Load product list
//				2. Show product list
//				3. Add product
//				4. Edit a product
//				5. Delete a product
//				6. Save product list
//				7. Search in the list""";
//        System.out.println(textBlock + " ");  
//		}
//		public static void printActionsend() {
//		    String textBlock = """
//				================================
//				|| Menu - Amazon Products: A2 ||
//				================================
//				""";
//        System.out.println(textBlock + " ");  
//		}
//}

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;  

public class jfileChooser {  
    public static void main(String[] args) {  
    	jfileChooser m = new jfileChooser();
    	m.chooser();
    	
    } 	
        // 创建一个 JFrame 窗口  
//        JFrame frame = new JFrame("JFileChooser Example");  
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//        frame.setSize(400, 300);  
//        
//        // 创建 JFileChooser 实例  
//        JFileChooser fileChooser = new JFileChooser();  
//
//        // 显示打开文件对话框  
//        int returnValue = fileChooser.showOpenDialog(null);  
//
//        if (returnValue == JFileChooser.APPROVE_OPTION) {  
//            // 用户选择了一个文件  
//            File selectedFile = fileChooser.getSelectedFile();  
//            System.out.println("Selected file: " + selectedFile.getAbsolutePath());  
//        } else {  
//            System.out.println("Open command was canceled.");  
//        }  
//
//        // 关闭窗口  
//        frame.setVisible(true);  
//    	 JFileChooser chooser = new JFileChooser();  
//    	 FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF IMAGE","jpg","gif");
//    	 chooser.setFileFilter(filter);
//    	 int returnVal = chooser.showOpenDialog(null);
//    	 if(returnVal == JFileChooser.APPROVE_OPTION) {
//    		 System.out.println(""+ chooser.getSelectedFile().getName());
//    	 }
    	
    	public void chooser(){
    		 JFileChooser chooser = new JFileChooser();  
    		 FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF IMAGE","jpg","gif");
    		 chooser.setFileFilter(filter);
    		 int returnVal = chooser.showOpenDialog(null);
    		 if(returnVal == JFileChooser.APPROVE_OPTION) {
    			 System.out.println(""+ chooser.getSelectedFile().getName());
    		 }
    		
    	
    }  
    	
}


