import java.util.ArrayList;

import javax.print.attribute.standard.Media;
public class CafeUtil {
    // implement a reward system for customers who buy more drinks than 
    // they did the week before.
    // ? this method is going to sums together every consecutive integer from 1 to 10 and 
    // ? returns the sum
    public Integer getStreakGoal(){
        int sum = 0;
       for (int i = 0; i< 11; i++){
          sum += i;
        }
       return    sum;
    }
    // double getOderTotal giving list of prices from an order
    // ? this method is going to sum all the prices in the array 
    // ? and return the total
    public Double getOrderTotal(double[] prices){
      double sum = 0;
      for(double price: prices ){
        sum += price;
    }
      return sum;
    }
    // void displayMenu(ArrayList<String> menuItems)
    // ? this method is going to print out each index and menu item from ArrayList
  //  public void  displayMenu(ArrayList <String> menuItems){

  //   for(int i = 0; i < menuItems.size(); i++){

  //       System.out.println( String.format( "this is the list of each coffee %s %s",i , menuItems.get(i)));
  //   // given an ArrayList of menu items(strings), print out each index and menu item

  //       // other operations using name
  //   }
    public void displayMenu(){
      ArrayList<String> menuItems = new ArrayList<String>();
      menuItems.add("drip coffee");
      menuItems.add("cappuccino");
      menuItems.add("latte");
      System.out.println(menuItems);
      for (int i = 0; i < menuItems.size(); i++){
        System.out.println(i);
        System.out.println(menuItems);
        
      }


      }


    }


    


   


        
    

