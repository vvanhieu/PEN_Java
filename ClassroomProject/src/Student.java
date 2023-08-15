/**
 * represent student in the class
 * Student: name + ID
 * @author kew
 *
 */
public class Student {
	/**
	 * 1. Instance variables:
	 */
	String name;
	String studentId;
	
	/**
	 * 2. Constructor:
	 */
	public Student(String name, String studentId) {
		this.name = name;
		this.studentId = studentId;
	}
	
	/**
	 * 3. toString method:
	 */
	public String toStrint() {
		return this.name;
	}
}
