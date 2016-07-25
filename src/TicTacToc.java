import java.util.Scanner;

public class TicTacToc {

	public static void main(String[] args) {
		TicTacToc game = new TicTacToc();
		Player p1 = new Player(1);
		Player p2 = new Player(2);
		Board board = new Board(p1,p2);
		int automatic=-1;
		
		//To select 1 player or 2 player
		System.out.println("Enter 1 for two player\n2 for one player");
		while(true) {
			automatic = game.getIntfromUser("Choice");
			if(automatic==1||automatic==2) {
				break;
			}
			else{
				System.out.println("Try Again");
			}
		}
		
		
		System.out.println(board.getBoard());
		for(;;)
		{
			int position;
			//P1 Chance
			while(true) {
				position=game.getIntfromUser("P1");
				if(p1.playChance(position, board)){
					break;
				}
				else{
					System.out.println("Invalid Move, Try Again");
				}
			}
			System.out.println(board.getBoard());
			
			//Check if P1 wins
			if(p1.WIN) {
				System.out.println("P1 Win");
				break;
			}
			
			//Check for draw game
			if(board.isFull()) {
				System.out.println("Game Draw");
				break;
			}
			
			//P2 Chance 
			//by Player 2
			if(automatic==1) {
				while(true) {
					position=game.getIntfromUser("P2");
					if(p2.playChance(position, board)){
						break;
					}
					else{
						System.out.println("Invalid Move, Try Again");
					}
				}
			}
			//By random
			else{
				p2.playByRandom(board);
			}
			System.out.println(board.getBoard());
			
			//Check if P2 wins
			if(p2.WIN) {
				System.out.println("P2 Win");
				break;
			}
		}
	}
	
	
	/**
	 * Method to read integer data from standard input
	 * @param Name of variable to print 
	 * @return int value of integer
	 */
	public int getIntfromUser(String Name) {
		Scanner s= new Scanner(System.in);
		int number = -1;		
		while(true){
			try {
				System.out.println("Enter "+Name);
				number=s.nextInt();
				if(number>=0){
					break;
				}
				else{
					System.out.println("Invalid, Try Again");
				}
			} catch (Exception e) {
				System.out.println("Invalid, Try again");
				s.next();
			}
		}
		return number;
	}



}
