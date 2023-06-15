
public class OOP {
    //  attributes 

    // public String name;
    // public char size;
    // String[] topping = {"cheese"};
    // public int slices;
    // public double price;

//  public void numbers1(){

    public String greet(String name){
        return createGreeting(name);
    }
    public String greet(){
        return createGreeting("World");
    }
    public String greet(String firstName, String lastName){
        return createGreeting(firstName+ "" + lastName);
            
        }
        // public is a modifier , private means that we can't access 
        private  String createGreeting(String toBeGreeted){
            return "Greeting"+ toBeGreeted + "Welcome to coding dojo";
        }

    }
    // int[] numbers = {1,2,3,4};
    // for(int value: numbers){
    //     value +=3;
        
     
    // }
    // System.out.println(numbers);

