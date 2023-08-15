/*
 * 	(3) Customer:
		• Provide package name "banking"
		• Make sure public static void main(String[] args) is Not checked
 */

package banking;

/**
 * Represents a customer of a bank
 * @author kew
 *
 */

public class Customer {

	//Intance vars
	
	//1. Name of customer:
		String name;
	//2. Address of customer:
		String address;
		
	//Constructor
	//NOTE: if you dont declare a constructor. Java will automatically create one for you with "NO PARAMETERS".
	
	/**
	 * 1. Creates a customer with given name
	 * 2. Sets the address of customer to be given address
	 * @param name
	 * @param address
	 */
		
	public Customer(String name) {
		//set the value of the instance vars same to given name in constructor
		this.name = name;
		//"this" is "reference" variable that refers to the current object(or pass as an argument)
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	// Public: accessible outside of class
	// Void: doesn't return anything
	// setAddress: if "setAddress" is called, the value of instance variable "address" will be modified globally
	
	//Method:
	
	/**
	 * 1. getName method to return the name of customer
	 * 2. return address of customer
	 * @return name
	 * @return address
	 */
	public String getName() {
		return this.name; //(String name;)
	}
	//String: return string
	
	public String setAddress() {
		return this.address; 
	}
	
}
