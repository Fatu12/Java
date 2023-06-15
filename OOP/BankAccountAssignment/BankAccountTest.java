
public class BankAccountTest {
    public static void main(String[]args){
        BankAccount user1 = new BankAccount();
        BankAccount user2 = new BankAccount();
        BankAccount user3 = new BankAccount();
        user1.deposit("saving", 60.00);
        user1.deposit("saving", 70.00);
        // user1.withdraw("saving", 10.0);

        // each your account is different 
            user2.deposit("saving", 900.00);
            user2.withdraw("saving", 100);

            // user2.withdraw("checking", 200);
            // user2.deposit("checking", 1.00);
            user2.totalMoneyAccounts();
             user2.getAccountNumber(); 
             user3.getAccountNumber(); 
        
            }
        }
            
