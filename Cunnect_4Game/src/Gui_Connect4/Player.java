package Gui_Connect4;

import java.awt.Color;
import java.awt.Shape;

public class Player implements Comparable <Player>{

	private String playerName;
	private String playerSymbol;
	private Color playercolor;
	private int numGames;
	private int numWins;
	private int numLosses;
	//private Shape circle;

	public Player() {

		playerName = "";
		playerSymbol = "";
		numGames = 0;
		numWins = 0;
		numLosses = 0;
		playercolor = Color.BLACK;
	}
	public Player (String name, String symbol, Color playercolor) {

		numGames = 0;
		numWins = 0;
		numLosses = 0;
		playerName = name;
		playerSymbol = symbol;
		this.playercolor = playercolor;

	}
	public Color getPlayercolor() {
		return playercolor;
	}

	public void addNumWins() {
		numWins++;
		numGames++;

	}

	public void addNumLosses() {
		numLosses++;
		numGames++;

	}
	public void addDraw() {
		numGames++;

	}
	public int getNumWins() {
		return numWins;
	}
	public int getNumLosses() {
		return numLosses;
	}
	public int getNumGames() {
		return numGames;
	}
	public String getSymbol() {
		return playerSymbol;
	}
	public String getPlayerName() {
		return playerName;
	}

	public boolean equals (Object o) {
		if (o instanceof Player) {
			Player otherPlayer = (Player)o;
			if (this.playerName.equalsIgnoreCase(otherPlayer.playerName)){
				if (this.playerSymbol.equalsIgnoreCase(otherPlayer.playerSymbol)) {
					if(this.numGames== otherPlayer.numGames) {
						if(this.numLosses == otherPlayer.numLosses) {
							if(this.numWins == otherPlayer.numWins) {
								return true;
							}
						}
					}

				}

			}
		}
		return false;
	}

	@Override
	public int compareTo (Player otherP) {
		if (this.numWins> otherP.numWins) {
			return 1;
		}
		else if (this.numWins < otherP.numWins) {
			return -1;
		}
		return 0;
	}

}

