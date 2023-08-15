import java.util.ArrayList;


/**
 * Represent a classroom with students
 * Each classroom has a list of students
 * an Array that represents the seats in classroom
 * @author kew
 *
 */


public class Classroom {
	
	/**
	 * 1. Instance variable: 
	 */
	
	String buildingName; //name of building
	String roomName; // name of classroom
	
	//List of student in classroom:
	ArrayList<Student> students;
	
	//Seats in classroom
	Seat[][] seats;
	
	/**
	 * 2. Constructor: 
	 */
	
	/**
	 * Create a classroom with
	 * @param buildingName
	 * @param roomName
	 * @param rows
	 * @param columns
	 */
	
	public Classroom(String buildingName, String roomName, int rows, int columns) {
		
		this.buildingName = buildingName;        //set building name
		this.roomName = roomName;                //set room name
		this.seats = new Seat[rows][columns];    //initialize seats array
		
		//populate 2-D array of seats:
			for (int i =0; i< rows; i++) {             //iterate over rows
				for (int j = 0; j<columns; j++) {      //iterate over columns
					//give each location its own new instance of seat class
					seats[i][j] = new Seat(i, j);    //update vars for seat(row, column)
				}
			}
			
	 //initialize the ArrayList for students
		this.students = new ArrayList<Student>();
	}
	
	/**
	 * 3. Method: 
	 * 		Add students to the Class
	 * 		Assign students to a Seat
	 */
	
	//M1: Add student to a list of student:
	public void addAStudent(Student student) {
		this.students.add(student);
	}
	//M2: assign student to seat in the class: finds an available seat and assign student
	public void addStudentInSeat(Student student) {
		
		//instance variable:
		int rows = this.seats.length;
		int columns = this.seats[0].length; //seats[0] is the first row 
		
		//Iterate over rows and columns of seats and visit each seat:
		for (int i=0; i< rows; i++) {
			for (int j=0; j<columns; j++) {
				
				//check available seats: get seat in location
				if(this.seats[i][j].studentInSeat == null) { //null: no student has been assigned to it
					
					this.seats[i][j].putStudentInSeat(student);
					return; //exist loop
				}
			}
		}
	}
	//M3: print all students
	public void printAllStudent() {
		System.out.println("Student in class: ");
		
		for(Student student: this.students) {
			System.out.println(student); //ToString student class
		}
	}
	//M4: Print an entire classroom use toString:
	
	public String toString() {
		String s = "\n"; //new line
		//seat array, rows, columns, and seat  in each location:
		int rows = this.seats.length;
		int columns = this.seats[0].length;
		
		for (int i=0; i< rows; i++) {
			for (int j=0; j<columns; j++) {
				s+= this.seats[i][j] + "\t"; // toString method in the seat class
			}
			s+= "\n"; //add new line at end of each row
		}
		return s;
	}
	
	
	
	public static void main(String[] args) {
		//1. classroom
		Classroom hunstman = new Classroom("HH", "105", 10, 5);
		
		//2. create student to add in classroom:
		Student finegan = new Student("finegan", "fnga");
		Student kew = new Student("Van", "svhn");
		
		//3. add students to classroom
		hunstman.addAStudent(finegan);
		hunstman.addAStudent(kew);
		
		//4. assign student to seats:
		hunstman.addStudentInSeat(finegan);
		hunstman.addStudentInSeat(kew);
		
		//5. print list of all student in class:
		hunstman.printAllStudent();
		
		//6. print classroom itself:
		System.out.println(hunstman);

	}

}
