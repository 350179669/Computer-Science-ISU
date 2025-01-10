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
         
            sc.close();
        

    }
}