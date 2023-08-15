//import java.util.ArrayList;

/**
 * 3. Build instance variable and constructor for seat class
 * Seat: rows + columns
 * @author kew
 *
 */
public class Seat {
	/**
	 * 1. Instance variables: 3 vars
	 */
	
	int row;
	int column;
	Student studentInSeat; //Student assigned to this seat: ArrayList<Student> students;
	
	/**
	 * 2. Constructor:
	 */
	public Seat(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	/**
	 * 3. Method: put student in the seat
	 */
	public void putStudentInSeat(Student student) {
		this.studentInSeat= student;  //student to assign
	}
	
	/**
	 * 4. toString: Java knows how to represent a Seat as a string
	 */
	
	public String toString() {
		return this.row + ", " + this.column + ": " + this.studentInSeat;
		//return row, column, student for this seat
	}
}
