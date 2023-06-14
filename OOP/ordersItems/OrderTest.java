import javax.swing.SortingFocusTraversalPolicy;

public class OrderTest {
    public static void main(String[]args){
        // creating new instance of an object 
        Item item1 = new Item();
      item1.name = "mocha";
        item1.price = 3.4;

        Item item2= new Item();
        item2.name = "latte";
       item2.price = 5.0;

        Item item3 = new Item();
        item3.name = "cappuccino";
       item3.price = 7.0;

        Item item4 = new Item();
        item4.name = "drip coffee";
        item4.price = 4.6;

        // order variables

        Order order1 = new Order();
        order1.name = "Cindhuri";

        order1.ready = true;

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.ready = true;
        
        
        order2.items.add(item1);
        order2.total += item1.price;

        
        Order order3 = new Order();
        order3.name = "Noah";

      

        Order order4 = new Order();
        order4.name = "Sam";
        //  Sam ordered more drinks -2 latte. Update their order as well 
        order4.items.add(item2);
        order4.total = item2.price *2;
        
        // adding the item to the list 
        order2.items.add(item1);
        order2.total += item1.price;
        System.out.println(order2.total);
        
        // oder3 ordered a cappuccino and add the cappuccino to their order list and to their tab.
        
        order3.items.add(item3);
        order3.name = item3.name;
        order3.total += item3.price;
        System.out.printf( "your odored %s %s \n",order3.name, order3.total);
        
        // order4 added a latte . Update accordingly
        
        order4.items.add(item2);
        order4.name = item2.name;
        
        // testing  orders 
        System.out.printf("Name: %s \n", order1.name);
        System.out.printf("name %s \n ", item1.price);
        System.out.println(order2.total);
        
        
        
        
        System.out.printf("this order 4",order4);
    }
    
}
