import java.util.ArrayList;


public class Board {
	int CROSS = -1;
	int BLANK = 0;
	int ZERO = 1;
	
	int[] state = new int[9];
	
	/**
	 * Constructor
	 * @param Player one
	 * @param Player two
	 */
	public Board(Player one,Player two) {
		for(int i=0;i<9;i++){
			state[i]=BLANK;
		}
	}
	
	
	/**
	 * To check board is full
	 * @return true if full
	 */
	public boolean isFull() {
		for (int i : state) {
			if(i==BLANK){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * To check position is blank
	 * @param int position 
	 * @return boolean true if blank
	 */
	public boolean isBlank(int position) {
		if(state[position]==BLANK) {
			return true;
		}
		else {
			return false;
		}
	}
	

	/**
	 * To get blank positions
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getBlankPositions() {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i=0;i<9 ;i++) {
			if(isBlank(i)) {
				output.add(i);
			}
		}
		return output;
	}
	
	
	/**
	 * To put mark at position
	 * @param int input mark 
	 * @param int position
	 * @return boolean true if done else invalid
	 */
	public boolean putAtPosition(int input,int position) {
		if(position<9&&position>=0&&isBlank(position)) {
			state[position] = input;
			return true;
		}
		else {
			return false; 
		}
	}
	
	
	/**
	 * To get board as String
	 * @return String
	 */
	public String getBoard() {
		String output= "";
		for (int i = 1; i <= state.length; i++) {
			output = output + getStringbyPosition(i-1)+ "\t";
			if(i%3==0) {
				output = output + "\n";
			}
		}
		return output;
	}
	
	
	/**
	 * To get mark of a position as String 
	 * @param int position
	 * @return String
	 */
	private String getStringbyPosition(int i) {
		String tmp;
		switch (state[i]) {
		case -1:
			tmp = "X";
			break;
		case 1:
			tmp = "O";
			break;
		default:
			tmp =  String.valueOf(i);
			break;
		}
		return tmp;
	}
	
}
