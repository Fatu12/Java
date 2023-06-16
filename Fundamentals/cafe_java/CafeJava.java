package Fundamentals.cafe_java;

import javax.sound.sampled.SourceDataLine;

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
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example: ternary 
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        //* YOUR CUSTOMER INTERACTION PRINT STATEMENT WILL GO HERE  */
        // System.out.println(isReadyOrder4? String.format(customer4 + readyMessage )+("\n your total is" +  cappuccino):pendingMessage + customer4);
        // System.out.println(isReadyOrder1? String.format(customer1 + readyMessage )+("\n your total is" +  dripCoffee):pendingMessage + customer1);
        // System.out.println(isReadyOrder2? String.format(customer2 + readyMessage )+("\n your total is" +  latte*2):pendingMessage + customer2);
        // System.out.println(isReadyOrder3? String.format(customer3 + readyMessage )+("\n your total is" +  (latte - dripCoffee)):pendingMessage + customer2);

        // switch
        String[] customerName = {"customer1", "customer2", "customer3", "customer4"};
        System.out.println("Please enter your name from the list Cindery,Sam, Jimmy, Noah");
        String newCustomerName = System.console().readLine();

        switch(newCustomerName){
            case "Sam":
             System.out.println(isReadyOrder2? String.format(customer2 + readyMessage )+("\n your total is" +  latte*2):pendingMessage + customer2);
             break;
             case "Cindery":
                System.out.println(isReadyOrder1? String.format(customerName[0] + readyMessage )+("\n your total is" +  dripCoffee):pendingMessage + customer1);
                break;
            case  "Jimmy":
                System.out.println(isReadyOrder3? String.format(customer3 + readyMessage )+("\n your total is" +  (latte - dripCoffee)):pendingMessage + customer2);
                break;
            case "Noah":
                System.out.println(isReadyOrder4? String.format(customer4 + readyMessage )+("\n your total is" +  cappuccino):pendingMessage + customer4);
                break;
                default:
                System.out.println(newCustomerName + pendingMessage);
                break;










        }

        // 

    //     System.out.println(customer1  +  pendingMessage);
    // 	// ** Your customer interaction print statements will go here ** //
    //     // ? if this is true then , loop to this 
    //      if(isReadyOrder4){
    //     System.out.println(customer4 + readyMessage);
    //     System.out.println(displayTotalMessage + cappuccino);
    // }
    // else{
    //     System.out.println(pendingMessage);
    // }
    // System.out.println( displayTotalMessage +  latte + latte);
    // if(isReadyOrder2){
    //     System.out.println(customer2 + readyMessage);
    // }
    // else{
    //     System.out.println(customer2 + pendingMessage);

    // }
    // // display the difference for the coffee price 
    // System.out.println( customer3 + displayTotalMessage + (latte - dripCoffee)) ;

}}
