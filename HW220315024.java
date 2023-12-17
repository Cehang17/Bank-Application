import java.util.Scanner;

import javax.swing.InputMap;
import javax.swing.text.AbstractDocument.BranchElement;

public class HW220315024 {
    static final String USERNAME = "cehang";
    static final String PASSWORD = "qwerty";
    static double accountBalance = 0;
    public static boolean authenticateUser(String s1,String s2){
        if (USERNAME.equals(s1) && PASSWORD.equals(s2))
            return true;
        else{
            return false;
        }
        }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int attempts = 3;
        while(attempts > 0){  
            System.out.print("username: ");
            String username = input.nextLine();
            System.out.print("password: ");
            String password = input.nextLine();
            if(authenticateUser(username,password)){
                printMenu();
                break;
            } 
            else {
                attempts--;
                System.out.println("Invalid credentials. Attempts left: " + attempts);
        }
        if (attempts == 0) {
            System.out.println("Authentication failed. Exiting...");
            break;
            }
        }
        input.close();
    }
    public static void printMenu() {
        boolean enter = true; 
        while (enter){
            Scanner input = new Scanner(System.in);
            System.out.println("\n--- Bank Application ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Exit");
            System.out.println("Your choice: ");
            int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        depositMoney();
                        break;
                    case 2:
                        withdrawMoney();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        enter = false;
                        input.close();
                        break;
                    default:
                        System.out.println("You dialed the wrong number. Please select a valid transaction ");
                        break;
                    }
        }
    }
    public static void depositMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double deposit = input.nextDouble();

        if (deposit > 0){
            accountBalance = accountBalance + deposit;
            System.out.println("Deposit Succesful. New balance: " + accountBalance);
        }
        else{
            System.out.println("Insufficient amount to deposit. ");
        }
    }

    public static void withdrawMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double withdraw = input.nextDouble();
        if (accountBalance >= withdraw && withdraw > 0){
            accountBalance = accountBalance - withdraw;
            System.out.println("Withdraw Succesful. New balance: " + accountBalance);
        }

        else {
            System.out.println("Insufficient Balance. The withdrawal amount can not exceed the account balance.");
        }
    }
    public static void checkBalance(){
        System.out.println("Current Balance: " + accountBalance);
    }
}
