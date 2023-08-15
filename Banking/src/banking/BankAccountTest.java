package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
	//Instance variable of BankAccount class
	Customer customer;
	BankAccount checkingAccount;
	BankAccount SavingsAccount;

	@BeforeEach
	void setUp() throws Exception {
		//initialize value:
		this.customer = new Customer("Brandon");
		this.checkingAccount = new BankAccount("Checking", this.customer);
		this.SavingsAccount = new BankAccount("Savings", this.customer);
	}

	@Test
	void testDeposit() {
		//make deposit
		this.checkingAccount.deposit(100);
		//test the current balance is 100
		assertEquals(100, this.checkingAccount.balance);
		
		
		//make deposit of negative amount:
		this.checkingAccount.deposit(-100);
		assertEquals(100, this.checkingAccount.balance);
		//balance should be same
		
		
		//make deposit of 0
		this.checkingAccount.deposit(0);
		assertEquals(100, this.checkingAccount.balance);
	}

	@Test
	void testWithdraw() {
		
		//deposit initial 100 into savings account
		this.SavingsAccount.deposit(100);
		assertEquals(100, this.SavingsAccount.balance);
		
		//Try to make withdraw of 80
		try { //because amount > balance: use Try Catch
			this.SavingsAccount.withdraw(80);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(20, this.SavingsAccount.balance); //balance: 20
		
		
		//try to withdraw amount greater than available balance (expect an exception)
		assertThrows(Exception.class, () -> {
			this.SavingsAccount.withdraw(21); //greater than balance
		});
		
		assertEquals(20, this.SavingsAccount.balance);
		
		//Try to withdrawal does not throw exception:
		assertDoesNotThrow(() -> {
			this.SavingsAccount.withdraw(19);
		});
		
		assertEquals(1, this.SavingsAccount.balance);
	}
	
	//NOTE: we use throw and notthrow because in BankAccount class, we use "throw Exception"

	@Test
	void testFastWithdraw() {
		//initial deposit:
		this.checkingAccount.deposit(100);
		
		//Try to make fasdt withdraw: this.fastCashAmount = 60; 
		try {
			this.checkingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //fit: Try Catch
		
		assertEquals(40, this.checkingAccount.balance); //balance should be 40
		
		//reset the fast cash amount:
		this.checkingAccount.setFastCashAmount(20);
		
		//assert that an exception is not thrown when i make fast cash withdrawal
		assertDoesNotThrow(() -> {
			this.checkingAccount.fastWithdraw();
		});
		
		assertEquals(20, this.checkingAccount.balance);
		
		//set fast cash amount to negative value:
		this.checkingAccount.setFastCashAmount(-50);
		
		//shoudl still withdraw 20
		try {
			this.checkingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //fit error: by use "Try catch" 
		
		//balance should be 0 after fast withdrawal:
		assertEquals(0, this.checkingAccount.balance); //balance = 0
		
		
		//Because my balance now is 0, so it should THROW AN EXCEPTION
		//Try to make fast withdrawal
		assertThrows(Exception.class, () -> {
			this.checkingAccount.fastWithdraw();
		});
	}

}
