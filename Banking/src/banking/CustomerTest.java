package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	
	//Instance variable:
	Customer customer;
	
	@BeforeEach
	void setUp() throws Exception {
		//initialize customer to run before every test method
		this.customer = new Customer("Brandon");
	}

	@Test
	void testSetAddressString() {
		//confirm the initial value of address is null:
		assertNull(this.customer.setAddress());
		/**
		 * because:
		 * in customer class: address without initialize value -> so here Null value
		 */
		
		//Address: sets address for customer
		this.customer.setAddress("Brooklyn, NY");
		
		//check that address was set correctly?
		assertEquals("Brooklyn, NY", this.customer.setAddress());
	}
	

}
