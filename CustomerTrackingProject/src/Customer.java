import java.util.ArrayList;
/**
 * Represent a customer with name, ID, geography
 * @author kew
 *
 */
public class Customer {
	/**
	 * variables
	 */
	
	//1. Static variables: across all instances of Customer
	
	static final String COMPANY = "CVS"; //every customer have same company
		//Static: it's same for all customer
		//Final: cannot change it in my code
	
	//2. Array List to store all customers
	static ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();
	
	//3. Instance of counter class to generate and keep track of customer id
	static Counter COUNTER; 
	
	//4. Instance variables:
	String name;
	String geography;
	int Id;
	
	/**
	 * Constructor:
	 */
	
	//Customer: name + geography
	public Customer(String name, String geography) {
		this.name = name;
		this.geography = geography;
		
		 //Recall that a static variable is accessed directly by class name (dont need instance of object
		this.Id = Customer.COUNTER.getCount(); //get unique id
		
		//increment the count
		Customer.COUNTER.increment();
		
		//add this customer to list of all customers
		Customer.CUSTOMERS.add(this);
	}
	
	//Methods: printing all the customers
	public static void printAllCustomers() {
		System.out.println("All customers: ");
		for (Customer c: Customer.CUSTOMERS) {
			System.out.println("Customer "+ c);
		}
	}
	
	
	//Equal method to compare customer: (we need for every program.
	public boolean equals(Object obj) { //compare: name + geographies
		
		//Cast object to customer:
		Customer otherCustomer = (Customer) obj;
		
		if ((this.name.equals(otherCustomer.name) && this.geography.equals(otherCustomer.geography))){
			return true;
		}
		return false;
	}
	//ToString method: how to cast an instance of customer class to a string

	public String toString() {
		//return name, id, company, geography
		return this.Id + ": " + this.name + ", Company: " + Customer.COMPANY + ", Location: "+ this.geography;
		
	}
	
	//Method: locating a particular customer in the list of all customers
	public static int findCustomer(Customer customer) {
		
		int index = -1;//set default index
		
			//iterate over customer list and locate given customer
			for (int i=0; i< Customer.CUSTOMERS.size(); i++) {
				if(Customer.CUSTOMERS.get(i).equals(customer)) {
					index = i;
					break;
				}
			}
		
		return index; //return index of given customer in the list, otherwise -1
	}
	
	//Method: remove customer in the list
	public static void removeCus(Customer customer) {
		int removeIndex = Customer.findCustomer(customer);
		
		if (removeIndex >= 0) {
			Customer.CUSTOMERS.remove(removeIndex); //index valid: remove customer
		}
	}
	
	
	public static void main(String[] args) {
		// 1. Create instance of counter class: initialize the customer
		Customer.COUNTER = new Counter(1);
		
		//2. Create customer:
		Customer c1 = new Customer("Ryosuke", "Tokyo, JP");
		Customer c2 = new Customer("Hieu", "Melbourne, AU");
		Customer c3 = new Customer("Kaiwen", "Guazhang, China");
		Customer c4 = new Customer("Boranut", "Pnongpen, Cambodia");
		
		//3. Print list of all customers:
		Customer.printAllCustomers();
		
		System.out.println("----------------------------------------------------------------");
		
		//4. remove customer
		Customer.removeCus(c4);
		Customer.printAllCustomers();
		
		System.out.println("----------------------------------------------------------------");
		
		Customer.removeCus(c3);
		Customer.printAllCustomers();
		
	}

}
