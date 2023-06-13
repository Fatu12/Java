import java.util.ArrayList;
public class CafeUtil {
    // implement a reward system for customers who buy more drinks than 
    // they did the week before.
    public Integer getStreakGoal(){
        int sum = 0;
       for (int i = 0; i< 11; i++){
          sum += i;
        }
       return    sum;
    }
    // double getOderTotal giving list of prices from an order
    public Double getOrderTotal(double[] listItem ){
      double sum = 0;
      for(double prices: listItem ){
        sum += prices;
    }
      return sum;
    }
    // void displayMenu(ArrayList<String> menuItems)
   public void  displayMenu(ArrayList <String> menuItems){

    for(int i = 0; i < menuItems.size(); i++){

        System.out.println( String.format( "this is the list of each coffee %s %s",i , menuItems.get(i)));
    // given an ArrayList of menu items(strings), print out each index and menu item

        // other operations using name
    }



    


   }}


        
    

