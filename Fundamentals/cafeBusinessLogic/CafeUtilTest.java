import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CafeUtilTest {
     public static void main(String[] args){
        CafeUtil appTest = new CafeUtil();
        int addNumber = appTest.getStreakGoal();
        System.out.println("\n ======= Streak Goal Task =========");
        System.out.println(String.format("Purchases needed by week 10: %s \n\n " , addNumber));
        double[] itemPrices = {4.5,3.5,2.0,4.0,5.0};
         double totalPrice  = appTest.getOrderTotal(itemPrices);
         System.out.println("===== Order Total Test =====");
        System.out.println(String.format("The total : %s \n",  totalPrice));
    // appTest.displayMenu( );

            // ArrayList<String> coffeeMenu = new ArrayList<String>(Arrays.asList("Drip coffee", "cappuccino", "latte"));
            // ArrayList<String> menu = new ArrayList<String>();
            // menu.addAll(coffeeMenu);


        
        ArrayList<String> coffeeMenu =  new ArrayList<String>(Arrays.asList("drip coffee", "cappuccino","latte","mocha"));
        ArrayList<String> menu = new ArrayList<String>();
        menu.addAll(coffeeMenu);
        appTest.displayMenu(menu);
       
        ArrayList<String> customers = new ArrayList<String>();
        for(int i = 0; i < 1; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }
        

        
       
   

    }
    
}
