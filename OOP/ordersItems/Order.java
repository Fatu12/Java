
import java.util.ArrayList;
public class Order {
    //? member variables , that means it belong to class
    private  String name; // default value if null
    // private  double total;
    private  boolean ready; //default value false
    private  ArrayList<Item> items = new ArrayList<Item>(); // default to null

    // constructor that take no argument but set the name to Guest and intializes the items
    // array to an empty 
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }
    //? overloaded Constructor 
    // add ab overloaded constructor order that takes String name ans an argument, so
    // you can create an instance with a name 
    
    public Order(String name ){
        this.name = name ;

    }

    // ? Accessors and Mutators(Getter and Setters)
    // Create getters and setters for all the member variables, using good naming convention
    // for boolean accessors
    // ! getter
    public String getName(String name){
        this.name = name;
        return this.name;
    }
    public ArrayList<Item> getArrayList(ArrayList<Item> items){
        return this.items;

    }
    public void getReady(boolean ready){
        this.ready = ready;
    }
    // Setter 
    public void setName(String name){
        this.name = name;
    }
    public void setReady(boolean ready){
        this.ready = ready;
    }
    public  void setArrayList(ArrayList<Item> items){
        this.items = items;
    }
    // ? Order Class Methods
    // create a method called addItem that takes an Item object as an argument and adds the
    // item to the order's items array. No need to return anything 
    
    public void addItem(Item item){
       this.items.add(item);
    }
//? getStatusMessage
// Create a method called getStatusMessage that return a String message.If the order is ready
// return "You order is ready", if not, return "Thank you for waiting" your order will be ready soon.

public String getStatusMessage(){
    if(this.ready){
        return "Your order is ready";

    }
    return "Thank you for waiting.Your order will be ready soon. ";


}

    // creating getOrderTotal that sums together each of the item's prices , and returns
    // the total amount 

    public double getOrderTotal(){
        // local variable 
        double total = 0;
        for(Item item: items){
          total += item.getPrice();
          
        }
        return total;


    }
    public void display(){
        System.out.printf("Customer Name:" , this.name);
        for(Item item: items){
            System.out.printf(item.getName(), "-$", item.getPrice());
            System.out.println(getOrderTotal());}
        }
    }
