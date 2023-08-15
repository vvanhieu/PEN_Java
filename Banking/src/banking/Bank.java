/*
 *(1) Bank:
		• Provide the package name "Banking"
		• Make sure public static void main(String[] args) IS checked
 */

package banking;

import java.util.Scanner;

/**
 * Represent a bank for managing customers and their bank accounts.
 * @author kew
 *
 */

public class Bank { //this is bank class

	public static void main(String[] args) { //Main method: Java main method is the entry point of any Java Program
		
		// create an instance of the bank class:
		Bank bank = new Bank();
		//run method in the bank class:
		bank.run();
		//NOTE: you cannot directly call the run() method -> SO, need call by an instance of this class

	}
	
	//run the program by initializing and managing bank account and customers
	public void run() {
		
		//print the run method from bank class
		System.out.println("Hello! What is your name? ");
		
		//User input:
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.println("Hello "+ name + ", What you want to help for your services!");
		
		//Create customer with given name
		Customer customer = new Customer(name); //parameters "name" should be same as the constructors (public Customer(String name))
		
		//Get address:
		System.out.println("What is your address? ");
		String address = scanner.next();
		
		//set the customer address
		customer.setAddress(address);
		
		//Create a 	checking and saving account for customer 
		BankAccount checkingAccount = new BankAccount("Checking", customer); //public class BankAccount {} and public Customer(String name) {
		BankAccount savingAccount = new BankAccount("Saving", customer);
		
		//get customer information for checking and saving account:
		System.out.println();
		System.out.println("Customer information: ");
		System.out.println(checkingAccount.getCustomerInfo());
		
		//get and print account information for checking/saving account:
		System.out.println();
		System.out.println("Checking account: ");
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println("Saving account: ");
		System.out.println(savingAccount.getAccountInfo());
		
		/**
		 *  Deposits:
		 */
		
		//Checking account: ask user to enter amount:
		System.out.println();
		System.out.println("Amount to deposit into your checking account?");
		double amount = scanner.nextDouble(); //get double
		checkingAccount.deposit(amount);
		
		//Saving account:
		System.out.println();
		System.out.println("Amount to deposit into your savings account?");
		amount = scanner.nextDouble(); //get double
		savingAccount.deposit(amount);
		
		//balance:
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingAccount.getAccountInfo());
		
		/**
		 *  Withdraw:
		 */
		
		//Checking account: ask user to enter amount want to withdraw
		System.out.println();
		System.out.println("Amount to withdraw from your checking account?");
		amount = scanner.nextDouble();
		try { //test for error
			checkingAccount.withdraw(amount);
		} catch (Exception e) { //catch will be executed if an error occurs within try block
			// TODO Auto-generated catch block
			//e.printStackTrace(); //edit by "getMessage() method -> return the customized message of exception as a string value
		System.out.println(e.getMessage());
		}
		//NOTE, fit error: Add try catch (test for errors while it is being executed
		
		//saving account:
		System.out.println();
		System.out.println("Amount to withdraw from your savings account?");
		amount = scanner.nextDouble();
		try {
			savingAccount.withdraw(amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage()); //customer message from Exception
		}
		
		//balance:
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingAccount.getAccountInfo());
		
		scanner.close(); //done everything just close it
	}
}
