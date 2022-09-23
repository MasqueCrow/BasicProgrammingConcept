import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import com.myexception.IncorrectNumOfRoundsException;

public class RockPaperScissors {
	// 1 = Rock, 2 = Paper, 3 = Scissors
	// returns 1 if user win, 0 = tie and -1 = user lose
	public static int compareHand(int user, int com) {
		//check for invalid hand
		if(user > 3 || user < 1 || com > 3 || com < 1 )
			return -2;
		
		if(user == com) {
			return 0;
		}
		// user choose rock
		else if(user == 1) {
			if(com == 2) {
				return -1;
			}
			else {
				return 1;
			}
		}
		// user choose paper
		else if(user == 2) {
			if(com == 3) {
				return -1;
			}
			else {
				return 1;
			}
		}
		// user choose scissors
		else if (user == 3) {
			if(com == 1) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
		return -2;
	} //compareHand
		
	public static int promptUser(Scanner input) {
		int user_choice;
	
		do {
			System.out.println("Pick a number. (1 = Rock, 2 = Paper, 3 = Scissors)");
			user_choice = input.nextInt();	
			
			if(user_choice < 1 || user_choice > 3) {
				System.out.println("Invalid choice. Please try again.");
			}
		} while(user_choice < 1 || user_choice > 3);

		return user_choice;
	}	

	public static String displayChoice(int hand) {
		if(hand == 1) {
			return "Rock";
		}
		else if(hand == 2) {
			return "Paper";
		}
		else if(hand == 3) {
			return "Scissors";
		}
		return "";
	}
	
	public static void main(String[] args) throws IncorrectNumOfRoundsException {
		int draw = 0;
		int com_win = 0;
		int user_win = 0;
		int num_rounds = 0;
		int user_choice;
		int com_choice;
		int result;
		Scanner input = null;
	
		try {
			System.out.print("How many rounds would you like to play? ");
			input = new Scanner(System.in);
			num_rounds = input.nextInt();
		} 
		catch(InputMismatchException e) {
			System.out.println("Invalid input. Please specify no. of rounds..");
		}
	
		while (num_rounds != 0) {	
			try{		
				if(num_rounds >= 0 && num_rounds <= 10) {
					user_choice = promptUser(input);
					Random r = new Random();
					com_choice = r.nextInt(1, 4);
					result = compareHand(user_choice, com_choice);
					
					System.out.println("User pick: " + displayChoice(user_choice));
					System.out.println("Computer pick: " + displayChoice(com_choice));
					
					if(result == 1) {
						user_win += 1;
						System.out.println("User has won this round");
					}
					else if(result == -1) {
						com_win += 1;
						System.out.println("Computer has won this round");
					}
					else if(result == 0){
						draw += 1;
						System.out.println("This round is a tie");
					} //else

					//check all rounds have been completed to terminate the game
					if(num_rounds == 0) {
						break;
					} //if
				} //if
				
				else {
					input.close();
					throw new IncorrectNumOfRoundsException("Invalid num of rounds. Round should be between (1-10).");
				}
				num_rounds -= 1;
			} //try
			catch(IncorrectNumOfRoundsException e) {
				System.out.println(e.getMessage());
				System.out.println("Run the program again to start the game...");
				break;
			} //catch

		} //while 
		
		input.close();
		System.out.println();
		System.out.println("==========Outcome==========");
		System.out.println("Draw: " + draw);
		System.out.println("com_win: " + com_win);
		System.out.println("user_win: " + user_win);
		
	} //main 
} //class
