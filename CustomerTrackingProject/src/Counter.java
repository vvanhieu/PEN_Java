/**
 * Represent a counter with methods for manipulating a count.
 * @author kew
 *
 */
public class Counter {

	//Instance vars:
	int count; //internal counts
	
	//Constructor:
	
	public Counter(int initialCount) {
		this.setCount(initialCount); //setCount with given initial count
	}
	
	//Method: to manipulating the count methods:
	public void increment() {
		this.count++; //increments internal count by 1
	}
	public int getCount() {
		return this.count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
