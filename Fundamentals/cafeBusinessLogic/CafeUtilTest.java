import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CafeUtilTest {
     public static void main(String[] args){
        CafeUtil appTest = new CafeUtil();
        int addNumber = appTest.getStreakGoal();
        System.out.println(String.format("You need %s after 10 weeks to get reward " , addNumber));
        double[] itemPrices = {4.5,3.5,2,4,5};
         double totalPrice  = appTest.getOrderTotal(itemPrices);
        System.out.println(String.format("The total : %s \n",  totalPrice));
    // appTest.displayMenu( );



        
        List<String> coffeeMenu = Arrays.asList("drip coffee", "cappuccino","latte","mocha");
        ArrayList<String> menu = new ArrayList<String>();
        menu.addAll(coffeeMenu);
        System.out.println(coffeeMenu);
        appTest.displayMenu(menu);

        
       
   

    }
    
}
