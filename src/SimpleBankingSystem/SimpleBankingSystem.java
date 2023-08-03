package SimpleBankingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleBankingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingAccount bankAccount = new BankingAccount();

        String bankAccountName, bankAccountId;

        System.out.print("Enter the Account Name: ");
        bankAccountName = sc.nextLine();
        System.out.print("Enter the Account number: ");
        bankAccountId = sc.next();

        bankAccountId = checkIdIsValidOrNot(bankAccountId);

        bankAccount.setName(bankAccountName);
        bankAccount.setId(bankAccountId);

        System.out.println();
        System.out.println("**********************************************");
        System.out.println("         WELCOME " + bankAccount.getName().toUpperCase());
        System.out.println("         Your Account Id is: " + bankAccount.getId());
        System.out.println("**********************************************");

        System.out.println();
        System.out.println("Please Select the below option: ");
        System.out.println("A. Account Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Get All Previous Transaction");
        System.out.println("E. Exit \n");
        System.out.print("Option will be A,B,C,D and E \nNow Enter the your option: ");

        String selectedOption = sc.next().toUpperCase();

        System.out.println();

        List<String> previousTransactionDetails = new ArrayList<>();

        while (!"E".equals(selectedOption)){
            switch (selectedOption) {
                case "A" -> {
                    System.out.println("**********************************************");
                    System.out.println("         Total Balance: " + bankAccount.getBalance());
                    System.out.println("**********************************************");
                }
                case "B" -> {
                    System.out.print("Enter the amount do you want to deposit: ");
                    double amount = sc.nextDouble();
                    bankAccount.addBalance(amount);

                    String preTransDetail = "Deposit: " + amount;
                    previousTransactionDetails.add(preTransDetail);
                }
                case "C" -> {
                    System.out.print("Enter the amount do you want to withdraw: ");
                    double amount = sc.nextDouble();
                    amount = checkAmountIsEnoughOrNotInAccount(amount, bankAccount.getBalance());

                    bankAccount.subtractBalance(amount);

                    String preTransDetail = "Withdrawn: " + amount;
                    previousTransactionDetails.add(preTransDetail);
                }
                case "D" -> {
                    System.out.println("Your Previous Transaction Details are below: ");
                    previousTransactionDetails.forEach(System.out::println);
                }
                default -> System.out.println("Please Enter the right option.");
            }

            System.out.println();
            System.out.print("Enter the option: ");
            selectedOption = sc.next().toUpperCase();

            System.out.println();

        }

    }

    private static double checkAmountIsEnoughOrNotInAccount(double amount, double balance) {
        Scanner sc = new Scanner(System.in);
        boolean valid;

        do {
            if ( amount > balance){
                System.out.println("That must money is not present in your account.");
                System.out.print("Enter the withdrawn amount again: ");
                amount = sc.nextDouble();
                valid = false;
            }
            else{
                valid = true;
            }

        }while(!valid);

        return amount;
    }

    private static String checkIdIsValidOrNot(String bankAccountId) {
        Scanner sc = new Scanner(System.in);
        boolean valid;
        do{
            if (bankAccountId.length() == 10){
                valid = true;
            }
            else{
                System.out.print("Account Id must be 10 digits. \nEnter the right account number: ");
                bankAccountId = sc.next();
                valid = false;
            }
        }while(!valid);
        return bankAccountId;
    }
}