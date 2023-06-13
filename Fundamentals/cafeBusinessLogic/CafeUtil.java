import java.util.ArrayList;
import java.util.Arrays;
public class CafeUtil {
    // implement a reward system for customers who buy more drinks than 
    // they did the week before.
    // ? this method is going to sums together every consecutive integer from 1 to 10 and 
    // ? returns the sum
    public int getStreakGoal(){
        int sum = 0;
       for (int i = 0; i< 11; i++){
          sum += i;
        }
       return    sum;
    }
    // double getOderTotal giving list of prices from an order
    // ? this method is going to sum all the prices in the array 
    // ? and return the total
    // this is fixed array type 
    public Double getOrderTotal(double[] prices){
      double sumTotal = 0;
      for(double price: prices){
        sumTotal += price;
    }
      return sumTotal;
    }
    // public  void displayMenu(ArrayList<String> menuItems)
    //? this method is going to print out each index and menu item from ArrayList
   public void  displayMenu(ArrayList<String> menuItems){
    for(int i = 0; i < menuItems.size(); i++){

        System.out.println(String.format( "%s %s",i, menuItems.get(i)));
    // given an ArrayList of menu items(strings), print out each index and menu item

        // other operations using name
    }
    // public void displayMenu(){
    //   ArrayList<String> menuItems = new ArrayList<String>();
    //   menuItems.add("drip coffee");
    //   menuItems.add("cappuccino");
    //   menuItems.add("latte");
    //   System.out.println(menuItems);
    //   for (int i = 0; i < menuItems.size(); i++){
    //     System.out.println(i);
    //     System.out.println(menuItems);
        
    //   }



      }
      public void addCustomer(ArrayList<String>customers){
        boolean finished =false;
        while(!finished){
        System.out.println(" \n Please enter your name or press Q to quit: ");
        String userName = System.console().readLine();
        System.out.printf( "Hello %s",userName);
        System.out.printf(" \n There  are %s  people in front of you ", customers.size());
        // Checking if the user prase Q to quit 
        if(userName.equals( "Q")){
          finished = true;
          return;
        }
        // this is going to add the user in the array and increment them up as we add your
        customers.add(userName);

          
        }
      }
          
        }
   

      


    


   


        
    

