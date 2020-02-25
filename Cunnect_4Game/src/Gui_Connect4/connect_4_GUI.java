package Gui_Connect4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class connect_4_GUI extends JFrame{

	private Font font = new Font(Font.DIALOG, Font.ITALIC, 25);
	private JPanel mainBoard, scoreBoard;
	private JLabel scoreDisplay;
	private JLabel Chat;
	private JLabel turnMssg;
	Connect4Board jpBoard;

	private JButton[] clickButtons;
	private String bttnName[] = {"CLICK"};

	private Player currentPlayer;
	private Player Player1;
	private Player Player2;

	String connectX = JOptionPane.showInputDialog("Do you want to play Connect3,connect4,Connect5 or ConnectX? Please enter a number between 3 to 6!");
	int x = Integer.parseInt(connectX);
	public connect_4_GUI() {
		String playername1 = JOptionPane.showInputDialog("player1: Enater your Name!");
		String playername2 = JOptionPane.showInputDialog("player2: Enater your Name!");

		Player1 = new Player(playername1, "P1", Color.RED);
		Player2 = new Player(playername2, "P2", Color.BLUE);
		currentPlayer = Player1;

		mainBoard = new JPanel();

		mainBoard.setLayout(new BorderLayout());


		jpBoard = new Connect4Board();

		scoreBoard = new JPanel();
		scoreDisplay = new JLabel(Player1.getPlayerName()+ ": " + Player1.getNumWins()+ "     " + Player2.getPlayerName()+ ": " + Player2.getNumWins() + "   Total Games Played= "+0 );
		Chat = new JLabel("Hello! Lets play Connect"+ x);
		turnMssg = new JLabel("It's your turn: " + Player1.getPlayerName());
		scoreDisplay.setFont(font);
		Chat.setForeground(Color.RED);
		Chat.setFont(font);
		turnMssg.setFont(font);
		turnMssg.setForeground(Color.WHITE);
		scoreDisplay.setFont(font);
		scoreDisplay.setForeground(Color.WHITE);
		scoreBoard.add(scoreDisplay);
		scoreBoard.add(Chat);
		scoreBoard.add(turnMssg);


		add(scoreBoard, BorderLayout.SOUTH);
		scoreBoard.setBackground(Color.BLACK);
		scoreBoard.setLayout(new GridLayout(5,5));
		setVisible(true);

		mainBoard.add(BorderLayout.CENTER, jpBoard);
		add(mainBoard);
		setSize (700,700);
		setVisible (true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class Connect4Board extends JPanel implements Connect_4_Interface, Connect_4_Player_Interface, ActionListener{
		private JLabel [][] board;
		private  final int ROWS = 6;
		private final int COLS = 7;
		private int [] countDown = {5,5,5,5,5,5,5};
		

		


		public Connect4Board() {

			clickButtons = new JButton[7]; 
			for (int j= 0; j<clickButtons.length; j++) {
				clickButtons[j] = new JButton(bttnName[0]);
				clickButtons[j].addActionListener(this);
				add(clickButtons[j]);
			}

			setLayout (new GridLayout(ROWS+1, COLS));
			board = new JLabel [ROWS][COLS];
			displayBoard();
		}
		@Override

		public void actionPerformed(ActionEvent e) {
			turnMssg.setText("");



			JButton buttonclicked = (JButton) e.getSource();



			buttonclicked.setEnabled(true);

			if (buttonclicked.equals(clickButtons[0])) {

				if (currentPlayer.getPlayerName().equals (Player1.getPlayerName())) {

					Chat.setText("It's your turn: " + Player2.getPlayerName());

				}

				else if (currentPlayer.getPlayerName().equals (Player2.getPlayerName())) {

					Chat.setText("It's your turn: " + Player1.getPlayerName());

				}
			}

			if (buttonclicked.equals(clickButtons[1])) {

				if (currentPlayer.getPlayerName().equals (Player1.getPlayerName())) {

					Chat.setText("It's your turn: " + Player2.getPlayerName());

				}

				else if (currentPlayer.getPlayerName().equals (Player2.getPlayerName())) {

					Chat.setText("It's your turn: " + Player1.getPlayerName());

				}
			}

			if (buttonclicked.equals(clickButtons[2])) {

				if (currentPlayer.getPlayerName().equals (Player1.getPlayerName())) {

					Chat.setText("It's your turn: " + Player2.getPlayerName());

				}

				else if (currentPlayer.getPlayerName().equals (Player2.getPlayerName())) {

					Chat.setText("It's your turn: " + Player1.getPlayerName());

				}
			}

			if (buttonclicked.equals(clickButtons[3])) {

				if (currentPlayer.getPlayerName().equals (Player1.getPlayerName())) {

					Chat.setText("It's your turn: " + Player2.getPlayerName());

				}

				else if (currentPlayer.getPlayerName().equals (Player2.getPlayerName())) {

					Chat.setText("It's your turn: " + Player1.getPlayerName());

				}
			}

			if (buttonclicked.equals(clickButtons[4])) {

				if (currentPlayer.getPlayerName().equals (Player1.getPlayerName())) {

					Chat.setText("It's your turn: " + Player2.getPlayerName());

				}

				else if (currentPlayer.getPlayerName().equals (Player2.getPlayerName())) {

					Chat.setText("It's your turn: " + Player1.getPlayerName());

				}
			}

			if (buttonclicked.equals(clickButtons[5])) {

				if (currentPlayer.getPlayerName().equals (Player1.getPlayerName())) {

					Chat.setText("It's your turn: " + Player2.getPlayerName());

				}
				else if (currentPlayer.getPlayerName().equals (Player2.getPlayerName())) {

					Chat.setText("It's your turn: " + Player1.getPlayerName());

				}
			}

			if (buttonclicked.equals(clickButtons[6])) {

				if (currentPlayer.getPlayerName().equals (Player1.getPlayerName())) {

					Chat.setText("It's your turn: " + Player2.getPlayerName());

				}

				else if (currentPlayer.getPlayerName().equals (Player2.getPlayerName())) {

					Chat.setText("It's your turn: " + Player1.getPlayerName());

				}
			}


			for(int j= 0; j< 7; j++) {
				if ( clickButtons[j]==e.getSource()) {
					int rowToCol =countDown[j];
					board[rowToCol][j].setText(currentPlayer.getSymbol());
					board[rowToCol][j].setBackground(currentPlayer.getPlayercolor());
					board[rowToCol][j].setForeground(currentPlayer.getPlayercolor());


					countDown[j]--;

					if (countDown[j]<0) {
						clickButtons[j].setEnabled(false);

					}
				} 
			}

			int draw=0;
			if (isWinner()) {
				currentPlayer.addNumWins();

				JOptionPane.showMessageDialog(null, "WINNER = " + currentPlayer.getPlayerName());

				int response = JOptionPane.showConfirmDialog(null , "Do you wish to play again?" + JOptionPane.YES_OPTION);

				if (response == JOptionPane.NO_OPTION) {
					FileOutputStream fileByteStream = null; 

				      PrintWriter outFS = null;              



				      // file opening

				      try {

				fileByteStream = new FileOutputStream("Connect4-Results.txt");

				} catch (FileNotFoundException e1) {

				// TODO Auto-generated catch block

				e1.printStackTrace();

				}

				      outFS = new PrintWriter(fileByteStream);



				      

				      if (Player1.getNumWins() > Player2.getNumWins()) {

				      outFS.println("The CHAMPION IS : " + Player1.getPlayerName() + " " );

				      }

				      else if (Player2.getNumWins() > Player1.getNumWins()) {

				      outFS.println("The CHAMPION IS : " + Player2.getPlayerName() + " " );

				      }

				      else {

				      outFS.println("There is an overall draw");

				      }

				      outFS.println("Player1 has won: " + Player1.getNumWins()+" games");

				      outFS.println("Player2 has won: " + Player2.getNumWins()+" games");

				      outFS.flush();

				      //close the file

				      try {

				fileByteStream.close();

				} catch (IOException e1) {

				// TODO Auto-generated catch block

				e1.printStackTrace();

				} // close() may throw IOException if fails

					System.exit(0);

				}
				clearBoard();

			}

			else if (isFull()){

				draw++;

				JOptionPane.showMessageDialog(null, "Board is full! it's a draw!!");

				int response = JOptionPane.showConfirmDialog(null , "Do you wish to play again?" + JOptionPane.YES_NO_OPTION);

				if (response == JOptionPane.NO_OPTION) {
					FileOutputStream fileByteStream = null; // File output stream // Writing data to a file 

				      PrintWriter outFS = null;               // Output stream //writing info to my file created above



				      // Try to open file

				      try {

				fileByteStream = new FileOutputStream("Connect4-Results.txt");

				} catch (FileNotFoundException e1) {

				// TODO Auto-generated catch block

				e1.printStackTrace();

				}

				      outFS = new PrintWriter(fileByteStream);



				      // File is open and valid if we got this far (otherwise exception thrown)

				      // Can now write to file

				      if (Player1.getNumWins() > Player2.getNumWins()) {

				      outFS.println("The CHAMPION IS : " + Player1.getPlayerName() + " " );

				      }

				      else if (Player2.getNumWins() > Player1.getNumWins()) {

				      outFS.println("The CHAMPION IS : " + Player2.getPlayerName() + " " );

				      }

				      else {

				      outFS.println(" Overall draw");

				      }

				      outFS.println("Player1 has won: " + Player1.getNumWins()+" games");

				      outFS.println("Player2 has won: " + Player2.getNumWins()+" games");

				      outFS.flush();



				     

				      try {

				fileByteStream.close();

				} catch (IOException e1) {

				// TODO Auto-generated catch block

				e1.printStackTrace();

				} // close() may throw IOException if fails

					System.exit(0);
					
				}
				clearBoard();

			}
			int totalGamesPlayed = Player1.getNumGames() + Player2.getNumGames()+ draw;
			scoreDisplay.setText(Player1.getPlayerName()+ ": " + Player1.getNumWins()+ "     " + Player2.getPlayerName()+ ": " + Player2.getNumWins() + "   Total Games Played= "+totalGamesPlayed+ "   Draw = " + draw);

			takeTurn();
		}
		@Override
		public boolean isWinner() {
			if(isWinnerInRow() || isWinnerInCol() || isWinnerInUpwardDiag() || isWinnerInDownwardDiag()) {
				return true;
			}
			return false;
		}

		public boolean isWinnerInRow() {
			String symbol = currentPlayer.getSymbol();
			for (int row = 0; row< board.length; row++) {
				int numMatchesInRow = 0 ; // this will reset on the next row
				for( int col = 0; col< board[row].length; col++) {
					if (board [row][col].getText().trim().equalsIgnoreCase(symbol)) {
						numMatchesInRow++;
						if (numMatchesInRow ==x) {
							return true;
						} 
					} 
					else {
						numMatchesInRow=0;
					}
				}

			}
			return false;
		} 

		public boolean isWinnerInCol() {
			String symbol = currentPlayer.getSymbol();
			for (int col =0; col<7; col++) {
				int numMatchesInCol = 0 ;
				for (int row = 0; row <6; row++) {
					if (board[row][col].getText().trim().equalsIgnoreCase(symbol)) { //this will scan for symbol in the grid
						numMatchesInCol++;
						if (numMatchesInCol ==x) {
							return true;
						}
					}
					else {
						numMatchesInCol = 0;
					}
				}
			}
			return false;
		} 

		public boolean isWinnerInUpwardDiag() {
			String symbol = currentPlayer.getSymbol();
			int matchesInUpwardDiag = 0;
			int row = board.length-1;
			int col = 0;
			for (int i = board.length-1; i >=0; i--) {
				row = i;
				col = 0;
				matchesInUpwardDiag = 0;
				while(row<board.length && col <board[row].length) {
					if( board[row][col].getText().trim().equalsIgnoreCase(symbol)) {
						matchesInUpwardDiag++;		
					}
					else {
						matchesInUpwardDiag = 0;
					}
					if(matchesInUpwardDiag ==x) {
						return true;
					}
					col++;
					row--;
					if (row<0) {
						row = 0;
						break;
					}
				}
			}

			for (int j = 0; j<board[row].length; j++) {
				col = j;
				row = board.length-1;
				matchesInUpwardDiag = 0;
				while( row<board.length && col <board[row].length) {
					if(board[row][col].getText().trim().equalsIgnoreCase(symbol)) {
						matchesInUpwardDiag++;
					}
					else {
						matchesInUpwardDiag = 0;
					}
					if (matchesInUpwardDiag == x) {
						return true;
					}
					row--;
					col++;
					if(row<0) {
						row =0;
						break;
					}
				}
			}
			return false;
		} 

		public boolean isWinnerInDownwardDiag() {
			String symbol = currentPlayer.getSymbol();
			int matchesInDownwardDiag = 0;
			int row = 0;
			int col =0;
			for(int showRow = 0; showRow < board.length; showRow++) {
				row = showRow;
				col = 0;
				matchesInDownwardDiag = 0;
				while(row<board.length && col < board[row].length) {
					if(board[row][col].getText().trim().equalsIgnoreCase(symbol)) {
						matchesInDownwardDiag++;
					}else {
						matchesInDownwardDiag=0;
					}
					if(matchesInDownwardDiag ==x) {
						return true;
					}
					row++;
					col++;
				}

			}
			row = 0;
			for(int showCol = 0; showCol < board[row].length; showCol++) {
				row = 0;
				col = showCol;
				matchesInDownwardDiag = 0;
				while(row< board.length && col < board[row].length) {
					if(board[row][col].getText().trim().equalsIgnoreCase(symbol)) {
						matchesInDownwardDiag++;
					}else {
						matchesInDownwardDiag =0;
					}
					if(matchesInDownwardDiag ==x) {
						return true;
					}
					row++;
					col++;
					if(row>5) {
						row =5;
						break;
					}
				}
			}
			return false;
		}    


		@Override
		public void takeTurn() {
			if (currentPlayer.equals(Player1)) {
				currentPlayer = Player2;
			}
			else {
				currentPlayer = Player1;
			}
		}
		@Override
		public void displayBoard() {

			Font bigFont = new Font (Font.DIALOG, Font.ITALIC, 50);
			Font buttonFont = new Font(Font.DIALOG, Font.BOLD, 20);
			Border coolBorder = BorderFactory.createLineBorder(Color.BLACK);



			for(int col = 0; col<clickButtons.length; col++) {
				clickButtons[col].setOpaque(true);
				clickButtons[col].setBackground(Color.GREEN);
				clickButtons[col].setFont(buttonFont);
				add(clickButtons[col]);
			}

			for(int row= 0; row<board.length; row++) {
				for (int col= 0; col<board[row].length; col++) {
					board[row][col]= new JLabel();
					board[row][col].setOpaque(true);
					board[row][col].setBackground(Color.GREEN);
					board[row][col].setFont(bigFont);
					board[row][col].setBorder(coolBorder);
					board[row][col].setHorizontalAlignment((int) CENTER_ALIGNMENT);
					add(board[row][col]);

				}

			}

		}
		@Override
		public void clearBoard() {
			for(int row = 0; row<board.length; row++) {
				for (int col = 0 ; col<board[row].length; col++) {
					board[row][col].setText("");
					board[row][col].setEnabled(true);

					board[row][col].setBackground(Color.GREEN);

				}
			}
			for (int i =0; i<7; i++) {
				countDown[i] = 5;
				clickButtons[i].setEnabled(true);
			}

		}
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isFull() {
			for (int row = 0; row<board.length; row++) {
				for (int col = 0; col<board[row].length; col++) {
					String cellContent = board[row][col].getText().trim();
					if(cellContent.isEmpty()) {
						return false;
					}
				}

			}
			return true;
		}


	}


}
