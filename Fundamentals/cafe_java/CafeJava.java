package Fundamentals.cafe_java;
public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 5.90;
        double latte = 7.8;
        double cappuccino = 7.48;
        // Customer name variables (add yours below)
        String customer1 = "Cindery";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below) this is boolean condition true or false 
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(customer1  +  pendingMessage);
    	// ** Your customer interaction print statements will go here ** //
        // ? if this is true then , loop to this 
         if(isReadyOrder4){
        System.out.println(customer4 + readyMessage);
        System.out.println(displayTotalMessage + cappuccino);
    }
    else{
        System.out.println(pendingMessage);
    }
    System.out.println( displayTotalMessage +  latte + latte);
    if(isReadyOrder2){
        System.out.println(customer2 + readyMessage);
    }
    else{
        System.out.println(customer2 + pendingMessage);

    }
    // display the difference for the coffee price 
    System.out.println( customer3 + displayTotalMessage + (latte - dripCoffee)) ;

}}
