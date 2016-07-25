
public class Rule {
	
	int CROSS = -1;
	int BLANK = 0;
	int ZERO = 1;
	
	/**
	 * Method to check win conditions
	 * @param Board board
	 * @return boolean true if any condition is true
	 */
	public boolean isWon(int[] board) {
		if(areSame(board, 0, 1, 2)){
			return true;
		}
		if(areSame(board, 3, 4, 5)){
			return true;
		}
		if(areSame(board, 6, 7, 8)){
			return true;
		}
		if(areSame(board, 0, 3, 6)){
			return true;
		}
		if(areSame(board, 1, 4, 7)){
			return true;
		}
		if(areSame(board, 2, 5, 8)){
			return true;
		}
		if(areSame(board, 0, 4, 8)){
			return true;
		}
		if(areSame(board, 2, 4, 6)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Method to check positions have same mark & not blank
	 * @param Board board 
	 * @param int position1
	 * @param int position2
	 * @param int position3
	 * @return boolean true if position1,position2 & position3 have same mark
	 */
	public boolean areSame(int[] board,int position1,int position2, int position3) {
	
		if(areNotBlank(board, position1, position2, position3)) {
			if(board[position1]==board[position2] && board[position2]== board[position3]) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Method to check any of position is Blank
	 * @param Board board 
	 * @param int position1
	 * @param int position2
	 * @param int position3
	 * @return boolean true if position1,position2 & position3 are not blank
	 */
	public boolean areNotBlank(int[] board,int position1,int position2, int position3 ) {
		if(board[position1]!=BLANK && board[position2]!=BLANK && board[position3]!=BLANK) {
			return true;
		}
		return false;
	}
}
