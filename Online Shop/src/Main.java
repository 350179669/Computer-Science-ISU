import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Amazon Shop");
        System.out.println("-----------");
        System.out.println("ELECTRONICS | " + "TOYS | " + "BOOKS ");
        System.out.println("-----------------------------");
        System.out.println("Enter category to view:");
        System.out.println("-----------------------");
        String Category = sc.nextLine();

        if (Category.toUpperCase().equals("ELECTRONICS")) {
            System.out.println("you have selected ELECTRONICS");
            System.out.println("------------------------------");   
         } else if (Category.toUpperCase().equals("TOYS")) {
            System.out.println("you have selected TOYS");
            System.out.println("-----------------------");
         } else if (Category.toUpperCase().equals("BOOKS")) {
            System.out.println("You have selected BOOKS");
            System.out.println("-----------------------");
         } else {
            System.out.println("Please enter a valid category!");
            System.out.println("---------------------");
            System.out.println("ELECTRONICS | TOYS | BOOKS");
         }
         String[] ProductNames = {"Iphone #1:", "Macbook #2:", "Ipad #3:", "Lego City #4:", "Nerf Gun #5:", "Barbie Doll #6:", "Diary of a Wimpy Kid #7:", "Captain Underpants #8:", "Dictionary #9:"};
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
            System.out.println("-----------------------");
           if (ProductStock[i] == 0) {
            System.out.println("Product is out of stock");
            System.out.println("-----------------------");
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
            System.out.println("-----------------------");
         if (ProductStock[i] == 0) {
            System.out.println("Product is out of stock");
            System.out.println("-----------------------");
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
               System.out.println("-----------------------");
               if (ProductStock[i] == 0) {
                  System.out.println("Product is out of stock");
                  System.out.println("-----------------------");
               }
            }
         }
            ArrayList<String> cart = new ArrayList<>();
            ArrayList<Integer> quantities = new ArrayList<>();
            ArrayList<Double> prices = new ArrayList<>();  
            ArrayList<Integer> cartIndices = new ArrayList<>();
        while (true){
         System.out.println("enter the product # to add the item to cart\n(or enter \"0\" to finish)");
         System.out.println("---------------------------------------------------------------------------");
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
            cartIndices.add(productIndex);
            System.out.println("Added " + ProductNames[productIndex] + quantity + "times");
         }
         System.out.println("Your cart");
         System.out.println("-----------------------");
         for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i) + " | Quantity: " + quantities.get(i) + " | Total: $" + prices.get(i));
            System.out.println("------------------------------------------------------------------------------------");
         }

        }
      }
      while (true){
         System.out.print("Would you like to update the quantity of any item in your cart?");
         System.out.println("yes/no");
         System.out.println("-----------------------------------------------------------------");
         String updateChoice = sc.nextLine();
         if (updateChoice.equalsIgnoreCase("no")){
            break;
         }else if (updateChoice.equalsIgnoreCase("yes")){
            System.out.print("Enter the product number to update: ");
            int updateProductIndex = Integer.parseInt(sc.nextLine())-1;

            if (cartIndices.contains(updateProductIndex)){
               int cartIndex = cartIndices.indexOf(updateProductIndex);
               System.out.print("Enter the new quantity: ");
               int newQuantity = sc.nextInt();
               int currentStock = ProductStock[updateProductIndex] + quantities.get(cartIndex);
               if(newQuantity > currentStock){
                  System.out.println("Quantiy requested exceeds available stock!");
               }else{
                  ProductStock[updateProductIndex] = currentStock - newQuantity;
                  quantities.set(cartIndex, newQuantity);
                  prices.set(cartIndex, ProductPrices[updateProductIndex] * newQuantity);
                  System.out.println("Updated" + ProductNames[updateProductIndex] + " to quantity: " + newQuantity);
               }
            } else {
               System.out.println("Product not in cart");
               System.out.println("-----------------------");
            }
         } else {
            System.out.println("Invalid choice, please enter 'yes' or 'no'");
            System.out.println("----------------------------------------------");
         }
         System.out.println("The current cart:");
         System.out.println("-----------------------");
         for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i) + " Quantity: " + quantities.get(i) + " Total: $" + prices.get(i));
         }
            }

            while (true) {
               System.out.println("Would you like to remove any items from your cart?");
               System.out.println("yes/no");
               System.out.println("-----------------------");
               String removeChoice = sc.nextLine();
               if (removeChoice.equalsIgnoreCase("no")) {
                  break;
               } else if (removeChoice.equalsIgnoreCase("yes")) {
                  System.out.println("Enter product number to remove ");
                  System.out.println("-----------------------");
                  int removeProductIndex = Integer.parseInt(sc.nextLine()) - 1;

                  if (cartIndices.contains(removeProductIndex)) {
                     int cartIndex = cartIndices.indexOf(removeProductIndex);
                     int quantityToRemove = quantities.get(cartIndex);
                     ProductStock[removeProductIndex]+= quantityToRemove;
                     cart.remove(cartIndex);
                     quantities.remove(cartIndex);
                     prices.remove(cartIndex);
                     cartIndices.remove(cartIndex);
                     System.out.println("Successfully removed item");
                     System.out.println("-----------------------");
                  } else {
                     System.out.println("Product not found in cart");
                     System.out.println("-----------------------");
                  }
               } else {
                  System.out.println("Invalid Choice, please enter 'yes' or 'no'");
                  System.out.println("-----------------------");
               }
               System.out.println("The updated cart: ");
               System.out.println("-----------------------");
               if (cart.isEmpty()) {
                  System.out.println("Your cart is empty");
                  System.out.println("-----------------------");
               } else {
                  for (int i = 0; i < cart.size(); i++) {
                     System.out.println(cart.get(i) + "Quantity" + quantities.get(i) + "Total" + prices.get(i));
                     System.out.println("-----------------------------------------------------------------------");
                  }
               }
         System.out.println("invoice: ");
         double totalPrice = 0;
         for (int i = 0; i < cart.size(); i++){
            System.out.println((i+1) + "." + cart.get(i) + " | Quantity: " + quantities.get(i) + "| Total: $" + prices.get(i));
            System.out.println("---------------------------------------------------------------------------------------------");
 totalPrice += prices.get(i);
         }
         System.out.println("Total price: $"+totalPrice);
         System.out.print("Would you like to confirm your order? (yes/no): ");
         System.out.println("-------------------------------------------------");
         String confirm = sc.nextLine();
         if(confirm.equalsIgnoreCase("yes")){
            System.out.println("Thank you for your order! Your items will be delivered to you soon: ");
            System.out.println("-----------------------------------------------------------------------");
         }else{
            System.out.println("Order has been cancelled. Thank you for visiting Amazon Shop!");
            System.out.println("-------------------------------------------------------------------");
         }
         //displayd for cart 
         if (cart.size()==0){
            System.out.println("Your cart is empty.");
            System.out.println("-----------------------");
         }else{
            System.out.println("Your cart:");
            System.out.println("-----------------------");
            for (int i = 0;i<cart.size();i++){
               System.out.println((i+1)+ "." + cart.get(i) + " Quantity: " + quantities.get(i) + "| Total: $" + prices.get(i));
               System.out.println("-------------------------------------------------------------------------------------------");
            }
         }
         ArrayList<String> customerOrder = new ArrayList<>();
         ArrayList<String> orderStatus = new ArrayList<>();
        
         for (int i = 0; i < cart.size(); i++) {
            customerOrder.add(cart.get(i) + "Quantity: " + quantities.get(i) + "Total: $" + prices.get(i));
            orderStatus.add("Pending");
            System.out.println("-----------------------------------------------------------------------------");
         }
         String adminUsername = "admin";
         String adminPassword = "";

         while (true) {
            System.out.println("Are you a customer or an admin? (Enter 'customer' or 'admin'):");
            String userType = sc.nextLine();
            if (userType.equalsIgnoreCase("admin")){
               System.out.println("Admin login: ");
               if (adminPassword.isEmpty()) {
                  System.out.println("You need to set password");
                  System.out.println("Enter new password");
                  adminPassword = sc.nextLine();
                  System.out.println("Admin password has been set");
               }
               System.out.println("Enter Username: ");
               String username = sc.nextLine();
               System.out.println("Enter password: ");
               String password = sc.nextLine();
               if (username.equals(adminUsername) && password.equals(adminPassword)) {
                  System.out.println("login successful!");
                  while (true) {
                     System.out.println("\nAdmin menu: ");
                     System.out.println("1. view customer orders");
                     System.out.println("2. Mark an order as shipped");
                     System.out.println("3. Logout");
                     System.out.println("Enter where to go");
                     int adminChoice = Integer.parseInt(sc.nextLine());
                     if (adminChoice == 1){
                        System.out.println("Customer orders");
                        if (customerOrder.isEmpty()) {
                           System.out.println("No orders found");
                        } else {
                           for (int i = 0; i < customerOrder.size(); i++) {
                           System.out.println((i + 1 ) + "." + customerOrder.get(i) + " Status: " + orderStatus.get(i));
                           } 
                        }
                     } else if (adminChoice ==2) {
                        System.out.println("Enter the order # to mark as shipped");
                        int orderNumber = Integer.parseInt(sc.nextLine()) - 1;

                        if (orderNumber >= 0 && orderNumber < orderStatus.size()) {
                           orderStatus.set(orderNumber, "Shipped");
                           System.out.println("Order marked as shipped");
                        } else {
                           System.out.println("invalid order number");
                        }
                     } else if (adminChoice == 3) {
                        System.out.println("logged out");
                        break;
                     } else { 
                        System.out.println("Invalid choice");
                     }
                  }
               } else {
                  System.out.println("invalid admin credentials.");
               }
            } else if (userType.equalsIgnoreCase("customer")) {
               break;
            } else {
               System.out.println("Invalid choice, please enter 'customer' or 'admin'");
            }
            }
            System.out.println("Thank you for shopping with us!");
            sc.close();
            }
            }
                     
                     
                        
                     
                     
      }
                               
                        
                     
                  
               
            
      
