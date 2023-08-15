
public class Counter_multipleConstructor {

	int count; //internal vars
	
	//Constructor: start the internal count at a given start value
	public Counter_multipleConstructor(int start) {
		this.count = start;
	}
	
	//Constructor: starts internal counter at 0
	public Counter_multipleConstructor() {
		this.count = 0;
	}
	
	public static void main(String[] args) {
		// create a counter:
		Counter_multipleConstructor counter1 = new Counter_multipleConstructor(2);
		System.out.println(counter1.count);
		
		Counter_multipleConstructor counter2= new Counter_multipleConstructor();
		System.out.println(counter2.count);

	}

}
