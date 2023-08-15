package polymorphism;

public class Dog {

	/**
	 * 1. Static variables:
	 */
	
	static String DEFAULT_NAME = "Generic Dog"; //Default name
	
	static double DEFAULT_AGE = .5; //DEfault age
	
	static double DEFAULT_WEIGHT = 1.75; //Default weight
	
	static String DEFAULT_FOOD = "Generic dog food";
	
	static String DEFAULT_BANK = "Bark"; //Default sound for dog to make
	
	static int DEFAULT_TIMES_BARK = 1; //default nume of times for dog to bark
	
	static final double WEIGHT_GAIN_INCREASE = 0.01; //cannot change
	
	/**
	 * 2. Instance variables:
	 */
	
	String name;
	double age;
	String owner;
	double weight;
	
	/**
	 * 3. Constructor for creating a dog:
	 */
	
	//Constructor 1: set up the dog
	public Dog(String name, double age, String owner, double weight) {
		this.name = name;
		this.age = age;
		this.owner = owner;
		this.weight = weight;
	}
	
	//constructor 2: overload first constructor (Same name, different arguments)
	public Dog(String name, double age) {
		this(name, age, null, Dog.DEFAULT_WEIGHT); //2 given values and 2 DEFAULTS values
	}
	
	//constructor 3: Create generic dog -> overload constructor again without argument
	public Dog() {
		this(Dog.DEFAULT_NAME, Dog.DEFAULT_AGE);  //call the second constructor with two arguments (default values)
	}
	
	/**
	 * 4. Methods: need return for methods
	 */
	//method 1: eat
	public double eat(double amount, String food) { //given amount, and food
		System.out.println(this.name + " is eating " + amount + " of " + food);
		
		//calcualte the weight gain
		double weightGained = Dog.WEIGHT_GAIN_INCREASE * amount;
		this.weight += weightGained;
		
		return this.weight; //need to return otherwise with error
	}
	 
	//create another method with same name, different parameter:
	//overload for the first method
	 public double eat(double amount) {
		//first version of eat method: given amount and default dog food
		return this.eat(amount, Dog.DEFAULT_FOOD);
	}
	 
	//third version of the eat methods:
	 public double eat(String amount) { //different data types
		
		 double returnVal = 0.0;
		 
		 //try the followingcode, but we could get an exception:
		 try {
			 //parse given amount as a double
			 double amountAsDouble = Double.parseDouble(amount);
		 
			 returnVal = this.eat(amountAsDouble); //call second version of eat method
		 } catch(NumberFormatException e) {
			 System.out.println(amount + ": cannot be parsed as double.");
		 }
		 
		 return returnVal;
	 }
	 
	 //method2: bark:
	 public void bark(int numTimes, String barksound) { //given number of times and bark sound 
		 
		 //print dog name:
		 System.out.println(this.name + " says: ");
		 
		 for (int i=0; i< numTimes; i++) {
			 System.out.println(barksound);
		 }
		 System.out.println();
	 }
	
	 //overload the first method of bar: call the first bark method from the second
	 public void bark(String barksound, int numTimes) {
		 
		 //call the first bark method from the second 
		 this.bark(numTimes, barksound); //with given number of times and given bark sound
	 }
	 //overload bark method one more times: without parameters
	 public void bark() {
		 
		 //bark given default number of time and default bark sound
		 this.bark(Dog.DEFAULT_TIMES_BARK, Dog.DEFAULT_BANK);
	 }
	 
	 //method 3: weight
	 public double getWeight() {
		 return this.weight;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public void setOwner(String owner) {
		 this.owner = owner;
	 }
	 
	 //print the full string: representing this dog
	 public String toString() {
		 return this.name + ", " + this.weight + ", " + this.age + ", " + this.owner;
	 }
	 
	 
	public static void main(String[] args) {
		
		//Create dog using first constructor
		Dog dog1 = new Dog("Princess", 12.7, "Brandon", 9.3); //public Dog(String name, double age, String owner, double weight)
		
		//using second constructor
		Dog dog2 = new Dog("Fido", 5.5);  //public Dog(String name, double age)
		
		//using the third constructor
		Dog dog3 = new Dog(); //public Dog()
		
		//print dogs:
		System.out.println(dog1);
		System.out.println(dog2);
		System.out.println(dog3);
		
		//set new name for dog 3:
		System.out.println();
		dog3.setName("Samantha");
		System.out.println(dog3);
		
		//call the first eat method:
		System.out.println();
		System.out.println(dog1.eat(2.1, "Beneful")); //public double eat(double amount, String food)
		
		//call second eat method: print new weight
		System.out.println();
		System.out.println(dog2.eat(1.1));
		
		//call the second eat method with int: print new weight
		System.out.println();
		System.out.println(dog3.eat(1));
		
		//call third eat method with string that can be parsed as double
		System.out.println();
		System.out.println(dog3.eat("12.3"));
		
		//call third eat method with string cannot be parsed as doubles
		System.out.println();
		System.out.println(dog3.eat("two"));
		
		//print dog's weight
		System.out.println("the dog's weight: ");
		System.out.println(dog3.getWeight());
		
		//call the bark method:
		System.out.println("the first bark method: ");
		dog1.bark(2, "woof");
		System.out.println("the second: bark method: ");
		dog1.bark("Help me!", 1);
		System.out.println("the third bark method: ");
		dog1.bark();
		
		
	}

}
