public class Item {
    // Private member variable
   private String name;
   private double price;
// Constructor , take name and price as an argument parameter 
public Item(String name, double price ){
    // setting name and price attribute to the value from the name and price  parameter 
    // that is object on instantiation 
    this.name = name;
    this.price = price;
}
// getter get name  and price 
public String getName(){
    return this.name;
}
  public double getPrice() {
    return this.price;
  } 
//  Setter set name and price 

public void setName(String name){
    this.name = name;

}
public void setPrice(int price){
    this.price = price;
}
  
}
