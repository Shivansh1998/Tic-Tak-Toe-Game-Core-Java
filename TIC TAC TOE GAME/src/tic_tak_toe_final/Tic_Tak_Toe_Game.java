package tic_tak_toe_final;
import java.util.Scanner;

public class Tic_Tak_Toe_Game {
	private Player player1, player2;
	private Board board;
	static public boolean anotherGame = true;
	static public int No_of_Games = 0;
	static public int Draw = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		No_of_Games++;
		System.out.println("\t\t\t TIC TAC TOE GAME : ");
		Tic_Tak_Toe_Game t = new Tic_Tak_Toe_Game();
		t.startGame();
		while (anotherGame) {
			t.create_Board();
			No_of_Games++;
		}
	}

	public void startGame() {

		// Player input then Create Board
		player1 = take_player_info(1);
		player2 = take_player_info(2);
		while (player1.getName().compareTo(player2.getName()) == 0) {
			System.out.println("Name already taken !! Choose another name for Player 2 !!");
			System.out.println("Enter Player 2's name :");
			player2.setName(sc.nextLine());
		}
		while (player1.getSymbol() == player2.getSymbol()) {
			System.out.println("Symbol already taken !! Choose another Symbol for Player 2 !!");
			System.out.println("Enter Player 2's Symbol :");
			player2.setSymbol(sc.nextLine().charAt(0));
		}
	}

	public void create_Board() {
		// Create board
		board = new Board(player1.getSymbol(), player2.getSymbol());
		System.out.println();
		System.out.println("Tic Tac Toe Board : 3x3 Board");
		board.print();

		// Conduct Game
		int status = Board.INCOMPLETE;
		boolean Player1_turn = true;
		while (status == Board.INCOMPLETE || status == Board.INVALID) {
			if (Player1_turn) {
				System.out.println("Player 1 " + player1.getName() + "'s Turn :");
				System.out.println("Enter row :");
				int x = sc.nextInt();
				System.out.println("Enter col :");
				int y = sc.nextInt();
				status = board.status_of_game(player1.getSymbol(), x, y);
				if (status != Board.INVALID) {
					Player1_turn = false;
					board.print();
				} else {
					System.out.println("!!!!!! INVALID MOVE !!!!!");
				}

			} else {
				System.out.println("Player 2 " + player2.getName() + "'s Turn :");
				System.out.println("Enter row :");
				int x = sc.nextInt();
				System.out.println("Enter col :");
				int y = sc.nextInt();
				status = board.status_of_game(player2.getSymbol(), x, y);
				if (status != Board.INVALID) {
					Player1_turn = true;
					board.print();
				} else {
					System.out.println("!!!!!! INVALID MOVE !!!!!");
				}
			}
		}
		if (status == Board.PLAYER_1_WINS) {
			player1.setWinGames();
			System.out.println("PLAYER 1 " + player1.getName() + " wins !!!!!!");
		} else if (status == Board.PLAYER_2_WINS) {
			player2.setWinGames();
			System.out.println("PLAYER 2 " + player2.getName() + " wins !!!!!!");
		} else {
			Draw++;
			System.out.println("DRAW !!!!!!");
		}
		System.out.println();
		printStatus();
		sc.nextLine();
		System.out.println("Want to play a new Game ? (Enter Y/N)");
		if ('N' == sc.nextLine().charAt(0)) {
			anotherGame = false;
		}
	}

	private void printStatus() {
		// Score Board
		System.out.println("\tSCORE BOARD");
		System.out.println("Total number of games = " + No_of_Games);
		System.out.println(player1.getName() + " won " + player1.getWinGames() + " times");
		System.out.println(player2.getName() + " won " + player2.getWinGames() + " times");
		System.out.println("Number of tied games = " + Draw);
	}

	private Player take_player_info(int n) {
		// Getting info of player
		System.out.println("Enter Player " + n + "'s name :");
		String name = sc.nextLine();
		System.out.println("Enter Player " + n + "'s Symbol :");
		char symbol = sc.nextLine().charAt(0);
		Player p = new Player(name, symbol);
		return p;
	}
}