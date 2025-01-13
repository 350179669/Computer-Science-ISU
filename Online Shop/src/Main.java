import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Amazon Shop");
        System.out.println("ELECTRONICS " + "TOYS " + "BOOKS");
        System.out.print("Enter category to view:");
        String Category = sc.nextLine();

        if (Category.toUpperCase().equals("ELECTRONICS")) {
            System.out.println("you have selected ELECTRONICS");
         } else if (Category.toUpperCase().equals("TOYS")) {
            System.out.println("you have selected TOYS");
         } else if (Category.toUpperCase().equals("BOOKS")) {
            System.out.println("You have selected BOOKS");
         } else {
            System.out.println("Please enter a valid category!\nELECTRONICS | TOYS | BOOKS");
         }
         String[] ProductNames = {"Iphone:", "Macbook:", "Ipad:", "Lego City:", "Nerf Gun:", "Barbie Doll:", "Diary of a Wimpy Kid:", "Captain Underpants:", "Dictionary:"};
         Double[] ProductPrices = {1000.99, 1500.99, 800.99, 56.99, 68.99, 24.99, 13.99, 18.99, 26.99};
         if (Category.toUpperCase().equals("ELECTRONICS")){
            System.out.println("ELECTRONICS");
         for (int i = 0; i < 3; i++) {
            int ProductStock =(int) (Math.random() * 6);
            System.out.println(ProductNames[i]);
            System.out.println("$" + ProductPrices[i]);
            System.out.println("# of items: " + ProductStock);
           if (ProductStock == 0) {
            System.out.println("Product is out of stock");
           }
         }
         if (Category.toUpperCase().equals("TOYS")){
            System.out.println("TOYS");
         for (int i = 3; i < 6; i++) {
            int ProductStock=(int) (Math.random() * 6);
            System.out.println(ProductNames[i]);
            System.out.println("# of items: " + ProductStock);
         if (ProductStock == 0) {
            System.out.println("Product is out of stock");
            }
            
         }            
         }
         
         if (Category.toUpperCase().equals("BOOKS")){
            System.out.println("BOOKS");
            for (int i = 0; i < 3; i++){
               int ProductStock = (int) (Math.random() * 6);
               System.out.println(ProductNames[i]);
               System.out.println("# of items: " + ProductStock);
               if (ProductStock == 0) {
                  System.out.println("Product is out of stock");
               }
            }
         }

        

    }
   }
   }