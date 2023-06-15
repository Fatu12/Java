import java.util.Random;

public class BankAccount {
    // member variable(attributes)
    private double checkingBalance = 0.0;
    private double savingBalance = 0.0;
    // private String  accountNumber1 ;
    // create a class member(static ) that has the number if account created thus far
    // !static method we can access without instating the classes 
    public static int numberAccountHasCreated = 0;
    // create a class member (static) that tracks the total amount of money stored in every account created
    public static double totalAmountMoney = 0.0;
    // In the constructor, be sure to increment the account count 
    public BankAccount(){
        this.checkingBalance =0.0;
        this.savingBalance = 0.0 ;
        // because this is static method
        BankAccount.numberAccountHasCreated ++;
    }
    // GETTER
    public double getCheckingBalance(){
        System.out.println(this.checkingBalance);
        return this.checkingBalance ;
    }
    public double getSavingBalance(){
        return this.savingBalance;
    }
    // SETTER   
    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;    
    }
    public void setSavingBalance(double savingBalance){
        this.savingBalance = savingBalance;
    }
    // create a method that will allow a user to deposit money into either the checking
    // or saving, be sure to add to total amount stored 
    // ? type is going for which account you want to deposited to it 
    // depositAmount is going to hold the amount that the user going to deposit 

    public  void deposit(String type, double depositAmount){
        if(type == "checking" || type == "Checking"){
            this.checkingBalance += depositAmount;
            System.out.println(this.checkingBalance);
        }
        if(type == "saving" || type == "Saving"){
            this.savingBalance += depositAmount;
            System.out.println(savingBalance);
        }
        else{
        System.out.println("Please choose the right account type ");
        
        }
    }

    // Create a method to withdraw money from one balance. Do not allow them to withdraw 
    // money if there are insufficient funds
    public void withdraw( String type, double withdrawalAmount){
        if(type =="checking" || type == "Checking"){
            if(checkingBalance < withdrawalAmount){
                System.out.printf("\n Insufficient Funds!", checkingBalance);
            }
            else{
                  checkingBalance -= withdrawalAmount;
                System.out.printf( " \n your withdraw from checking account %s", checkingBalance);
            }
        }
            if(type == "saving" || type == "Saving"){
                if(savingBalance < withdrawalAmount){
                    System.out.printf("Insufficient Funds!", savingBalance);
                }
                else{
                    savingBalance -= withdrawalAmount;
                    System.out.printf("your balance after you withdraw %s",savingBalance);
                }
            } 
        }
        // create a method to see the total money from the checking and saving
        public double totalMoneyAccounts(){
            // double totalBalance = checkingBalance + savingBalance;
            double totalBalance = this.checkingBalance + this.savingBalance;
            System.out.printf(" \n balance in your account %s",totalBalance);
            return totalBalance;
        }
        // create a private method that returns a random ten digit account number 
        private static int  accountNumber(){
               Random rand = new Random();
               int accountNumber = rand. nextInt((int) Math. pow(10, 10));
               String number = String. format("%010d", accountNumber);
               System.out.printf( " \n this is random account number %s ", number);
               return accountNumber; 
        }
        // GETTER
        public int getAccountNumber(){
           return BankAccount.accountNumber();
        }
        
    
    

        
		
    }
