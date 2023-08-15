/*
 * 	(2) BankAccount:
		• Provide package name "banking" 
		* Make sure public static void main(String[] args) is not checked
 */

package banking;

/**
 * Represents a checking/savings bank account for a customer.
 * @author kew
 *
 */
					
public class BankAccount {
			
	//Instance vars:
	
	//1. Type of account: checking or saving
		String accountType;
	//2. Balance for bank account:
		double balance; //create deposit  and withdraw
	//3. Customer for this account
		Customer customer;
		
	//Step 1: Fixed amount (quick): create for testing
		double fastCashAmount;
		
	/**
	 * create a bank account of given type for given customer
	 * @param accountType
	 * @param customer
	 */
	public BankAccount(String accountType, Customer customer) {
		this.accountType = accountType; //set to given accountType
		this.customer = customer;       //set to given customer
		
		//Step 2: Update constructor for testing bankaccount class
		this.fastCashAmount = 60;  //initial default value
	}

	
	//Method: deposit and withdraw
	/**
	 * Deposit the given amount
	 * Withdraws the given amount from balance
	 * @param amount to add to balance
	 * @throws Exception if given amount is larger than available balance
	 */
	
	public void deposit(double amount) { //deposit a given amount of money into the account
		//step 5: update for deposit: if greater than 0
		if (amount > 0) {
			this.balance += amount; //balance = balance + amount
		}
	}
	
	public void withdraw(double amount) throws Exception { //need to add throws Exception
		//when we withdraw it have problem if not enought money
		if (amount > this.balance) {
			throw new Exception("Amount is greater than available balance"); //"Exception" is built-in class which indicates that a problem occurred 
		}
		this.balance -= amount;
	}
	//NOTE: use Exception -> then fit errors by try Catch for this variable in the next class
	
	//Step 3: additional method - withdraw fastCashAmount: for quick withdraws
	//Exception if given fast cash amount is greater than available balance
	public void fastWithdraw() throws Exception {
		this.withdraw(this.fastCashAmount);
	}
	
	//Step4: method to rest the fast cash amount:
	public void setFastCashAmount(double amount) {
		if (amount > 0) {
		this.fastCashAmount = amount;
		 }
	}
	
	
	/**
	 * Return account information: accounttype and balance
	 * Return the customer information: name and address
	 * @return string with all information
	 * @return string with customer information
	 */
	
	public String getAccountInfo() {
		return this.accountType + ": " + this.balance;
	}
	public String getCustomerInfo() {
		return this.customer.getName() + " from " + this.customer.setAddress();
	}
	//NOTE: when we create constructor we can create a name for it: deposit, withdraw or getaccountinfor,...
	//NOTE: but Java doesn't know what a customer is => NEED: create a "class of customer"
	
	
}
