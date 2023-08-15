
package homework_week1;
import java.util.Scanner;

public class simplegame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("1. Convert time");
		System.out.println("2. Calculate the sum of all digits in an integer");
		
		System.out.println();
		System.out.println("Which game you want to play?");
		
		System.out.println();
		int option = input.nextInt();
		
		System.out.println();
		switch (option) {
		case 1: 
			System.out.println("How many number of second you want to convert?");
			int second = input.nextInt();
			
			int s = second % 60;
			int m = (second / 60) % 60;
			int h = (second / 60) / 60;
			
			System.out.println("Your number of seconds is: " + second);
			System.out.println("the time is " + h+":"+m+":"+s);
			break;
		case 2: 
			System.out.println("Enter integer number you want to calculate sum: ");
			int number = input.nextInt();
			
			int sum = 0;
			while (number > 0) {
				sum = sum + number % 10;
				number = number / 10;
			}
			System.out.println();
			System.out.println("The sum of all digits is " + sum);
			break;
		}
		
	}

}
