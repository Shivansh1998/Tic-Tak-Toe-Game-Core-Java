package tic_tak_toe_final;
public class Player {
	private String name;
	private char symbol;
	private int winGame;
	
	public Player() {
		name=null;
		symbol='\0';
		winGame=0;
		}
	
	public Player(String name, char symbol) {
		setName(name);
		setSymbol(symbol);
	}

	public void setName(String name) {
		if (!name.isEmpty()) {
			this.name = name;
		}
	}

	public void setSymbol(char symbol) {
		if (symbol != '\0') {
			this.symbol = symbol;
		}
	}

	public String getName() {
		return this.name;
	}


	public int getWinGames() {
		return this.winGame;
	}
	
	public void setWinGames() {
		this.winGame++;
	}

	public char getSymbol() {
		return this.symbol;
	}
}
