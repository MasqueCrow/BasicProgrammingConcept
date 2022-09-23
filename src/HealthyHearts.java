import java.util.InputMismatchException;
import java.util.Scanner;

public class HealthyHearts {

	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			System.out.print("What is your age? ");
			sc = new Scanner(System.in);
			int age = sc.nextInt();
			
			int maxHeartRate =  220 - age;
			int minRange =  (int) Math.round((0.5 * maxHeartRate));
			int maxRange =  (int) Math.round((0.85 * maxHeartRate));
		
			System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
			System.out.println("Your target HR Zone is " + minRange + " - " + maxRange + " beats per minute" );
		
		} 
		catch(InputMismatchException e) {
			System.out.println("Invalid input. Please type your age.");
		}
		finally {
			sc.close();
		}
	}
}
