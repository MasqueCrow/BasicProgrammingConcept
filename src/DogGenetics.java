import java.util.Scanner;
import java.util.Random;

public class DogGenetics {
	public static void main(String[] args) {
		System.out.print("What is your dog's name? ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		System.out.println("Well then, I have this highly reliable report on " + input + "'s prestigious background right here.");
		System.out.println();
		System.out.println(input + " is:");
		
		String[] dogBreeds = { "St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman" };
		
		int[] dna = new int[5];
		int total = 100;
		Random r = new Random();
		
		for(int i = 1; i < dna.length; i++) {
			int breedValue = r.nextInt(1, total + 1);
			int bv = breedValue;
			dna[i-1] = bv;
			total -= breedValue;
		}
		
		// assign remaining percentage to last element that adds up to total
		dna[4] = total;
		
		for(int i = 0; i < dna.length; i++) {
			System.out.println(dna[i] + "%" + " " + dogBreeds[i]);
		}		
		
		System.out.println("Wow, that's QUITE the dog!");
	} //main
} //class
