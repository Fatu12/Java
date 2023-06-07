package Fundamentals.alfredBot;

import java.text.SimpleDateFormat;
import java.util.Date;


public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
    
        return "Hello, lovely to see you. How are you?";
    }
    public String guestGreeting(String name) {
        
        // YOUR CODE HERE
        return String.format(" Hello %s,lovely to see you" + name);
        }
    public String guestGreeting(String name, String datePeriod){
        return  String.format("Hello %s %s ,lovely to see you " + name + datePeriod );
    }
    public String guestGreeting(){
        // String date = "yyyy-MM-dd";
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat(date);
       Date date = new Date();  
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       String strDate= formatter.format(date);  
       return strDate;

    }
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return  String.format( "Current date is" + date );
    }
    public String respondBeforeAlexis(String conversation) {
        // indexOf will returns the index number where the target string is first found 
        //  or -1 if the target is not found
    
        if (conversation.indexOf("Alexis") > -1){
            return "Sir  She Certainly isn't sophisticated enough for that ";

        }
        if(conversation.indexOf("Alfred") > -1){
            return "At your service. As you wish, naturally";
        }
        else{
        return "Right and with that I shall retire";
    }

    
	// NINJA BONUS

	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}}


    
