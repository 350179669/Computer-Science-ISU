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
         int[] ProductStock = new int[9];
         int categoryStartIndex = 0;
         int categoryEndIndex = 0;
         if (Category.toUpperCase().equals("ELECTRONICS")){
            System.out.println("ELECTRONICS");
            categoryStartIndex = 0;
            categoryEndIndex = 3;
         for (int i = 0; i < 3; i++) {
            ProductStock[i] =(int) (Math.random() * 6);
            System.out.println(ProductNames[i]);
            System.out.println("$" + ProductPrices[i]);
            System.out.println("# of items: " + ProductStock[i]);
           if (ProductStock[i] == 0) {
            System.out.println("Product is out of stock");
           }
         }
       }else if (Category.toUpperCase().equals("TOYS")){
            System.out.println("TOYS");
            categoryStartIndex = 3;
            categoryEndIndex = 6;
         for (int i = 3; i < 6; i++) {
            ProductStock[i] =(int) (Math.random() * 6);
            System.out.println(ProductNames[i]);
            System.out.println("# of items: " + ProductStock[i]);
         if (ProductStock[i] == 0) {
            System.out.println("Product is out of stock");
            }
            
         }            
         } else if (Category.toUpperCase().equals("BOOKS")){
            System.out.println("BOOKS");
            categoryStartIndex = 6;
            categoryEndIndex = 9;
            for (int i = 6; i < 9; i++){
               ProductStock[i] = (int) (Math.random() * 6);
               System.out.println(ProductNames[i]);
               System.out.println("# of items: " + ProductStock[i]);
               if (ProductStock[i] == 0) {
                  System.out.println("Product is out of stock");
               }
            }
         }
            ArrayList<String> cart = new ArrayList<>();
            ArrayList<Integer> quantities = new ArrayList<>();
            ArrayList<Double> prices = new ArrayList<>();  
        while (true){
         System.out.println("enter the product number to addd the item to cart\n(or enter \"0\" to exit)");
         int choice = sc.nextInt();
         if (choice == 0){
            break;
         }
         int productIndex = choice -1;
         if (productIndex < categoryStartIndex || productIndex >= categoryEndIndex){
            System.out.println("Invalid product number! Please try again.");
         }else{
            System.out.print("Enter the quantity: ");
            int quantity = sc.nextInt();                                                                                                                                                                                                                         
            if (quantity > ProductStock[productIndex]) {
               System.out.println("Quantity requested exceeds stock");
         } else {
            ProductStock[productIndex] -= quantity;
            cart.add(ProductNames[productIndex]);
            quantities.add(quantity);
            prices.add(ProductPrices[productIndex] * quantity);
            System.out.println("Added " + ProductNames[productIndex] + "x" + quantity);
         }
         System.out.println("Your cart");
         for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i) + " | Quantity: " + quantities.get(i) + " | Total: $" + prices.get(i));
         }
        }
      }
      System.out.println("Thank you for shopping with us!");
      sc.close();
    }
   }