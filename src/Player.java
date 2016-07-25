import java.util.ArrayList;
import java.util.Random;

public class Player {
	
	boolean WIN = false;
	int mark=0;
	
	/**
	 * Constructor
	 * @param Player object player
	 */
	public Player(int player) {
		if(player==1)
			this.mark=1;
		if(player==2)
			this.mark=-1;
	}
	
	
	/**
	 * Method to play at position
	 * @param int position 
	 * @param Board board
	 * @return boolean false if invalid
	 */
	public boolean playChance(int position,Board board) {
		if(board.putAtPosition(mark, position)) {
			Rule rule = new Rule();
			if(rule.isWon(board.state)) {
				WIN = true;
			}
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * Method to play random
	 * @param board Board Object
	 */
	public void playByRandom(Board board) {
		ArrayList<Integer> tmp = board.getBlankPositions();
		int random = new Random().nextInt(tmp.size());
		playChance(tmp.get(random), board);
	}
}
