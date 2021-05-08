public class Board {
	private char board[][];
	private final int BOARD_SIZE = 3;
	private char p1Symbol, p2Symbol;
	private int count;
	public final static int PLAYER_1_WINS = 1;
	public final static int PLAYER_2_WINS = 2;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALID = 5;

	public Board(char p1Symbol, char p2Symbol) {
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
		this.board = new char[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public int status_of_game(char symbol, int x, int y) {

		// check invalid
		if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE || board[x][y] != ' ') {
			return INVALID;
		}

		// turn
		board[x][y] = symbol;
		count++;

		// check row
		if (board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		// check col
		if (board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		// check diagonal 1
		if (board[x][y] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		// check diagonal 2
		if (board[1][1] != ' ' && board[1][1] == board[0][2] && board[1][1] == board[2][0]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		// check draw
		if (count == BOARD_SIZE * BOARD_SIZE) {
			return DRAW;
		}
		return INCOMPLETE;
	}

	public void print() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
	}

}
